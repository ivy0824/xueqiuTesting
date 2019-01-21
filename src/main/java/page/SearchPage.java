package page;

import driver.Driver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import static page.BassPage.find;

public class SearchPage extends BassPage {

    By stock=By.id("stockName");
    By cancel=By.id("action_close");
    By search=By.className("android.widget.EditText");

    public SearchPage search(String keyword){
        find(search).sendKeys(keyword);
        return this;
    }

    public MainPage cancel(){
        find(cancel).click();
        return new MainPage();
    }

    public ArrayList<String> getAll(){
        ArrayList<String> array=new ArrayList<String>();
        for(WebElement e: Driver.getCurrentDriver().findElements(stock)){
            array.add(e.getText());
        }
        return array;

    }

    public SearchPage getByStock(){
        return this;
    }

    public ArrayList<String> addSelected(){
        ArrayList<String> array=new ArrayList<String>();
        WebElement select=find(By.xpath("//*[contains(@resource-id,'follow) and contains(@resource-id,'_btn)]"));
        array.add(select.getAttribute("resourceId"));
        select.click();
        WebElement select2=find(By.xpath("//*[contains(@resource-id,'follow) and contains(@resource-id,'_btn)]"));
        array.add(select2.getAttribute("resourceId"));
        return array;
    }

    public SearchPage removeSelected(){
        return this;
    }
}
