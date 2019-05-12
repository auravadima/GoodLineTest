import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URI;

class Utils {

    private static String uri = "http://localhost:4444/wd/hub";

    static WebDriver createChromeDriverAtRasp(){

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("chrome");
        capabilities.setVersion("73.0");
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", false);

        WebDriver driver = null;
        try {
            driver = new RemoteWebDriver(
                    URI.create(uri).toURL(),
                    capabilities
            );
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        driver.get("https://rasp.yandex.ru");

        return driver;
    }

    static WebDriver createFirefoxDriverAtRasp(){

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("firefox");
        capabilities.setVersion("66.0");
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", false);

        WebDriver driver = null;
        try {
            driver = new RemoteWebDriver(
                    URI.create(uri).toURL(),
                    capabilities
            );
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        driver.get("https://rasp.yandex.ru");

        return driver;
    }

    static WebDriver createOperaDriverAtRasp(){

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("opera");
        capabilities.setVersion("60.0");
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", false);

        WebDriver driver = null;
        try {
            driver = new RemoteWebDriver(
                    URI.create(uri).toURL(),
                    capabilities
            );
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        driver.get("https://rasp.yandex.ru");

        return driver;
    }


    static  void fillForm(WebDriver driver, String from, String to, String when, boolean onlyBuses){
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
    }
}
