import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class Utils {

    static WebDriver createChromeDriverAtRasp(final String from, final String to, final String when, boolean onlyBuses){

        WebDriver driver = new ChromeDriver();

        driver.get("https://rasp.yandex.ru");

        WebElement fromInput = driver.findElement(By.name("fromName"));
        fromInput.clear();
        fromInput.sendKeys(from);

        WebElement toInput = driver.findElement((By.name("toName")));
        toInput.sendKeys(to);

        WebElement dateInput = driver.findElement(By.id("when"));
        dateInput.sendKeys(when);

        if(onlyBuses){
            WebElement busRadioButton = driver.findElement(By.cssSelector(".RadioButton:nth-child(5) > .RadioButton__buttonLable"));
            busRadioButton.click();
        }

        dateInput.submit();

        return driver;
    }
}
