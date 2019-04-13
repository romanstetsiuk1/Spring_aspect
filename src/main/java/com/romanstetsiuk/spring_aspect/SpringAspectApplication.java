package com.romanstetsiuk.spring_aspect;

import com.romanstetsiuk.spring_aspect.model.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;

@SpringBootApplication
public class SpringAspectApplication implements CommandLineRunner {

    @Autowired
    UserService userService;

    @Bean
    Company myCompany1() {
        Company company1 = new Company("Best Company", 856,
                new BigDecimal(1522038), "Rzeszów");
        return company1;
    }


    public static void main(String[] args) {
        SpringApplication.run(SpringAspectApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        userService.getUpperName();
//        userService.error();

        myCompany1().setName("New company name");
        myCompany1().setAmountWorkers(1204);
        myCompany1().setRevenueByYear(new BigDecimal(2000159));
        myCompany1().setLocation("Poland");
        myCompany1().getName();
        myCompany1().getAmountWorkers();
        myCompany1().getRevenueByYear();
        myCompany1().getLocation();
    }


}
