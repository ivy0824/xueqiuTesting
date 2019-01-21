package page;

import driver.Driver;
import org.openqa.selenium.By;

import static page.BassPage.find;

public class ProfilePage {
    By login = By.xpath("//*[@text='点击登录']");

    public LoginPage gotoLogin(){
        find(login).click();
        return new LoginPage();

    }
}
