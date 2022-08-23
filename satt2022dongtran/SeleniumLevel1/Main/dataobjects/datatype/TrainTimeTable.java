package dataobjects.datatype;

public enum TrainTimeTable {
    NO("1"),
    DEPART_STATION("2"),
    ARRIVE_STATION("3"),
    DEPART_TIME("4"),
    ARRIVE_TIME("5"),
    CHECK_PRICE("6"),
    BOOK_TICKET("7");

    private final String columnIndex;

    TrainTimeTable(String columnIndex){
        this.columnIndex = columnIndex;
    }

    public String getColumnIndex() {
        return columnIndex;
    }
}


