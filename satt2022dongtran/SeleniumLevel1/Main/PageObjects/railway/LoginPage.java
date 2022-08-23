package PageObjects.railway;

import dataobjects.AccountInformation;
import element.Element;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {

    private final Element textUsername = new Element(By.xpath("//input[@id='username']"));
    private final Element textPassword = new Element(By.xpath("//input[@id='password']"));
    private final Element buttonLogin = new Element(By.xpath("//p[@class='form-actions']/input"));
    private final Element labelLoginErrorMessage = new Element(By.xpath("//p[@class='message error LoginForm']"));

    public void login(AccountInformation accountInformation) {
        textUsername.enter(accountInformation.email);
        textPassword.enter(accountInformation.password);
        buttonLogin.click();
    }

    public void loginFailMultipleTimes(AccountInformation account, int loginTimes) {
        textUsername.enter(account.email);
        textPassword.enter(account.password + "1");
        buttonLogin.click();
        for (int i = 0; i < loginTimes; i++) {
            buttonLogin.scrollToView(buttonLogin);
            textPassword.enter(account.password + "1");
            buttonLogin.click();
        }
    }

    public String getLoginErrorMessage() {
        return labelLoginErrorMessage.getText();
    }

}