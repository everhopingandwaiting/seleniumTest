

import org.jy.tool.OSinfo
import org.openqa.selenium.By
import org.openqa.selenium.Cookie
import org.openqa.selenium.NoAlertPresentException
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.firefox.FirefoxDriver
import java.util.*
import java.util.concurrent.TimeUnit

object miui {
    @Throws(Exception::class)
    @JvmStatic
    fun main(args: Array<String>) {
        System.setProperty("webdriver.chrome.driver", "driver/" + OSinfo.getOSname() + "_chromedriver")
        val wd = ChromeDriver()
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS)
        wd.get("http://www.miui.com/index.html")

        wd.manage().addCookie(Cookie("MIUI_2132_lastact", "1504517721%09forum.php%09newindex", "/", Date("05-Sep-2017 09:35:21 GMT")))

        val cookies = "UM_distinctid=15ce861cff6644-05a3f6abb0d645-5393662-1fa400-15ce861cff73c3; MIUI_2132_ulastactivity=2bb3%2BTMPU%2F2k8O%2BM9J2sMO8amGB20BJPwKNO%2BKH4a0RhJATKsJ5aWGU; CNZZDATA5557939=cnzz_eid%3D1758732938-1498628172-http%253A%252F%252Fwww.miui.com%252F%26ntime%3D1501737331; MIUI_2132_smile=3D1; MIUI_2132_saltkey=kZrwrXMM; MIUI_2132_lastvisit=1504509464; CNZZDATA2441309=cnzz_eid%3D350627328-1498545289-http%253A%252F%252Fmall.10046.mi.com%252F%26ntime%3D1504512516; CNZZDATA30049650=cnzz_eid%3D327601785-1498542396-http%253A%252F%252Fmall.10046.mi.com%252F%26ntime%3D1504510272; __utma=230417408.546100894.1494213961.1503549598.1504513048.12; __utmb=230417408.3.10.1504513048; __utmc=230417408; __utmz=230417408.1501227235.8.6.utmcsr=baidu|utmccn=(organic)|utmcmd=organic; Hm_lvt_3c5ef0d4b3098aba138e8ff4e86f1329=1503549598,1504513048; Hm_lpvt_3c5ef0d4b3098aba138e8ff4e86f1329=1504513072;MIUI_2132_lastact=1504516066%09forum.php%09newindex; expires=Tue, 05-Sep-2017 09:07:46 GMT; Max-Age=86400; path=/;MIUI_2132_nofavfid=1; UM_distinctid=15ce836599b504-0844553f06ad47-635d712f-1fa400-15ce836599caf8; CNZZDATA5557939=cnzz_eid%3D1368282631-1498543483-http%253A%252F%252Fwww.miui.com%252F%26ntime%3D1498543483; MIUI_2132_smile=3D1; CNZZDATA5677709=cnzz_eid%3D1286668010-1498542923-http%253A%252F%252Fwww.miui.com%252F%26ntime%3D1498542923; __utmt=1; MIUI_2132_saltkey=NeZUnn2T; MIUI_2132_lastvisit=1504513491; MIUI_2132_sendmail=1; MIUI_2132_ulastactivity=3960GVRiAB4Q05tIyYfFVQG7EKotaVM4keBJAOrQu5CV%2Fn5zCYOBx1g; MIUI_2132_auth=011ff6yv%2Bwt9RIoMi%2FAxRzrYW6w7PZ3KVQptIZVnNzaHDHo5tRMK; MIUI_2132_checkpm=1; CNZZDATA30049650=cnzz_eid%3D1713960051-1498542396-%26ntime%3D1504513897; MIUI_2132_noticeTitle=1; __utma=230417408.1212314451.1493712968.1498544496.1504517085.4; __utmb=230417408.2.10.1504517085; __utmc=230417408; __utmz=230417408.1493714408.2.2.utmcsr=baidu|utmccn=(organic)|utmcmd=organic; Hm_lvt_3c5ef0d4b3098aba138e8ff4e86f1329=1504517085,1504517206; Hm_lpvt_3c5ef0d4b3098aba138e8ff4e86f1329=1504517206; MIUI_2132_lastact=1504517211%09forum.php%09newindex; CNZZDATA2441309=cnzz_eid%3D215996337-1498539889-%26ntime%3D1504514492"
        val strings = cookies.split(";".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
        for (cookie in strings) {
            val strings1 = cookie.split("=".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
            wd.manage().addCookie(Cookie(strings1[0].trim { it <= ' ' }, strings1[1].trim { it <= ' ' }))
        }
        wd.get("http://www.miui.com/index.html")
        wd.commandExecutor.toString()
        wd.sessionId.toString()
        //        wd.findElement(By.xpath("//div[@class='p']//a[.='登录']")).click();
        //
        //        wd.findElement(By.id("username")).sendKeys("");
        //
        //        wd.findElement(By.id("pwd")).sendKeys("");
        //        wd.findElement(By.id("login-button")).click();

        val cookiess = wd.manage().cookies
        wd.findElement(By.cssSelector("a.pf_sign_link.link_no_cursor")).click()

        //{"type":"clickElement","locator":{"type":"css selector","value":"a.pf_sign_link.link_no_cursor"}}
        //        wd.quit();


    }

    fun isAlertPresent(wd: FirefoxDriver): Boolean {
        try {
            wd.switchTo().alert()
            return true
        } catch (e: NoAlertPresentException) {
            return false
        }

    }
}
