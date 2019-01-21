package page;

import driver.Driver;
import org.openqa.selenium.By;


import java.net.MalformedURLException;

import static page.BassPage.find;

public class MainPage extends BassPage {

    private static By profile = By.id("user_profile_icon");
    public static MainPage start() throws MalformedURLException {

        Driver.start();
        return new MainPage();
    }

    public static ProfilePage gotoProfile(){
        find(profile).click();
        return new ProfilePage();
    }

    public SearchPage gotoSearch(){
        find(By.id("home_search")).click();
        return new SearchPage();
    }
}
