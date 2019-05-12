import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


class Utils {

    private static WebDriver driver;

    static WebDriver createChromeDriverAtRasp(final String from, final String to, final String when, boolean onlyBuses){

        if(driver == null){
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless");
            options.addArguments("disable-gpu");
            driver = new ChromeDriver(options);
        }


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
