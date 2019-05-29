import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

// 微博测试类
public class Weibo {

    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        // Mac 设置driver所在路径
        System.setProperty("webdriver.chrome.driver", "/Users/remini/Downloads/chromedriver");
        driver = new ChromeDriver();
        baseUrl = "https://passport.weibo.cn/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    // baseUrl、loginname、loginPassword
    @Test
    public void testWeibo() throws Exception {

        // 从环境变量中读取用户名和密码
        String user = System.getProperty("weibo.user", "mwr1998");
        String pwd = System.getProperty("weibo.pwd", "66666666");

        driver.get(baseUrl + "/signin/login?entry=mweibo&res=wel&wm=3349&r=http%3A%2F%2Fm.weibo.cn%2F");
        driver.findElement(By.id("loginName")).clear();
        driver.findElement(By.id("loginName")).sendKeys(user);
        driver.findElement(By.id("loginPassword")).clear();
        driver.findElement(By.id("loginPassword")).sendKeys(pwd);
        driver.findElement(By.id("loginAction")).click();
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    // 检测是否是现在的元素
    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    // 检测现在是否是警报状态
    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    // 关闭警告并且记录文本
    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }
}