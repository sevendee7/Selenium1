package TestCases.railway;

import PageObjects.railway.BookTicketPage;
import PageObjects.railway.HomePage;
import PageObjects.railway.LoginPage;
import PageObjects.railway.TimetablePage;
import common.constant.Constant;
import dataobjects.AccountInformation;
import dataobjects.TicketInformation;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TimetableTest extends BaseTest {
    AccountInformation accountInformation = new AccountInformation();
    TicketInformation ticketInformation = new TicketInformation();
    LoginPage loginPage = new LoginPage();
    TimetablePage timetablePage = new TimetablePage();
    BookTicketPage bookTicketPage = new BookTicketPage();
    HomePage homePage = new HomePage();

    @Test(testName = "TC15 - User can open 'Book ticket' page by clicking on 'Book ticket' link in 'Train timetable' page")
    public void TC15() {
        accountInformation.email = Constant.USERNAME;
        accountInformation.password = Constant.PASSWORD;

        System.out.println("Step 2 - Login with valid Email and Password");
        homePage.goToLoginPage();
        loginPage.login(accountInformation);

        System.out.println("Step 3 - Click on 'Timetable' tab");
        homePage.goToTimetablePage();
        ticketInformation = timetablePage.getSelectedRouteStations();
        timetablePage.clickBookTicketLink();

        String actualDepartStation = bookTicketPage.getDepartStation();
        String expectedDepartStation = ticketInformation.departStation;
        Assert.assertEquals(actualDepartStation, expectedDepartStation, "Depart Station does not match");

        String actualArriveStation = bookTicketPage.getArriveStation();
        String expectedArriveStation = ticketInformation.arriveStation;
        Assert.assertEquals(actualArriveStation, expectedArriveStation, "Arrive Station does not match");
    }
}
