package TestScenarios;

import Objects.GoogleSearch;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import java.time.Duration;

public class GoogleSearchMethods {
    WebDriver driver;
    GoogleSearch objectPage;


   // @BeforeTest
    public void beforetest(){
        System.setProperty("webdriver.chrome.driver","C:\\M2\\chromedriver-win64\\chromedriver.exe" );
         driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://www.google.com");
    }

   // @Test
    public void searchOperation(){
        GoogleSearch page = new GoogleSearch(driver);
        page.searchGoogle("selenium");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
   // @Test
    public void selectSearchInput(){
        objectPage = new GoogleSearch(driver);
        objectPage.searchlist("selenium");
     }



  /*  @AfterTest
    public void aftertest(){
        driver.quit();
    }*/
}
