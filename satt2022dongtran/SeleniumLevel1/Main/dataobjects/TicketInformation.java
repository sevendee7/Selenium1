package dataobjects;

public class TicketInformation {

    public String departDate;
    public String departStation;
    public String arriveStation;
    public String seatType;
    public String ticketAmount;

    public TicketInformation() {
    }

    public TicketInformation(String departDate, String departStation, String arriveStation, String seatType, String ticketAmount) {
        this.departDate = departDate;
        this.departStation = departStation;
        this.arriveStation = arriveStation;
        this.seatType = seatType;
        this.ticketAmount = ticketAmount;
    }

}
