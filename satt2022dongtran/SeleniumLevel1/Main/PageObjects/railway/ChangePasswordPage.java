package PageObjects.railway;

import dataobjects.AccountInformation;
import element.Element;
import org.openqa.selenium.By;

public class ChangePasswordPage extends BasePage {
    private final Element textCurrentPassword = new Element(By.xpath("//input[@id='currentPassword']"));
    private final Element textNewPassword = new Element(By.xpath("//input[@id='newPassword']"));
    private final Element textConfirmPassword = new Element(By.xpath("//input[@id='confirmPassword']"));
    private final Element buttonChangePassword = new Element(By.xpath("//p[@class='form-actions']/input"));
    private final Element labelChangePasswordMessage = new Element(By.xpath("//p[@class='message success']"));


    public void changePassword(AccountInformation accountInformation) {
        textCurrentPassword.enter(accountInformation.password);
        textNewPassword.enter(accountInformation.newPassword);
        textConfirmPassword.enter(accountInformation.newPassword);
        buttonChangePassword.click();
    }

    public String getChangePwdMsg() {
        return labelChangePasswordMessage.getText();
    }
}
