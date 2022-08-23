package dataobjects.datatype;

public enum SeatType {
    HS("Hard seat"),
    SS("Soft seat"),
    SSC("Soft seat with air conditioner"),
    HB("Hard bed"),
    SB("Soft bed"),
    SBC("Soft bed with air conditioner");

    public final String name;

    SeatType (String seatType) {
        this.name = seatType;
    }

    public String getName() {
        return name;
    }
}
