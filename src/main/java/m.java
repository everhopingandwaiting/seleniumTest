import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class m {


    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

        //初始化一个chrome浏览器实例，实例名称叫driver
//        WebDriver driver = new RemoteWebDriver("http://127.0.0.1:9515", DesiredCapabilities.chrome());

        WebDriver driver = new ChromeDriver();
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

        //关闭并退出浏览器
        driver.quit();

    }
}
