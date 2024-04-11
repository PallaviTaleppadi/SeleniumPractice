package stepDefinations;

import Objects.GoogleSearch;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import java.time.Duration;

public class GoogleSearchSteps {
    WebDriver driver;
    GoogleSearch objectPage;

    @Given("Launch google website")
    public void launchURL(){
        System.setProperty("webdriver.chrome.driver","C:\\M2\\chromedriver-win64\\chromedriver.exe" );
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("http://www.google.com");
        driver.manage().window().maximize();

    }
    //@When("User search for text")
    @When("User search for {string}")
    public void searchOperation(String inputData){
        GoogleSearch page = new GoogleSearch(driver);
        page.searchGoogle("selenium");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @Then("User select the right result")
//    @Then("Correct page is opened")
    public void selectSearchInput(){
        objectPage = new GoogleSearch(driver);
        objectPage.searchlist("selenium");
    }



  /*  @AfterTest
    public void aftertest(){
        driver.quit();
    }*/
}
