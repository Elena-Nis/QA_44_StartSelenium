package practice;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.List;

public class CssSelectorsILCarroIterator {
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
        Iterator<WebElement> iterator = cityList.iterator();
        boolean cityFound = false;
        while (iterator.hasNext() && !cityFound) {
            WebElement option = iterator.next();
            if (option.getText().contains("Vancouver") && option.getText().contains("Canada")) {
                option.click();
                pause(2);
                cityFound=true;

            }
        }

        WebElement datesField = driver.findElement(By.cssSelector("#dates"));
        pause(2);
        datesField.clear();
        datesField.sendKeys("09/05/2024 - 09/14/2024");
        pause(2);

        WebElement yallaBtn = driver.findElement(By.xpath("//button[@type='submit']"));
        yallaBtn.click();

        }
    private void pause(int time){
        try {
            Thread.sleep(time*1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}