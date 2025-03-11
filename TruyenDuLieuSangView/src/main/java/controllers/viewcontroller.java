package controllers;

import Models.sinhvien;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

@Controller
class viewcontroller {

    @RequestMapping("/view")
    public String truyenDuLieu(ModelMap model) {
        model.addAttribute("mssv", "64130804");
        model.addAttribute("hoVaTen", "Tran Vinh Manh Hung");
        model.addAttribute("namSinh", "2004");
        model.addAttribute("gioiTinh", "Nam");
        return "view";
    }

    @GetMapping("/truyendsObject")
    public String truyenDsObject(ModelMap model) {
        List<sinhvien> studentModelList = List.of(
                new sinhvien("64130053", "Nguyễn A", true, "20/03/2003"),
                new sinhvien("64130000", "Nguyễn B", false, "01/01/2001"),
                new sinhvien("64131234", "Đỗ C", true, "03/03/2005"),
                new sinhvien("64130343", "Đõ D", false, "04/04/2004")
        );

        model.addAttribute("studentModelList", studentModelList);
        return "listview";
    }
}
