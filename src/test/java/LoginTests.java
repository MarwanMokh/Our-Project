import base.BaseTests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.DashboardPage;

import static org.testng.Assert.assertEquals;

public class LoginTests {
    private WebDriver driver;
    @Test
    @Parameters({"URL","BrowserType"})
    public void verifyTAU(String url , String browserType){

        if(browserType.equalsIgnoreCase("Chrome")) {
            System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
            driver = new ChromeDriver();
        }
        else if(browserType.equalsIgnoreCase("Firefox")) {
            System.setProperty("webdriver.gecko.driver","resources/geckodriver.exe");
            driver = new FirefoxDriver();
        }
        else if(browserType.equalsIgnoreCase("Internet Explorer")){
            System.setProperty("webdriver.ie.driver","resources/IEDriverServer.exe");

           /* DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
            caps.setCapability("ignoreZoomSetting", true);*/
            driver = new InternetExplorerDriver();

        }

        driver.get(url);


        System.out.println("\n"+"Open "+browserType);
        System.out.println("\t"+driver.getTitle());
        System.out.println("close "+browserType);

        driver.quit();





    }

}
