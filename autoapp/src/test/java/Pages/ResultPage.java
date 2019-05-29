package Pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class ResultPage {

    private SelenideElement title;
    private SelenideElement error;
    private ElementsCollection flights;
    private ElementsCollection icons;
    private ElementsCollection names;


    public ResultPage(){
        title = $("title");
        error = $(By.className("ErrorPageSearchForm__title"));
        names = $$(By.className("SegmentTitle__title"));
        icons =  $$(By.className("TransportIcon__icon"));
        flights = $$(By.className("SearchSegment"));
    }

    public SelenideElement getTitle(){
        return title;
    }

    public ElementsCollection getFlights(){
        return flights;
    }
    public ElementsCollection getNames(){
        return names;
    }
    public ElementsCollection getIcons(){
        return icons;
    }

    public SelenideElement getErrorElement(){
        return error;
    }
}
