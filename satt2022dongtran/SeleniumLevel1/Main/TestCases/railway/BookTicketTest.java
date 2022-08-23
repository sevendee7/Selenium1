package TestCases.railway;

import PageObjects.railway.BookTicketPage;
import PageObjects.railway.HomePage;
import PageObjects.railway.LoginPage;
import PageObjects.railway.RegisterPage;
import common.constant.Constant;
import common.helper.Helper;
import dataobjects.AccountInformation;
import dataobjects.TicketInformation;
import dataobjects.datatype.ArriveAt;
import dataobjects.datatype.DepartFrom;
import dataobjects.datatype.SeatType;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BookTicketTest extends BaseTest {
    Helper helper = new Helper();
    AccountInformation accountInformation = new AccountInformation();
    HomePage homePage = new HomePage();
    RegisterPage registerPage = new RegisterPage();
    LoginPage loginPage = new LoginPage();
    BookTicketPage bookTicketPage = new BookTicketPage();
    TicketInformation ticketInformation = new TicketInformation();
    TicketInformation bookedTicketInformation = new TicketInformation();

    @Test(testName = "TC14 - User can book 1 ticket at a time")
    public void TC14() {
        accountInformation = new AccountInformation();
        String departDate = helper.generateRandomDateBetween(Constant.START_DATE,Constant.END_DATE);

        System.out.println("Pre-condition: Create a new account");
        homePage.goToRegisterPage();
        registerPage.registerRandomAccount(accountInformation);

        System.out.println("Step 2 - Login with new account");
        registerPage.goToLoginPage();
        loginPage.login(accountInformation);

        System.out.println("Step 3 - Book 1 ticket");
        homePage.goToBookTicketPage();
        ticketInformation = bookTicketPage.bookTicket(departDate, DepartFrom.SAI_GON, ArriveAt.HUE,
                SeatType.HS, Constant.TICKET_AMOUNT);
        bookedTicketInformation = bookTicketPage.getBookedTicketInformation();

        String actualMsg = bookTicketPage.getSuccessfullyBookTicketMessage();
        String expectedMsg = Constant.BOOK_TICKET_SUCCESS_MESSAGE;
        Assert.assertEquals(actualMsg, expectedMsg, "Book Ticket successful message is not displayed as expected");

        Assert.assertSame(ticketInformation, bookedTicketInformation, "Ticket not corresponding");
    }
}
