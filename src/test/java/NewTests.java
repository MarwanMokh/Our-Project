import base.BaseTests;
import org.testng.annotations.Test;
import pages.DashboardPage;
import testData.LogInDP;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class NewTests extends BaseTests {

    @Test(dataProviderClass = LogInDP.class,dataProvider = "Signin-Provider")
    public void UserLoginInSuccessfully(String username , String password, boolean success){

        loginPage.setUsernameAndPasswordFields(username,password,success);
        DashboardPage dashboardPage = loginPage.pressLoginButton();
        /*String welcomeMessage = dashboardPage.getWelcomeMessage();
        System.out.println(welcomeMessage);
        assertTrue(welcomeMessage.contains("Welcome"));*/

        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://opensource-demo.orangehrmlive.com/index.php/dashboard";

        System.out.println("Actual Url : "+actualUrl+"\nExpected Url :"+expectedUrl);
        assertEquals(actualUrl,expectedUrl,"Couldn't Log in Successfully");



    }
}
