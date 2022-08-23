package PageObjects.railway;

import dataobjects.TicketInformation;
import dataobjects.datatype.ArriveAt;
import dataobjects.datatype.DepartFrom;
import dataobjects.datatype.TrainTimeTable;
import element.Element;
import org.openqa.selenium.By;

public class TimetablePage extends BasePage {
    TicketInformation ticketInformation = new TicketInformation();

    private final String findRoute = "//tr[td[%s][contains(text(),'%s')]" +
            " and td[%s][contains(text(),'%s')]]/td[%s]";
    private final String findFilterComponent = "//div[@class='Filter']//tr[2]/td/%s[contains(@name,'%s')]";

    private final Element linkBookTicket = new Element(By.xpath(String.format(findRoute, TrainTimeTable.DEPART_STATION.getColumnIndex()
            , DepartFrom.HUE.getName(), TrainTimeTable.ARRIVE_STATION.getColumnIndex()
            , DepartFrom.SAI_GON.getName(), TrainTimeTable.BOOK_TICKET.getColumnIndex())));


    public TicketInformation getSelectedRouteStations() {
        ticketInformation.departStation = DepartFrom.HUE.getName();
        ticketInformation.arriveStation = ArriveAt.SAI_GON.getName();
        return ticketInformation;
    }

    public void clickBookTicketLink() {
        linkBookTicket.scrollToView(linkBookTicket);
        linkBookTicket.click();
    }
}
