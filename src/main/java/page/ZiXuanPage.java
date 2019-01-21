package page;

import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;


public class ZiXuanPage extends BassPage {

    private By search=By.id("action_create_cube");
    private By search_input=By.id("search_input_text");
    private By add_button=By.id("rl_loading");
    private By cancel_button=By.id("action_close");
    private By stock=By.id("stockName");

    public ArrayList<String> addStock(String stockname) {

        ArrayList<String> array = getStockAll();

        //判断股票是否已经存在自选列表中
        if (getStockAll().contains(stockname)) {
            System.out.println("股票已经在自选列表中");
            return array;
        }
        else {
            find(search).click();
            find(search_input).sendKeys(stockname);
            find(add_button).click();
            find(cancel_button).click();
            return array;
        }
    }

    //删除已经添加的股票
    public ArrayList<String> delectStock(String stockname) {
        ArrayList<String> array = getStockAll();
        if (!array.contains(stockname)){
            System.out.println("股票不在自选列表中，无法删除");
            return array;
        }
        for (WebElement e : Driver.getCurrentDriver().findElements(stock)) {
            if (e.getText().equals(stockname)){
                e.click();
            }
        }
        find(By.xpath("//*[@text='设自选']")).click();
        find(By.xpath("//*[@text='删除自选']")).click();
        find(By.id("action_back")).click();
        return array;
    }

    //获取股票股票信息
    public ArrayList<String> getStockAll() {
        ArrayList<String> arraystock = new ArrayList<String>();
        for (WebElement e : Driver.getCurrentDriver().findElements(stock)) {
            arraystock.add(e.getText());
        }
        return arraystock;
    }
}
