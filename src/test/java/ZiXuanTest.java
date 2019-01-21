import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import page.MainPage;
import page.ProfilePage;
import page.SearchPage;
import page.ZiXuanPage;

import java.net.MalformedURLException;
import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.not;

public class ZiXuanTest {

    static MainPage mainPage;
    static ZiXuanPage ziXuanPage;
    static SearchPage searchPage;

    @BeforeAll
    static void beforeAll() throws MalformedURLException {
        mainPage=MainPage.start();
        ziXuanPage = mainPage.gotoZiXuan();
    }

    //添加股票
    @ParameterizedTest
    @CsvSource({
            "拼多多",
            "阿里巴巴",
            "搜狗"
    })

    public void addStock(String keyword){
        ArrayList<String> array=ziXuanPage.addStock(keyword);
        assertThat(array,hasItems(keyword));
    }

    //删除股票
    @ParameterizedTest
    @CsvSource({
            "拼多多",
            "阿里巴巴",
            "搜狗"
    })

    public void delectStock(String keyword){
        ArrayList<String> addedStock= ziXuanPage.delectStock(keyword);
        assertThat(addedStock,not(hasItems(keyword)));
    }


}
