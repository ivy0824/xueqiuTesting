package page;

import driver.Driver;
import org.openqa.selenium.By;


import java.net.MalformedURLException;

import static page.BassPage.find;

public class MainPage extends BassPage {

    private static By profile = By.id("user_profile_icon");
    private static By search=By.id("home_search");
    private static By zixuan = By.id("");


    public static MainPage start() throws MalformedURLException {

        Driver.start();
        return new MainPage();
    }

    public static ProfilePage gotoProfile(){
        find(profile).click();
        return new ProfilePage();
    }

    public SearchPage gotoSearch(){
        find(search).click();
        return new SearchPage();
    }

    public ZiXuanPage gotoZiXuan(){
        find(zixuan).click();
        return new ZiXuanPage();
    }
}
