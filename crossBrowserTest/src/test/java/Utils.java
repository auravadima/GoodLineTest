import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URI;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Utils {

    private static String uri = "http://localhost:4444/wd/hub";

    static WebDriver createChromeDriver(){

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

        return driver;
    }

    static WebDriver createFirefoxDriver(){

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

        return driver;
    }

    static WebDriver createOperaDriver(){

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

        return driver;
    }
}
