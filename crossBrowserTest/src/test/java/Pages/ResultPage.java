package Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ResultPage {

    private WebElement title;
    private WebElement error;
    private List<WebElement> flights;
    private List<WebElement> icons;
    private List<WebElement> names;
    private List<WebElement> durations;


    public ResultPage(WebDriver driver){
        title = driver.findElement(By.tagName("title"));
        error = driver.findElement(By.className("ErrorPageSearchForm__title"));
        names = driver.findElements(By.className("SegmentTitle__title"));
        icons =  driver.findElements(By.className("TransportIcon__icon"));
        flights = driver.findElements(By.className("SearchSegment"));
        durations = driver.findElements(By.className("SearchSegment__duration"));
    }

    public WebElement getTitle(){
        return title;
    }

    public List<WebElement> getFlights(){
        return flights;
    }
    public List<WebElement> getNames(){
        return names;
    }
    public List<WebElement> getIcons(){
        return icons;
    }

    public List<WebElement> getDurations(){
        return durations;
    }

    public WebElement getErrorElement(){
        return error;
    }
}
