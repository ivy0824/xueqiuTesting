package page;

import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import sun.applet.Main;

import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.List;

import static page.BassPage.find;

public class SearchPage {

    public SearchPage search(String keyword){
        find(By.className("android.widget.EditText")).sendKeys(keyword);
        return this;
    }

    public MainPage cancel(){
        find(By.id("catiob_close")).click();
        return new MainPage();
    }

    public ArrayList<String> getAll(){
        ArrayList<String> array=new ArrayList<String>();
        for(WebElement e: Driver.getCurentDriver().findElements(By.id("stockName"))){
            array.add(e.getText());
        }
        return array;

    }

    public SearchPage getByStock(){
        return this;
    }

    public SearchPage addSelected(){
        find(By.xpath("//*[contains(@reaource-id,'follow) and contains(@resource-id,'btn)]")).click();
        return this;
    }

    public SearchPage removeSelected(){
        return this;
    }
}
