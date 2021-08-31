package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.LoginPage;
import testSuccessfull.LoginTestsSuccessfull;
import utils.EventReporter;

import java.util.concurrent.TimeUnit;

public class BaseTests {

    protected EventFiringWebDriver driver;
    protected LoginPage loginPage;

    /*@BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
        driver = new EventFiringWebDriver(new ChromeDriver()) ;
        driver.register(new EventReporter());
        goLoginPage();


    }*/
    @BeforeClass
    @Parameters({"URL","BrowserType"})
    public void SetUp(String url , String browserType){

        if(browserType.equalsIgnoreCase("Chrome")) {
            System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
            driver = new EventFiringWebDriver(new ChromeDriver());
        }
        else if(browserType.equalsIgnoreCase("Firefox")) {
            System.setProperty("webdriver.gecko.driver","resources/geckodriver.exe");
            driver = new EventFiringWebDriver(new FirefoxDriver());
        }
        else if(browserType.equalsIgnoreCase("Internet Explorer")){
            System.setProperty("webdriver.ie.driver","resources/IEDriverServer.exe");

           /* DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
            caps.setCapability("ignoreZoomSetting", true);*/
            driver = new EventFiringWebDriver(new InternetExplorerDriver() );

        }

        goLoginPage();


        System.out.println("\n"+"Open "+browserType);
        System.out.println("\t"+driver.getTitle());
        System.out.println("close "+browserType);


    }
    @BeforeMethod
    public void goLoginPage(){
        driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
        loginPage = new LoginPage(driver);

    }

    @AfterClass
    public void tearDown(){
       driver.quit();

    }
    /*@AfterMethod
    public void resultsAnalysis(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }*/



}
