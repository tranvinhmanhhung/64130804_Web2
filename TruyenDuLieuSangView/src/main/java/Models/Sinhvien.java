package Models;

public class Sinhvien {
    private String mssv;
    private String hoTen;
    private boolean gioiTinh;
    private String namSinh; // Đúng với tên gọi trong Thymeleaf

    public Sinhvien(String mssv, String hoTen, boolean gioiTinh, String namSinh) {
        this.mssv = mssv;
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.namSinh = namSinh;
    }

    public String getMssv() { return mssv; }
    public String getHoTen() { return hoTen; }
    public boolean isGioiTinh() { return gioiTinh; }
    public String getNamSinh() { return namSinh; } // Đảm bảo có getter này
}
