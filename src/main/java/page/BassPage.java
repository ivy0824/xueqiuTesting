package page;

import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BassPage {
    static WebElement find(By locator){
        return Driver.getCurentDriver().findElement(locator);
    }

    static By locate(String locator){
        if(locator.matches("/.*")){
            return By.xpath(locator);
        }else{
            return By.id(locator);
        }
    }

    static By text(String content){
        return By.xpath("//*[@text='"+content+"']");
    }
}
