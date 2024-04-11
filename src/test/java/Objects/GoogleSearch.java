package Objects;

import io.cucumber.java.en.And;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GoogleSearch {
    WebDriver driver;
    public GoogleSearch(WebDriver driver){
        this.driver=driver;
    }

    By searchbox= By.xpath("//div[@class='a4bIc']//textarea");
    By searchList = By.xpath("//ul[@role='listbox']//li/descendant::div[@class='pcTkSc']");


    public void searchGoogle(String searchInput){
        try {
            driver.findElement(searchbox).sendKeys(searchInput);
        } catch (Exception e) {
            System.out.println((" Exception caught" +  e.getMessage()));
        }
    }

    public void searchlist(String searchInput){
       try {
           List<WebElement> list = driver.findElements(searchList);

           System.out.println(" Number of search lists: " + list.size());
           for (int i = 0; i < list.size(); i++) {
               System.out.println("Search results are: " + list.get(i).getText());
               if (list.get(i).getText().contains(searchInput)) {
                   list.get(i).click();
                   break;
               }

           }
       } catch(Exception e){
           System.out.println(" Exception caught " + e.getMessage());
       }
    }
}
