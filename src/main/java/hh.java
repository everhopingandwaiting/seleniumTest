import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class hh {
    public static void main(String[] args) throws Exception {
//        C:\Users\zhuxx\OneDrive\selenium

        System.setProperty("webdriver.gecko.driver", "C:\\Users\\zhuxx\\OneDrive\\selenium\\geckodriver.exe");
        FirefoxDriver wd;
        wd = new FirefoxDriver();
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        wd.get("https://www.baidu.com/baidu?wd=selenium&tn=monline_4_dg&ie=utf-8");
        wd.findElement(By.linkText("selenium + python自动化测试环境搭建 - 虫师 - 博客园")).click();
        wd.quit();
    }
    
    public static boolean isAlertPresent(FirefoxDriver wd) {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }
}
