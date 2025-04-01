package edu.thomc.tonghopgk;

import model.Personal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.ArrayList;
import java.util.Arrays;

@Controller
public class HomeController{
    ArrayList<Personal> dsSinhVien=new ArrayList<Personal>(Arrays.asList(
            new Personal("64131930", "Nguyễn Minh Quang", 8.7),
            new Personal("64131931", "Trần Thị Lan", 7.5),
            new Personal("64131932", "Phạm Văn Hùng", 6.2),
            new Personal("64131933", "Lê Minh Tuấn", 9.0),
            new Personal("64131934", "Hoàng Thị Mai", 5.8),
            new Personal("64131935", "Đoàn Ngọc Sơn", 6.5),
            new Personal("64131936", "Vũ Thị Thanh", 7.0),
            new Personal("64131937", "Ngô Minh Tiến", 8.0),
            new Personal("64131938", "Bùi Thị Nhung", 7.9),
            new Personal("64131939", "Dương Minh Hoàng", 6.8)
    )

    );


    @GetMapping("/")
    public String home() {
        return "homePage";
    }

    @GetMapping("/aboutMe")
    public String profile(Model model) {
        model.addAttribute("content","profile");
        model.addAttribute("Ten","Trần Vĩnh Mạnh Hưng");
        model.addAttribute("Tuoi","21");
        model.addAttribute("Sdt","0896614425");
        model.addAttribute("Email","hung.tvm.64cntt@ntu.edu.vn");
        model.addAttribute("Diachi","61 Tôn Thất Tùng - P.Vĩnh Thọ - Nha Trang");
        return "homePage";
    }
    @GetMapping("/list")
    public String getList(Model model) {
        model.addAttribute("dsSV",dsSinhVien);
        model.addAttribute("content","list");
        return "homePage";
    }
    @GetMapping("/add")
    public String addNew(Model model) {
        model.addAttribute("content","addNew");
        return "homePage";
    }
    @PostMapping("/addGet")
    public String getAdd(@RequestParam(name="hoTen") String hoTen,@RequestParam(name="dtb") Double dtb,Model model) {
        String id=String.format("%03d", dsSinhVien.size());
        dsSinhVien.add(new Personal("SV"+id, hoTen, dtb));
        model.addAttribute("content","addNew");
        return "homePage";
    }
    @PostMapping("/save")
    public String saveInfor(@RequestParam(name="mssv") String id,@RequestParam(name="name") String name,@RequestParam(name="diem") double diem,Model model) {
        for (Personal personal : dsSinhVien) {
            if(personal.getMSSV1().equals(id)) {
                personal.setHoTen(name);
                personal.setDtb(diem);
                break;
            }else {
                continue;
            }
        }
        return "redirect:/list";
    }
}
