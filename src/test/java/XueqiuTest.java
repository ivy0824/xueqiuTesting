import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidKeyCode;

public class XueqiuTest {

    private AndroidDriver driver;

    @Before
    public void setUp() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "android");
        desiredCapabilities.setCapability("deviceName", "hogwarts");
        desiredCapabilities.setCapability("appPackage", "com.xueqiu.android");
        desiredCapabilities.setCapability("appActivity", ".view.WelcomeActivityAlias");
        desiredCapabilities.setCapability("autoGrantPremissions", "true");

        URL remoteUrl = new URL("http://localhost:4723/wd/hub");

        driver = new AndroidDriver(remoteUrl, desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void sampleTest() throws InterruptedException {

        driver.findElementById("com.xueqiu.android:id/open").click();
        driver.findElementById("com.android.packageinstaller:id/permission_allow_button").click();
        driver.findElementById("com.android.packageinstaller:id/permission_allow_button").click();
//        driver.pressKeyCode(AndroidKeyCode.BACK);//在联想手机，Android 6.0.1 上没有生效

        MobileElement el6 = (MobileElement) driver.findElementById("com.xueqiu.android:id/tv_search");
        el6.click();
        MobileElement el7 = (MobileElement) driver.findElementById("com.xueqiu.android:id/search_input_text");
        el7.sendKeys("alibaba");
        driver.findElementById("stockName").click();

    }

//    @After
//    public void tearDown() {
//        driver.quit();
//    }
}


