package TestCases.railway;

import PageObjects.railway.HomePage;
import PageObjects.railway.RegisterPage;
import common.constant.Constant;
import dataobjects.AccountInformation;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterTest extends BaseTest {
    RegisterPage registerPage = new RegisterPage();
    HomePage homePage = new HomePage();
    AccountInformation accountInformation = new AccountInformation();

    @Test(testName = "TC07 - User can create new account")
    public void TC07() {
        accountInformation = new AccountInformation();
        System.out.println("Step 2 - Click on 'Register' tab");
        homePage.goToRegisterPage();

        System.out.println("Step 3 - Register with valid info to all fields");
        registerPage.registerRandomAccount(accountInformation);

        String actualMsg = registerPage.getRegisterSuccessfulMessage();
        String expectedMsg = Constant.REGISTER_SUCCESS_MESSAGE;
        Assert.assertEquals(actualMsg, expectedMsg, "Register message is not displayed as expected");
    }

    @Test(testName = "TC10 - User can't create account with 'Confirm password' is not the same with 'Password'")
    public void TC10() {
        accountInformation = new AccountInformation(Constant.USERNAME,Constant.PASSWORD,
                Constant.INVALID_CONFIRM_PASSWORD,Constant.PASSPORT);

        System.out.println("Step 2 - Click on 'Register' tab");
        homePage.goToRegisterPage();

        System.out.println("Step 3 - Register an account with invalid confirm password");
        registerPage.registerAccount(accountInformation);

        String actualMsg = registerPage.getRegisterFailMessage();
        String expectedMsg = Constant.REGISTER_ERROR_MESSAGE;
        Assert.assertEquals(actualMsg, expectedMsg, "Register error message is not displayed as expected");
    }

    @Test(testName = "TC11 - User can't create account while password and PID/Passport fields are empty")
    public void TC11() {
        accountInformation = new AccountInformation(Constant.USERNAME,"", "","");
        System.out.println("Step 2 - Click on 'Register' tab");
        homePage.goToRegisterPage();

        System.out.println("Step 3 - Register an account with invalid password and passport");
        registerPage.registerAccount(accountInformation);

        String actualMsg = registerPage.getRegisterFailMessage();
        String expectedMsg = Constant.REGISTER_ERROR_MESSAGE;
        Assert.assertEquals(actualMsg, expectedMsg, "Register error message is not displayed as expected");

        String actualPwdErrMsg = registerPage.getPasswordValidateText();
        String expectedPwdErrMsg = Constant.REGISTER_PASSWORD_ERROR_MESSAGE;
        Assert.assertEquals(actualPwdErrMsg, expectedPwdErrMsg, "Password error message is not displayed as expected");

        String actualPidErrMsg = registerPage.getPassportValidateText();
        String expectedPidErrMsg = Constant.REGISTER_PASSPORT_ERROR_MESSAGE;
        Assert.assertEquals(actualPidErrMsg, expectedPidErrMsg, "PID/Passport error message is not displayed as expected");
    }
}
