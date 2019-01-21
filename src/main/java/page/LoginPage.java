package page;

import driver.Driver;
import org.openqa.selenium.By;

import static page.BassPage.find;

public class LoginPage {
    private By other = By.xpath("//*[@text='手机及其他登录]");
    private By passwordLogin = By.xpath("//*[@text='邮箱手机号密码登录]");
    private By password = By.xpath("//*[@password='true']");
    private By username= By.id("login_acccount");
    private By login = By.id("button_next");
    private By msg = By.id("md_content");

    String message;

    public LoginPage passwordFail(String username,String password){
        find(other).click();
        find(passwordLogin).click();
        find(this.username).sendKeys(username);
        find(this.password).sendKeys(password);
        find(login).click();
        message = find(msg).getText();
        find(By.id("md_buttonDefaultPositive")).click();

        return this;
    }

    public String getMessge(){
        return message;
    }

    public ProfilePage gotoProfile(){
        find(By.id("iv_close")).click();
        return new ProfilePage();

    }

}