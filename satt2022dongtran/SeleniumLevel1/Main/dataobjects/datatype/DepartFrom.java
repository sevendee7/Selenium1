package dataobjects.datatype;

public enum DepartFrom {
    SAI_GON("Sài Gòn","1"),
    PHAN_THIET("Phan Thiết","2"),
    NHA_TRANG("Nha Trang","3"),
    DA_NANG("Đà Nẵng","4"),
    HUE("Huế","5"),
    QUANG_NGAI("Quảng Ngãi","6");

    public final String name;
    public final String index;

    DepartFrom (String name, String index) {
        this.name = name;
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public String getIndex() {
        return index;
    }
}
