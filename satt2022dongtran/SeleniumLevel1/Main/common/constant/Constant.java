package common.constant;

import org.openqa.selenium.WebDriver;

public class Constant {

    public static WebDriver WEBDRIVER;
    public static final String RAILWAY_URL = "http://www.raillog.somee.com/Page/HomePage";
    public static final String LOGIN_PAGE_TITLE = "Login Page";
    public static final String LOGIN_ERROR_MESSAGE = "There was a problem with your login and/or errors exist in your form.";
    public static final String USERNAME = "dongthg@test.com";
    public static final String PASSWORD = "123123123";
    public static final String INVALID_CONFIRM_PASSWORD = "xoulkcxvlk";
    public static final String INVALID_PASSWORD = "afxvzsw3213";
    public static final String PASSPORT = "123456789";
    public static final String WELCOME_MESSAGE = "Welcome " + USERNAME;
    public static final String REGISTER_SUCCESS_MESSAGE = "Thank you for registering your account";
    public static final String REGISTER_ERROR_MESSAGE = "There're errors in the form. Please correct the errors and try again.";
    public static final String REGISTER_PASSWORD_ERROR_MESSAGE = "Invalid password length.";
    public static final String REGISTER_PASSPORT_ERROR_MESSAGE = "Invalid ID length.";
    public static final String TICKET_AMOUNT = "1";
    public static final String CHANGE_PASSWORD_MESSAGE = "Your password has been updated";
    public static final String CHANGE_PASSWORD_PAGE_TITLE = "Change password";
    public static final String MY_TICKET_PAGE_TITLE = "Manage Tickets";
    public static final String BOOK_TICKET_SUCCESS_MESSAGE = "Ticket booked successfully!";
    public static final String TEST_DOMAIN = "@test.com";
    public static final int START_DATE = 4;
    public static final int END_DATE = 30;
    public static final int LOGIN_TIMES = 3;

}
