package TestCases.railway;

import PageObjects.railway.*;
import dataobjects.AccountInformation;
import common.constant.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    AccountInformation accountInformation = new AccountInformation();
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    RegisterPage registerPage = new RegisterPage();
    MyTicketPage myTicketPage = new MyTicketPage();
    ChangePasswordPage changePasswordPage = new ChangePasswordPage();

    @Test(testName = "TC01 - User can log into Railway with valid username and password")
    public void TC01() {
        accountInformation.email = Constant.USERNAME;
        accountInformation.password = Constant.PASSWORD;

        System.out.println("Step 2 - Click on 'Login' tab");
        homePage.goToLoginPage();

        System.out.println("Step 3 - Login with valid Email and Password");
        loginPage.login(accountInformation);

        String actualMsg = loginPage.getWelcomeMsg();
        String expectedMsg = Constant.WELCOME_MESSAGE;
        Assert.assertEquals(actualMsg, expectedMsg, "Welcome message is not displayed as expected");
    }

    @Test(testName = "TC02 - User can't login with blank 'Username' text box")
    public void TC02() {
        accountInformation = new AccountInformation("", Constant.PASSWORD);

        System.out.println("Step 2 - Click on 'Login' tab");
        homePage.goToLoginPage();

        System.out.println("Step 3 - User login with blank email and valid password ");
        loginPage.login(accountInformation);

        String actualMsg = loginPage.getLoginErrorMessage();
        String expectedMsg = Constant.LOGIN_ERROR_MESSAGE;
        Assert.assertEquals(actualMsg, expectedMsg, "Error message is not displayed as expected");
    }

    @Test(testName = "TC03 - User cannot log into Railway with invalid password")
    public void TC03() {
        accountInformation = new AccountInformation(Constant.USERNAME,Constant.INVALID_PASSWORD);
        System.out.println("Step 2 - Click on 'Login' tab");
        homePage.goToLoginPage();

        System.out.println("Step 3 - Login with invalid password");
        loginPage.login(accountInformation);

        String actualMsg = loginPage.getLoginErrorMessage();
        String expectedMsg = Constant.LOGIN_ERROR_MESSAGE;
        Assert.assertEquals(actualMsg, expectedMsg, "Error message is not displayed as expected");
    }

    @Test(testName = "TC04 - Login page displays when un-logged User clicks on 'Book ticket' tab")
    public void TC04() {
        System.out.println("Step 2 - Click on 'Book Ticket' tab");
        homePage.goToBookTicketPage();

        String actualLoginHeader = loginPage.getPageTile();
        String expectedLoginHeader = Constant.LOGIN_PAGE_TITLE;
        Assert.assertEquals(actualLoginHeader, expectedLoginHeader, "Failed to navigate to Login page");
    }

    @Test(testName = "TC05 - System shows message when user enters wrong password several times")
    public void TC05() {
        accountInformation = new AccountInformation();

        System.out.println("Step 2 - Click on 'Login' tab");
        homePage.goToLoginPage();

        System.out.println("Step 3 - Login multiple times with invalid password");
        loginPage.loginFailMultipleTimes(accountInformation, Constant.LOGIN_TIMES);

        String actualMsg = loginPage.getLoginErrorMessage();
        String expectedMsg = "You have used 4 out of 5 login attempts."
                + "After all 5 have been used, you will be unable to login for 15 minutes.";
        Assert.assertEquals(actualMsg, expectedMsg, "Error message is not displayed as expected");
    }

    @Test(testName = "TC06 - Additional pages display once user logged in")
    public void TC06() {
        accountInformation.email = Constant.USERNAME;
        accountInformation.password = Constant.PASSWORD;

        System.out.println("Step 2 - Click on 'Login' tab, login with valid account");
        homePage.goToLoginPage();
        loginPage.login(accountInformation);

        Assert.assertTrue(loginPage.isMyTicketTabDisplay(), "My Ticket tab is not display");
        Assert.assertTrue(loginPage.isChangePasswordTabDisplay(), "Change Password tab is not display");
        Assert.assertTrue(loginPage.isLogOutTabDisplay(), "Logout tab is not display");

        System.out.println("Step 3 - Click on 'My Ticket' tab");
        homePage.goToMyTicketPage();

        String actualMyTicketHeader = myTicketPage.getPageTile();
        String expectedMyTicketHeader = Constant.MY_TICKET_PAGE_TITLE;
        Assert.assertEquals(actualMyTicketHeader, expectedMyTicketHeader, "Failed to navigate to " +
                "My Ticket page");

        System.out.println("Step 4 - Click on 'Change Password' tab");
        myTicketPage.goToChangePasswordPage();

        String actualChangePwdHeader = changePasswordPage.getPageTile();
        String expectedChangePwdHeader = Constant.CHANGE_PASSWORD_PAGE_TITLE;
        Assert.assertEquals(actualChangePwdHeader, expectedChangePwdHeader, "Failed to navigate to" +
                " Change Password page");
    }

    @Test(testName = "TC08 - User can't login with an account hasn't been activated")
    public void TC08() {
        accountInformation = new AccountInformation();

        System.out.println("Pre-condition: Create a new account but do not activate it");
        homePage.goToRegisterPage();
        registerPage.registerRandomAccount(accountInformation);

        System.out.println("Step 2 - Click on 'Login' tab");
        registerPage.goToLoginPage();

        System.out.println("Step 3 - Login with account hasn't been activated.");
        loginPage.login(accountInformation);

        String actualMsg = loginPage.getLoginErrorMessage();
        String expectedMsg = "Invalid username or password. Please try again.";
        Assert.assertEquals(actualMsg, expectedMsg, "Welcome message is not displayed as expected");
    }
}
