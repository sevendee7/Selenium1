package dataobjects.datatype;

public enum ManageTicketTable {
    NO("Index", "1"),
    DEPART_STATION("Depart Station", "2"),
    ARRIVE_STATION("Arrive Station", "3"),
    SEAT_TYPE("Seat Type", "4"),
    DEPART_DATE("Depart Date", "5"),
    BOOK_DATE("Book Date", "6"),
    EXPIRE_DATE("Expire Date", "7"),
    STATUS("Status", "8"),
    TICK_AMOUNT("Amount","9"),
    TOTAL_PRICE("Total price", "10"),
    OPERATION("Operation", "11");

    public final String name;
    public final String columnIndex;

    ManageTicketTable (String name, String columnIndex) {
        this.name = name;
        this.columnIndex = columnIndex;
    }

    public String getName() {
        return name;
    }

    public String getColumnIndex() {
        return columnIndex;
    }
}
