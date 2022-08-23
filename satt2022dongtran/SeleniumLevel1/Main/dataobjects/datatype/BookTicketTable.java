package dataobjects.datatype;

public enum BookTicketTable {
    DEPART_STATION("Depart Station", "1"),
    ARRIVE_STATION("Arrive Station", "2"),
    SEAT_TYPE("Seat Type", "3"),
    DEPART_DATE("Depart Date", "4"),
    BOOK_DATE("Book Date", "5"),
    EXPIRE_DATE("Expire Date", "6"),
    TICK_AMOUNT("Amount","7"),
    TOTAL_PRICE("Total price", "8");

    public final String name;
    public final String columnIndex;

    BookTicketTable (String name, String columnIndex) {
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
