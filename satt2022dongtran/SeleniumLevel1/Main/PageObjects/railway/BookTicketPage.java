package PageObjects.railway;

import common.constant.Constant;
import common.helper.Helper;
import dataobjects.TicketInformation;
import dataobjects.datatype.ArriveAt;
import dataobjects.datatype.BookTicketTable;
import dataobjects.datatype.DepartFrom;
import dataobjects.datatype.SeatType;
import driver.DriverManager;
import element.Element;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.concurrent.ThreadLocalRandom;

public class BookTicketPage extends BasePage {
    Helper helper = new Helper();
    TicketInformation ticketInformation = new TicketInformation();
    TicketInformation routeInformation = new TicketInformation();
    Select selectDepartDate;
    Select selectDepartStation;
    Select selectArriveStation;
    Select selectSeatType;
    Select selectTicketAmount;

    private static final String xpathTicketInformationTable = "//tr[@class='OddRow']/td[%s]";

    private final Element comboBoxDepartDate = new Element(By.xpath("//div[@id='content']//select[@name='Date']"));
    private final Element comboBoxDepartFrom = new Element(By.xpath("//div[@id='content']//select[@name='DepartStation']"));
    private final Element selectedDepartFrom = new Element(By.xpath("//div[@id='content']//select[@name='DepartStation']" +
            "/option[@selected='selected']"));
    private final Element comboBoxArriveAt = new Element(By.xpath("//div[@id='content']//select[@name='ArriveStation']"));
    private final Element selectedArriveAt = new Element(By.xpath("//div[@id='content']//select[@name='ArriveStation']" +
            "/option[@selected='selected']"));
    private final Element comboBoxSeatType = new Element(By.xpath("//div[@id='content']//select[@name='SeatType']"));
    private final Element comboBoxTicketAmount = new Element(By.xpath("//div[@id='content']//select[@name='TicketAmount']"));
    private final Element buttonBookTicket = new Element(By.xpath("//div[@id='content']//input"));
    private final Element labelBookTicketMessage = new Element(By.xpath("//div[@id='content']/h1"));
    private final Element labelDepartStation = new Element(By.xpath(String.format(xpathTicketInformationTable, BookTicketTable.DEPART_STATION.getColumnIndex())));
    private final Element labelArriveStation = new Element(By.xpath(String.format(xpathTicketInformationTable, BookTicketTable.ARRIVE_STATION.getColumnIndex())));
    private final Element labelSeatType = new Element(By.xpath(String.format(xpathTicketInformationTable, BookTicketTable.SEAT_TYPE.getColumnIndex())));
    private final Element labelDepartDate = new Element(By.xpath(String.format(xpathTicketInformationTable, BookTicketTable.DEPART_DATE.getColumnIndex())));
    private final Element labelTicketAmount = new Element(By.xpath(String.format(xpathTicketInformationTable, BookTicketTable.TICK_AMOUNT.getColumnIndex())));

    public String bookRandomTicket() {
        selectDepartDate = new Select(comboBoxDepartDate.findElement());
        selectDepartStation = new Select(comboBoxDepartFrom.findElement());
        selectArriveStation = new Select(comboBoxArriveAt.findElement());
        selectSeatType = new Select(comboBoxSeatType.findElement());
        selectTicketAmount = new Select(comboBoxTicketAmount.findElement());

        ticketInformation.departDate = selectRandomDepartDate();
        routeInformation = selectRandomStations();
        ticketInformation.departStation = routeInformation.departStation;
        ticketInformation.arriveStation = routeInformation.arriveStation;
        buttonBookTicket.scrollToView(buttonBookTicket);
        ticketInformation.seatType = selectRandomSeatType();
//        ticketInformation.ticketAmount = selectTicketAmount(Constant.TICKET_AMOUNT);
        ticketInformation.ticketAmount = selectRandomTicketAmount();
        buttonBookTicket.click();
        String currentUrl = DriverManager.getCurrentUrl();

        return helper.getTicketIdFromUrl(currentUrl);
    }

    public String getSuccessfullyBookTicketMessage() {
        return labelBookTicketMessage.getText();
    }

    public TicketInformation getBookedTicketInformation() {
        ticketInformation.departStation = labelDepartStation.getText();
        ticketInformation.arriveStation = labelArriveStation.getText();
        ticketInformation.seatType = labelSeatType.getText();
        ticketInformation.departDate = labelDepartDate.getText();
        ticketInformation.ticketAmount = labelTicketAmount.getText();
        return ticketInformation;
    }

    public TicketInformation bookTicket(String departDate, DepartFrom departStation, ArriveAt arriveStation,
                                        SeatType seatType, String ticketAmount) {
        selectDepartDate = new Select(comboBoxDepartDate.findElement());
        selectDepartStation = new Select(comboBoxDepartFrom.findElement());
        selectArriveStation = new Select(comboBoxArriveAt.findElement());
        selectSeatType = new Select(comboBoxSeatType.findElement());
        selectTicketAmount = new Select(comboBoxTicketAmount.findElement());

        ticketInformation.departDate = selectDepartDate(departDate);
        ticketInformation.departStation = selectDepartFrom(departStation);
        comboBoxArriveAt.scrollToView(comboBoxArriveAt);
        ticketInformation.arriveStation = selectArriveAt(arriveStation);
        ticketInformation.seatType = selectSeatType(seatType);
        buttonBookTicket.scrollToView(buttonBookTicket);
        ticketInformation.ticketAmount = selectTicketAmount(ticketAmount);
        buttonBookTicket.click();
        return ticketInformation;
    }

    public String selectRandomDepartDate() {
        comboBoxDepartDate.click();
        String randomDate = helper.generateRandomDateBetween(Constant.START_DATE, Constant.END_DATE);
        selectDepartDate.selectByVisibleText(randomDate);
        return randomDate;
    }

    public String selectRandomDepartDateByIndex() {
        String optionDepartDate = "//div[@id='content']//select[@name='Date']/option";
        int departDateSize = helper.getListElementSize(optionDepartDate) - 1;
        int randomIndex = ThreadLocalRandom.current().nextInt(0, departDateSize);
        comboBoxDepartDate.click();
        selectDepartDate.selectByIndex(++randomIndex);
        ticketInformation.departDate = Constant.WEBDRIVER
                .findElement(By.xpath("//div[@id='content']//select[@name='Date']/option[" + randomIndex + "]"))
                .getText();
        return ticketInformation.departDate;
    }

    public String selectDepartDate(String departDate) {
        comboBoxDepartDate.click();
        selectDepartDate.selectByVisibleText(departDate);
        return departDate;
    }

    public String selectDepartFrom(DepartFrom departFrom) {
        comboBoxDepartFrom.click();
        selectDepartStation.selectByVisibleText(departFrom.getName());
        return departFrom.getName();
    }

    public String selectArriveAt(ArriveAt arriveAt) {
        comboBoxArriveAt.click();
        selectArriveStation.selectByVisibleText(arriveAt.getName());
        return arriveAt.getName();
    }

    public String selectSeatType(SeatType seatType) {
        comboBoxSeatType.click();
        selectSeatType.selectByVisibleText(seatType.getName());
        return seatType.getName();
    }

    public String selectTicketAmount(String ticketAmount) {
        comboBoxTicketAmount.click();
        selectTicketAmount.selectByVisibleText(ticketAmount);
        return ticketAmount;
    }

    public TicketInformation selectRandomStations() {
        String optionDepartStation = "//div[@id='content']//select[@name='DepartStation']/option";
        int departStationSize = helper.getListElementSize(optionDepartStation) - 1;
        int randomIndex = ThreadLocalRandom.current().nextInt(0, departStationSize);
        comboBoxDepartFrom.click();
        selectDepartStation.selectByIndex(++randomIndex);
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(5));
        wait.until(ExpectedConditions.stalenessOf(comboBoxArriveAt.findElement()));
        comboBoxArriveAt.scrollToView(comboBoxArriveAt);
        routeInformation.departStation = DriverManager.getDriver()
                .findElement(By.xpath("//div[@id='content']//select[@name='DepartStation']/option[" + randomIndex + "]"))
                .getText();
        String optionArriveStation = "//div[@id='content']//select[@name='ArriveStation']/option";
        int arriveStationSize = helper.getListElementSize(optionArriveStation);
        routeInformation.arriveStation = selectRandomArriveStation(arriveStationSize);
        return routeInformation;
    }

    public String selectRandomArriveStation(int arriveStationSize) {
        int randomIndex = ThreadLocalRandom.current().nextInt(0, arriveStationSize);
        comboBoxArriveAt.click();
        try {
            selectArriveStation.selectByIndex(randomIndex);
        } catch (Exception e) {
            selectArriveStation = new Select(comboBoxArriveAt.findElement());
            selectArriveStation.selectByIndex(randomIndex);
        }
        ++randomIndex;
        try {
            routeInformation.arriveStation = DriverManager
                    .getDriver()
                    .findElement(By.xpath("//div[@id='content']//select[@name='ArriveStation']/option[" + randomIndex + "]"))
                    .getText();
        } catch (Exception e) {
            routeInformation.arriveStation = DriverManager
                    .getDriver()
                    .findElement(By.xpath("//div[@id='content']//select[@name='ArriveStation']/option[" + randomIndex + "]"))
                    .getText();
        }
        return routeInformation.arriveStation;
    }

    public String selectRandomSeatType() {
        String optSeatType = "//div[@id='content']//select[@name='SeatType']/option";
        int seatTypeSize = helper.getListElementSize(optSeatType) - 1;
        int randomIndex = (ThreadLocalRandom.current().nextInt(0, seatTypeSize));
        buttonBookTicket.scrollToView(buttonBookTicket);
        comboBoxSeatType.click();
        selectSeatType.selectByIndex(randomIndex);
        randomIndex++;
        ticketInformation.seatType = DriverManager
                .getDriver()
                .findElement(By.xpath("//div[@id='content']//select[@name='SeatType']/option[" + randomIndex + "]"))
                .getText();
        return ticketInformation.seatType;
    }

    public String getDepartStation() {
        return selectedDepartFrom.getText();
    }

    public String getArriveStation() {
        return selectedArriveAt.getText();
    }

    public String selectRandomTicketAmount() {
        String optionTicketAmount = "//div[@id='content']//select[@name='TicketAmount']/option";
        int ticketNumberSize = helper.getListElementSize(optionTicketAmount) - 1;
        int randomIndex = (ThreadLocalRandom.current().nextInt(0, ticketNumberSize/2));
        ;
        comboBoxTicketAmount.click();
        selectTicketAmount.selectByIndex(++randomIndex);
        ticketInformation.ticketAmount = DriverManager
                .getDriver()
                .findElement(By.xpath("//div[@id='content']//select[@name='TicketAmount']/option[" + randomIndex + "]"))
                .getText();
        return ticketInformation.ticketAmount;
    }

    public String selectTicketAmount(int ticketQuantity) {
        comboBoxTicketAmount.click();
        selectTicketAmount.selectByIndex(ticketQuantity - 1);
        ticketInformation.arriveStation = DriverManager
                .getDriver()
                .findElement(By.xpath("//div[@id='content']//select[@name='TicketAmount']/option[" + ticketQuantity + "]"))
                .getText();
        return ticketInformation.ticketAmount;
    }

    public void bookTicketMultipleTimes(int bookTimes) {
        for (int i = 0; i < bookTimes; i++) {
            bookRandomTicket();
            goToBookTicketPage();
        }
    }
}
