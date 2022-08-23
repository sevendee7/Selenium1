package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManager {
    private static WebDriver driver;

    public static void startBrowser(String browser) {
        switch (browser) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;

            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;

            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;

            default:
                System.out.println("Browser: " + browser + " is invalid, Launching Chrome as browser of choice...");
                driver = new ChromeDriver();
        }
    }
    public static void navigate(String url) {
        driver.get(url);
    }
    public static void close() {
        driver.quit();
    }
    public static String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
    public static WebDriver getDriver() {
        return driver;
    }
}
