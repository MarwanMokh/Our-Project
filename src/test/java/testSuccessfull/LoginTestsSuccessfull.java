package testSuccessfull;

import base.BaseTests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.DashboardPage;
import testData.LogInDP;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
@Listeners(listeners.TestNgListeners.class)
public class LoginTestsSuccessfull extends BaseTests {


    @Test(dataProviderClass = LogInDP.class , dataProvider = "Signin-Provider")

    public void loginTests(String userName , String password , boolean success){

       loginPage.setUsernameAndPasswordFields(userName,password,success);
       DashboardPage dashboardPage = loginPage.pressLoginButton();

       System.out.println("Sign In Credentials : "+"\n"+
               "Username = " +userName+"\n"+
               "Password = " + password+"\n"+
               "Successful Sign in = " +success+"\n"
               );

        String expectedUrl = "https://opensource-demo.orangehrmlive.com/index.php/dashboard";
        String actualUrl = driver.getCurrentUrl();


        System.out.println("Actual Current URL is : " + actualUrl+"\n");
        System.out.println("Expected Login URL is : " + expectedUrl);


        assertEquals(actualUrl,expectedUrl,"Couldn't Login Successfully");



    }

}
