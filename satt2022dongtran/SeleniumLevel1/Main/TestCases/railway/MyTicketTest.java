package TestCases.railway;

import PageObjects.railway.*;
import dataobjects.AccountInformation;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyTicketTest extends BaseTest {
    AccountInformation accountInformation;
    HomePage homePage = new HomePage();
    RegisterPage registerPage = new RegisterPage();
    LoginPage loginPage = new LoginPage();
    BookTicketPage bookTicketPage = new BookTicketPage();
    MyTicketPage myTicketPage = new MyTicketPage();
    SuccessPage successPage = new SuccessPage();

//    @Test(testName = "TC16 - User can cancel a ticket")
//    public void TC16() {
//        String ticketId = "Can't get ticket ID";
//        accountInformation = new AccountInformation();
//
//        System.out.println("Pre-condition: Create a new account");
//        homePage.goToRegisterPage();
//        registerPage.registerRandomAccount(accountInformation);
//
//        System.out.println("Step 2 - Login with new account");
//        registerPage.goToLoginPage();
//        loginPage.login(accountInformation);
//
//        System.out.println("Step 3 - Book 1 ticket 3 times");
//        homePage.goToBookTicketPage();
//        for (int i = 0; i < 3; i++) {
//            if (i == 1) {
//                ticketId = bookTicketPage.bookRandomTicket();
//                bookTicketPage.goToBookTicketPage();
//                continue;
//            }
//            bookTicketPage.bookRandomTicket();
//            successPage.goToBookTicketPage();
//        }
//        bookTicketPage.goToMyTicketPage();
//        myTicketPage.findDeleteButtonById(ticketId).click();
//        myTicketPage.confirmDeleteTicket();
//        boolean checkTicketExisted = myTicketPage.isTicketExisted(ticketId);
//        Assert.assertFalse(checkTicketExisted,"Ticket is not cancelled");
//    }
//
//    @Test(testName = "TC17 - Filter is apply if user have booked ticket for 6 times")
//    public void TC17() {
//        accountInformation = new AccountInformation();
//
//        System.out.println("Pre-condition: Create a new account");
//        homePage.goToRegisterPage();
//        registerPage.registerRandomAccount(accountInformation);
//
//        System.out.println("Step 2 - Login with new account");
//        registerPage.goToLoginPage();
//        loginPage.login(accountInformation);
//
//        System.out.println("Step 3 - Book 1 ticket 6 times");
//        homePage.goToBookTicketPage();
//        for (int i = 0; i < 6; i++) {
//            bookTicketPage.bookRandomTicket();
//            successPage.goToBookTicketPage();
//        }
//        bookTicketPage.goToMyTicketPage();
//
//        Assert.assertTrue(myTicketPage.isFilterDisplayed(),"Filter not displayed");
//    }

    @Test(testName = "TC18 - Note box display properly")
    public void TC18() {
        accountInformation = new AccountInformation();

        System.out.println("Pre-condition: Create a new account");
//        homePage.goToRegisterPage();
//        registerPage.registerRandomAccount(accountInformation);
        accountInformation.email = "hieu@test.com";
        accountInformation.password = "123123123";

        System.out.println("Step 2 - Login with new account");
        registerPage.goToLoginPage();
        loginPage.login(accountInformation);

        System.out.println("Step 3 - Book random ticket");
        homePage.goToBookTicketPage();
        bookTicketPage.bookRandomTicket();
        successPage.goToBookTicketPage();
        bookTicketPage.bookRandomTicket();
        successPage.goToMyTicketPage();
        System.out.println("Step 4 - Get ticket amount ");
        int ticketAmount = myTicketPage.getTotalTicket();

        String expectedNoteInformation = myTicketPage.setNoteInformationByTicketAmount(ticketAmount);
        String actualNoteInformation = myTicketPage.getActualNoteInformation();
        Assert.assertEquals(actualNoteInformation,expectedNoteInformation, "Note information is not corresponding");
    }
}
