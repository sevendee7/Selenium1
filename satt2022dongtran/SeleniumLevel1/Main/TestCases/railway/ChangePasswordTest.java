package TestCases.railway;

import PageObjects.railway.ChangePasswordPage;
import PageObjects.railway.HomePage;
import PageObjects.railway.LoginPage;
import PageObjects.railway.RegisterPage;
import common.constant.Constant;
import dataobjects.AccountInformation;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ChangePasswordTest extends BaseTest {
    AccountInformation accountInformation = new AccountInformation();
    HomePage homePage = new HomePage();
    RegisterPage registerPage = new RegisterPage();
    LoginPage loginPage = new LoginPage();
    ChangePasswordPage changePasswordPage = new ChangePasswordPage();

    @Test(testName = "TC09 - User can change password")
    public void TC09() {
        accountInformation = new AccountInformation();

        System.out.println("Pre-condition: Create a new account");
        homePage.goToRegisterPage();
        registerPage.registerRandomAccount(accountInformation);

        System.out.println("Step 2 - Login with the new account");
        registerPage.goToLoginPage();
        loginPage.login(accountInformation);

        System.out.println("Step 3 - Go to Change Password page to change password");
        homePage.goToChangePasswordPage();
        changePasswordPage.changePassword(accountInformation);

        String actualMsg = changePasswordPage.getChangePwdMsg();
        String expectedMsg = Constant.CHANGE_PASSWORD_MESSAGE;
        Assert.assertEquals(actualMsg, expectedMsg, "Fail to change password");
    }
}
