package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MainPage {

    private WebDriver driver;
    private WebElement from;
    private WebElement to;
    private WebElement when;

    public MainPage(WebDriver driver){
        driver.get("https://rasp.yandex.ru");
        from = driver.findElement(By.id("from"));
        to =  driver.findElement(By.id("to"));
        when =  driver.findElement(By.id("when"));
    }

    public void setFromField(String text){
        from.clear();
        from.sendKeys(text);
    }

    public void setToField(String text){
        to.clear();
        to.sendKeys(text);
    }

    public void setWhen(String text){
        when.clear();
        when.sendKeys(text);
    }

    public ResultPage submit(){
        when.submit();
        return new ResultPage(driver);
    }
}
