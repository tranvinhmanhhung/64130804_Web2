package controllers;

import Models.Sinhvien;
import Models.User;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class viewcontroller {

    private static final String ID = "64130804";
    private static final String PW = "123456";

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
        List<Sinhvien> studentModelList = List.of(
                new Sinhvien("64130053", "Nguyễn A", true, "20/03/2003"),
                new Sinhvien("64130000", "Nguyễn B", false, "01/01/2001"),
                new Sinhvien("64131234", "Đỗ C", true, "03/03/2005"),
                new Sinhvien("64130343", "Đõ D", false, "04/04/2004")
        );

        model.addAttribute("studentModelList", studentModelList);
        return "listview";
    }

    @RequestMapping("/login")
    public String login(HttpServletRequest request, ModelMap model) throws ParseException {
        String id = request.getParameter("id");
        String pw = request.getParameter("pw");

        if (ID.equals(id) && PW.equals(pw)) {
            Date dob = new SimpleDateFormat("yyyy-MM-dd").parse("2004-08-11");
            User user = new User(id, "Tran Vinh Manh Hung", true, dob);
            model.addAttribute("uInfo", user);
            return "userlogin";
        } else {
            model.addAttribute("error", "Invalid username or password");
            return "login";
        }
    }
}
