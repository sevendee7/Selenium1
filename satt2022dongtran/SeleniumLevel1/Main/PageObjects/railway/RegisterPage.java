package PageObjects.railway;

import dataobjects.AccountInformation;
import element.Element;
import org.openqa.selenium.By;

public class RegisterPage extends BasePage {

    private final Element textEmail = new Element(By.xpath("//input[@id='email']"));
    private final Element textPassword = new Element(By.xpath("//input[@id='password']"));
    private final Element textConfirmPwd = new Element(By.xpath("//input[@id='confirmPassword']"));
    private final Element textPassport = new Element(By.xpath("//input[@id='pid']"));
    private final Element buttonRegister = new Element(By.xpath("//p[@class='form-actions']/input"));
    private final Element labelRegisterMessage = new Element(By.xpath("//div[@id='content']/p"));
    private final Element labelRegisterErrorMessage = new Element(By.xpath("//p[@class='message error']"));
    private final Element labelPasswordValidateMessage = new Element(By.xpath("//li[@class='password']/label[@class='validation-error']"));
    private final Element labelPassportValidateMessage = new Element(By.xpath("//li[@class='pid-number']/label[@class='validation-error']"));

    public void registerAccount(AccountInformation accountInformation) {
        textEmail.enter(accountInformation.email);
        textPassword.enter(accountInformation.password);
        textConfirmPwd.enter(accountInformation.confirmPassword);
        textPassport.enter(accountInformation.passport);
        buttonRegister.scrollToView(buttonRegister);
        buttonRegister.click();
    }

    public void registerRandomAccount(AccountInformation accountInformation) {
        textEmail.enter(accountInformation.email);
        textPassword.enter(accountInformation.password);
        textConfirmPwd.enter(accountInformation.confirmPassword);
        textPassport.enter(accountInformation.passport);
        buttonRegister.scrollToView(buttonRegister);
        buttonRegister.click();
    }

    public String getRegisterSuccessfulMessage() {
        return labelRegisterMessage.getText();
    }

    public String getRegisterFailMessage() {
        return labelRegisterErrorMessage.getText();
    }

    public String getPasswordValidateText() {
        return labelPasswordValidateMessage.getText();
    }

    public String getPassportValidateText() {
        return labelPassportValidateMessage.getText();
    }
}
