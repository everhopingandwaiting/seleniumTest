import org.jy.tool.OSinfo
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import java.util.concurrent.TimeUnit

object cqdTest {


    @Throws(Exception::class)
    @JvmStatic
    fun main(args: Array<String>) {
        val urlSite = "localhost:8080/chengqiandaiweb/"

//         remote
   /*     val urlHub = "http://192.168.0.222:5555/wd/hub"
        var driver: WebDriver? = null
        val dc = DesiredCapabilities.firefox() // 设置需要驱动的浏览器，其他的浏览器都是以此类推
        driver = RemoteWebDriver(URL(urlHub), dc) // 这个URL的问题

*/
        System.setProperty("webdriver.chrome.driver", "driver/" + OSinfo.getOSname() + "_chromedriver");
        var driver: WebDriver = ChromeDriver();

        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS) // 设置页面加载超时的最大时长


        //        WebDriver driver = new ChromeDriver();
        //最大化窗口
        //        driver.manage().window().maximize();
        //设置隐性等待时间
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS)

        // get()打开一个站点``
        driver.get(urlSite)
        driver.findElement(By.linkText("登录")).click()
        driver.findElement(By.id("username")).click()
        driver.findElement(By.id("username")).clear()
        driver.findElement(By.id("username")).sendKeys("15620608592")
        driver.findElement(By.id("password")).click()
        driver.findElement(By.id("password")).clear()
        driver.findElement(By.id("password")).sendKeys("123456jy")
        driver.findElement(By.xpath("//form[@id='denglu']/div[7]/input")).click()
        driver.findElement(By.linkText("首页")).click()

        println(driver.currentUrl)

//        driver.get("localhost:8080/chengqiandaiweb/")

        //关闭并退出浏览器
//        driver.close()

    }
}