package edu.thomc.truyendulieusangview;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "controllers")
public class TruyenDuLieuSangViewApplication {

    public static void main(String[] args) {
        SpringApplication.run(TruyenDuLieuSangViewApplication.class, args);
    }

}
