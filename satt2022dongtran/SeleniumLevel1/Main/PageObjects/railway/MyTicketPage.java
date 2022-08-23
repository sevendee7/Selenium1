package PageObjects.railway;

import common.helper.Helper;
import dataobjects.datatype.ManageTicketTable;
import driver.DriverManager;
import element.Element;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class MyTicketPage extends BasePage {
    Helper helper = new Helper();

    public final String deleteButton = "//tbody//input[contains(@onclick,'%s')]";
    public final String randomRow = "//table[@class='MyTable']//tr[%s]//input";
    public final String ticketAmount = "//table[@class='MyTable']//tr[td[%s][contains(text(),'New')]]/td[%s]";
    public final String ticketExpiredRow = "//table[@class='MyTable']//tr[td[contains(text(),'Expired')]]/td[%s]";
    public final String ticketAmountXpath = String.format(ticketAmount
            , ManageTicketTable.STATUS.getColumnIndex(), ManageTicketTable.TICK_AMOUNT.getColumnIndex());


    private final Element firstRowOfTable = new Element(By.xpath("//table[@class='MyTable']//tr"));
    private final Element tableFilter = new Element(By.xpath("//div[@class='Filter']//strong[contains(.,'Filter')]"));
    private final Element noteInformation = new Element(By.xpath("//div[@class='message']/li"));
    private final Element cellTicketAmount = new Element(By.xpath(String.format(ticketAmount
            , ManageTicketTable.STATUS.getColumnIndex(), ManageTicketTable.TICK_AMOUNT.getColumnIndex())));
    private final Element numberOfFirstTicketRowHasExpired = new Element(By.xpath(String.format(ticketExpiredRow, ManageTicketTable.NO.getColumnIndex())));

    public WebElement findDeleteButtonById(String id) {
        Element element = new Element(By.xpath(String.format(deleteButton, id)));
        return element.findElement();
    }

    public int getTicketAmount() {
        int ticketAmount = Integer.parseInt(cellTicketAmount.getText());
        return ticketAmount;
    }

    public int getTableSize() {
        List<WebElement> list = DriverManager.getDriver().findElements(By.xpath(String.format(ticketAmount
                , ManageTicketTable.STATUS.getColumnIndex(), ManageTicketTable.TICK_AMOUNT.getColumnIndex())));
        return list.size();
    }

    public String setNoteInformationByTicketAmount(int ticketAmount) {
        String noteInformation = "You currently book %s tickets, you can book %s more.";
        if (ticketAmount == 0) {
            noteInformation = "You currently book %s ticket, you can book %s more.";
        }
        return String.format(noteInformation, ticketAmount, 10 - ticketAmount);
    }

    public String getActualNoteInformation() {
        return noteInformation.getText();
    }

    public boolean isTicketExisted(String id) {
        try {
            return findDeleteButtonById(id).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void confirmDeleteTicket() {
        DriverManager.getDriver().switchTo().alert().accept();
    }

    public boolean isFilterDisplayed() {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(tableFilter.findElement()));
        return tableFilter.isDisplayed();
    }

    public boolean isTicketExpiredExist() {
        return numberOfFirstTicketRowHasExpired.isDisplayed();
    }

    public int getTotalTicketBooked() {
        return helper.getListElementSize("//table[@class='MyTable']//tr") - 1;
    }

    public void getRandomId(int totalTicket) {
        int randomTicket = ThreadLocalRandom.current().nextInt(2, totalTicket);
    }

    public List<WebElement> getListTicketAmount() {
        return DriverManager.getDriver().findElements(By.xpath(ticketAmountXpath));
    }

    public int getTotalTicket() {
        int totalTicket = 0;
        int totalRows = helper.getListElementSize(ticketAmountXpath);
        List<WebElement> listTicketAmount = getListTicketAmount();
        if (isTicketExpiredExist()) {
            totalRows = Integer.parseInt(numberOfFirstTicketRowHasExpired.getText()) - 1;
        } else if (totalRows == 0) {
            {
                return 0;
            }
        }
        for (int i = 0; i < totalRows; i++) {
            String amountText = listTicketAmount.get(i).getText();
            totalTicket += Integer.parseInt(amountText);
        }
        return totalTicket;
    }
}
