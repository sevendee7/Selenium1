package dataobjects.datatype;

public enum ArriveAt {
    SAI_GON("Sài Gòn"),
    DA_NANG("Đà Nẵng"),
    HUE("Huế"),
    QUANG_NGAI("Quảng Ngãi"),
    NHA_TRANG("Nha Trang"),
    PHAN_THIET("Phan Thiết");

    public final String name;

    ArriveAt (String arriveStation) {
        this.name = arriveStation;
    }

    public String getName() {
        return name;
    }
}

