import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SeleniumDemo {

    public static String imageGrid = "//div[@class='liYKde g VjDLd']//div[@class='osrp-blk']";
    public static String imageButton = "//g-popup[@class='eNRwyf']/div[@role ='button']";
    public static String imageMenu ="//div[@jsname='V68bde']//g-menu[@jsname='iXXGtd']";
    public static String imageShareLink ="//div[@cLass='N1yuQd']//div[@class='EHQHR']";
    public static String copyLinkDialog = "//div[@jsname='b0t70b']//div[@jsname='GIN7Bd']";
    public static String copyLink ="//div[@class='WO1lOd']//input[@type='url']";
    public static String linkCopyHeader ="//div[@jsname='pAZ6Ed'][contains(text(), 'Link copied')]";

    public static void main(String[] args) throws IOException, UnsupportedFlavorException {
        System.setProperty("webdriver.chrome.driver","C:\\M2\\chromedriver-win64\\chromedriver.exe" );
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://www.google.com");

        //div[@class="a4bIc"]//textarea
        driver.findElement(By.xpath("//div[@class='a4bIc']//textarea")).sendKeys("selenium");
        List<WebElement> list = driver.findElements((By.xpath("//ul[@role='listbox']//li/descendant::div[@class='pcTkSc']")));

        System.out.println(" Number of search lists: " + list.size());

        for(int i=0; i<list.size(); i++){
            System.out.println(" Lists are " + list.get(i).getText());
            if(list.get(i).getText().contains("selenium")){
                list.get(i).click();
                break;
            }

        }

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(imageGrid)));

        driver.findElement(By.xpath(imageButton)).click();
      wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(imageMenu))).findElement(By.xpath(imageShareLink)).click();

      String mystring = null;
        Actions action = new Actions((driver));

      if(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(copyLinkDialog))).isDisplayed()){
        driver.findElement(By.xpath(copyLink)).click();
          driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
          action.sendKeys(Keys.chord(Keys.LEFT_CONTROL, "C")).build().perform();

        mystring=(String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);


//        Boolean displayed =driver.findElement(By.xpath(linkCopyHeader)).isDisplayed();
//        System.out.println("Link displayed " + displayed);

//          Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
//          Transferable contents = clipboard.getContents(null);
//          driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//          mystring = (String) contents.getTransferData(DataFlavor.stringFlavor);
          System.out.println("Link displayed " + mystring);
        }

      driver.get(mystring);
//        Actions action = new Actions((driver));
//        action.sendKeys(Keys.chord(Keys.LEFT_CONTROL, "V")).build().perform();
        driver.findElement(By.xpath("//div[@class='a4bIc']//textarea")).sendKeys(mystring);
        driver.findElement(By.xpath("//div[@class='a4bIc']//textarea")).sendKeys(Keys.ENTER);
        //Actions action = new Actions((driver));
        //action.sendKeys(Keys.ENTER);
        driver.quit();
    }
}
