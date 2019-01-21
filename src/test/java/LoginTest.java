
import com.sun.org.glassfish.gmbal.ParameterNames;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import page.LoginPage;
import page.MainPage;
import page.ProfilePage;

import java.net.MalformedURLException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class LoginTest {

    static MainPage mainPage;
    static ProfilePage profilePage;

    @BeforeAll
    static void beforeAll() throws MalformedURLException {
        mainPage=MainPage.start();
        profilePage = mainPage.gotoProfile();
    }

    @ParameterizedTest
    @CsvSource({
            "15600534760,xxxxxxx,手机号码或密码错误",
            "1560053476,xxxxxxx，手机号码填写错误"
            })
    //从上到下，先创建页面，然后封装方法
    public void 密码登录(String username,String password,String expection) throws MalformedURLException {

        LoginPage loginPage = profilePage.gotoLogin();
        loginPage.passwordFail(username,password);
        assertThat(loginPage.getMessge(),equalTo(expection));
        profilePage=loginPage.gotoProfile();
    }
}
