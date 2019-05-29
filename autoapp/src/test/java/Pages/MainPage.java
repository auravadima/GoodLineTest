package Pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPage {

    private SelenideElement from;
    private SelenideElement to;
    private SelenideElement when;

    public MainPage(){
        String sss = "ddfdsdfsdf";
        open("https://rasp.yandex.ru");
        from = $(By.id("from"));
        to = $(By.id("to"));
        when = $(By.id("when"));
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
        return new ResultPage();
    }
}
