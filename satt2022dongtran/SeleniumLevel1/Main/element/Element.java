package element;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import driver.DriverManager;


public class Element {
    public By locator;

    public Element(By locator) {
        this.locator = locator;
    }

    public WebElement findElement(){
        return DriverManager.getDriver().findElement(this.locator);
    }

    public String getText() {
        return findElement().getText();
    }

    public void click() {
        findElement().click();
    }

    public void enter(String text) {
        findElement().sendKeys(text);
    }

    public boolean isDisplayed() {
        return this.findElement().isDisplayed();
    }

    public void scrollToView(Element element) {
        WebElement webElement = element.findElement();
        ((JavascriptExecutor) DriverManager.getDriver())
                .executeScript("arguments[0].scrollIntoView(true);", webElement);
    }
}
