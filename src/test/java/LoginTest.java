import org.junit.Test;
import page.LoginPage;
import page.MainPage;
import page.ProfilePage;

import java.net.MalformedURLException;

import static org.hamcrest.MatcherAssert.assertThat;

public class LoginTest {


    @Test
    //从上到下，先创建页面，然后封装方法
    public void 非手机号() throws MalformedURLException {
        MainPage mainPage = new MainPage().start();
        ProfilePage profilePage = mainPage.gotoProfile();
        LoginPage loginPage = profilePage.gotoLogin();
        loginPage.passwordFail("123","XXX");
        assertThat(loginPage.getMessge(),equals("手机号码填写错误"));
//        toast = loginPage.password("111111111111","XXXXX");
//        assertThat(toast,equalsTo("手机号码填写错误"));
    }
}
