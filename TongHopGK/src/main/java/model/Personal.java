package model;

public class Personal {
    private String MSSV, hoTen;
    private double dtb;

    public Personal(String MSSV, String hoTen, double d) {
        this.MSSV = MSSV;
        this.hoTen = hoTen;
        this.dtb = d;
    }

    public String getMSSV1() {
        return MSSV;
    }

    public String getHoTen1() {
        return hoTen;
    }

    public double getDTB() {
        return dtb;
    }

    public void setMSSV(String MSSV) {
        this.MSSV = MSSV;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public void setDtb(double dtb) {
        this.dtb = dtb;
    }
}