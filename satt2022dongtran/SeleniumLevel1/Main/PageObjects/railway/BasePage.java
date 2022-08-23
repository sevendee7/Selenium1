package PageObjects.railway;

import element.Element;
import org.openqa.selenium.By;

public class BasePage {
    private final Element tabLogin = new Element(By.xpath("//div[@id='menu']//a[@href='/Account/Login.cshtml']"));
    private final Element tabLogout = new Element(By.xpath("//div[@id='menu']//a[@href='/Account/Logout']"));
    private final Element tabBookTicket = new Element(By.xpath("//div[@id='menu']//a[@href='/Page/BookTicketPage.cshtml']"));
    private final Element tabRegister = new Element(By.xpath("//div[@id='menu']//a[@href='/Account/Register.cshtml']"));
    private final Element tabMyTicket = new Element(By.xpath("//div[@id='menu']//a[@href='/Page/ManageTicket.cshtml']"));
    private final Element tabChangePassword = new Element(By.xpath("//div[@id='menu']//a[@href='/Account/ChangePassword.cshtml']"));
    private final Element tabTimeTable = new Element(By.xpath("//div[@id='menu']//a[@href='TrainTimeListPage.cshtml']"));
    private final Element labelWelcomeMessage = new Element(By.xpath("//div[@class='account']/strong"));
    private final Element labelPageTitle = new Element(By.xpath("//div[@id='content']/h1[@align='center']"));

    // Methods
    public String getWelcomeMsg() {
        return this.labelWelcomeMessage.getText();
    }

    public String getPageTile() {
        return this.labelPageTitle.getText();
    }

    public void goToLoginPage() {
        tabLogin.click();
    }

    public void goToRegisterPage() {
        tabRegister.click();
    }

    public void goToMyTicketPage() {
        tabMyTicket.click();
    }

    public void goToChangePasswordPage() {
        tabChangePassword.click();
    }

    public HomePage open() {
        return new HomePage();
    }

    public void goToBookTicketPage() {
        tabBookTicket.click();
    }

    public void goToTimetablePage() {
        tabTimeTable.click();
    }

    public boolean isMyTicketTabDisplay() {
        return tabMyTicket.isDisplayed();
    }

    public boolean isChangePasswordTabDisplay() {
        return tabChangePassword.isDisplayed();
    }

    public boolean isLogOutTabDisplay() {
        return tabLogout.isDisplayed();
    }

}
