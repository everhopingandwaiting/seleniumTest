import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class m {


    public static void main(String[] args) throws Exception {


//        System.setProperty("webdriver.chrome.driver", "driver/" + OSinfo.getOSname() + "_chromedriver");


        String url = "http://192.168.0.222:5555/wd/hub";
        //初始化一个chrome浏览器实例，实例名称叫driver
        WebDriver driver = null;

        DesiredCapabilities dc = DesiredCapabilities.firefox(); // 设置需要驱动的浏览器，其他的浏览器都是以此类推
        driver = new RemoteWebDriver(new URL(url), dc); // 这个URL的问题

        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS); // 设置页面加载超时的最大时长



//        WebDriver driver = new ChromeDriver();
        //最大化窗口
//        driver.manage().window().maximize();
        //设置隐性等待时间
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);

        // get()打开一个站点
        driver.get("https://www.cqdmoney.com/");
        driver.findElement(By.linkText("登录")).click();
        driver.findElement(By.id("username")).click();
        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("username")).sendKeys("15620608592");
        driver.findElement(By.id("password")).click();
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("***");
        driver.findElement(By.xpath("//form[@id='denglu']/div[7]/input")).click();
        driver.findElement(By.linkText("首页")).click();
        driver.findElement(By.xpath("//div[@class='carousel-inner']/div[1]/a/img")).click();

        System.out.println(driver.getCurrentUrl());

        //关闭并退出浏览器
        driver.quit();

    }
}
