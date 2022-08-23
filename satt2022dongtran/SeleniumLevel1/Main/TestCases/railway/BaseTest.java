package TestCases.railway;

import common.constant.Constant;
import driver.DriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseTest {
    @BeforeMethod
    @Parameters({"browser"})
    public static void beforeMethod(String browser) {
        System.out.println("Pre-condition");
        DriverManager.startBrowser(browser);
        DriverManager.getDriver().manage().window().maximize();
        System.out.println("Step 1 - Navigate to Railway");
        DriverManager.getDriver().navigate().to(Constant.RAILWAY_URL);
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("Post-condition");

        DriverManager.getDriver().quit();
    }
}
