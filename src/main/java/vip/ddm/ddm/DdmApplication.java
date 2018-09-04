package vip.ddm.ddm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@MapperScan("vip.ddm.ddm.dao")
@EnableScheduling
public class DdmApplication {

    public static void main(String[] args) {
        SpringApplication.run(DdmApplication.class, args);
    }
}
