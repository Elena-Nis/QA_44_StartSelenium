package practice;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class CssSelectorsILCarro {
    WebDriver driver = new ChromeDriver();

    @Test

    public void cssSelectorsILCarro() {
        driver.navigate().to("https://ilcarro.web.app/search");
        driver.manage().window().maximize();

        WebElement cityField = driver.findElement(By.cssSelector("#city"));
        cityField.sendKeys("V");
     pause(2);
     //Waiting for drop-down list to load
    List<WebElement> cityList = driver.findElements(By.cssSelector(".pac-item"));
    for (WebElement option : cityList) {
        if (option.getText().contains("Vancouver") && option.getText().contains("Canada")) {
            option.click();
            pause(4);
           break;

        }
    }

   WebElement datesField = driver.findElement(By.cssSelector("#dates"));
        pause(2);
        datesField.clear();
        datesField.sendKeys("09/05/2024 - 09/14/2024");
        pause(2);

        WebElement yallaBtn = driver.findElement(By.xpath("//button[@type='submit']"));
        yallaBtn.click();

    //datesField.click();
    //pause(2);
   // List<WebElement> calendarList = driver.findElements(By.xpath("//td[@role='gridcell']//div[contains(@class, 'mat-calendar-body-cell-content') and text()='7']"));
//WebElement  firstDate = driver.findElement(By.cssSelector("td[role='gridcell']div.mat-calendar-body-cell-content"));
 //List<WebElement> calendarList = driver.findElements(By.cssSelector(".mat-calendar-body-cell-content"));
        // List<WebElement> calendarList = driver.findElements(By.cssSelector("td"));
     //
//    WebElement firstDate = driver.findElement(By.cssSelector(".mat-calendar-body-cell-content[aria-label='7']"));
//        firstDate.click();
//        pause(2);
//        WebElement secondDate = driver.findElement(By.cssSelector("div.mat-calendar-body-cell-content:contains('14')"));
//        secondDate.click();
//        pause(2);

//        List<WebElement> datesList = driver.findElements(By.cssSelector(".cdk-overlay-container"));
//        for (WebElement option : datesList) {
//            if (option.getText().contains("5")) {
//                option.click();
//                pause(2);
//                break;
//            }
//        }
//        for (WebElement option : datesList) {
//            if (option.getText().contains("10")) {
//                option.click();
//                pause(2);
//                break;
//            }
//        }

        //driver.quit();
    }
    private void pause(int time){
        try {
            Thread.sleep(time*1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}