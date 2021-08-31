package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginPage {

    private WebDriver driver;
    private By userNameField = By.id("txtUsername");
    private By passwordField = By.id("txtPassword");
    private By loginButton = By.cssSelector("#divLoginButton  #btnLogin");



    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public void setUsernameAndPasswordFields(String userName , String password , boolean success ){
        driver.findElement(userNameField).sendKeys(userName);
        driver.findElement(passwordField).sendKeys(password);
    }

    public DashboardPage pressLoginButton(){
        driver.findElement(loginButton).click();
        return new DashboardPage(driver);
    }



}
