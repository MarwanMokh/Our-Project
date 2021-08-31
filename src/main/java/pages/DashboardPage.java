package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage {

    private WebDriver driver;
    private By welcomeRegion = By.cssSelector("#branding #welcome");
    private By logOut = By.xpath("//div[@id=\"welcome-menu\"]/ul/li[3]");
    private By welcomeMessage = By.cssSelector("#branding #welcome");
    private By dashboardMessage= By.xpath("//div[@class=\"head\"]/h1[contains(.,\"Dashboard\")]");

    public DashboardPage(WebDriver driver){
        this.driver = driver;
    }
    public void clickLogOut(){
        driver.findElement(welcomeRegion).click();
        driver.findElement(logOut).click();
    }
    public String getDashBoardMessage(){
        return driver.findElement(dashboardMessage).getText();
    }
    public String getWelcomeMessage(){
        return driver.findElement(welcomeMessage).getText();
    }



}
