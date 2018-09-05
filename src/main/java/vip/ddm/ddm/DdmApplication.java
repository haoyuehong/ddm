package vip.ddm.ddm;

import com.github.tobato.fastdfs.FdfsClientConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.context.annotation.Import;
import org.springframework.jmx.support.RegistrationPolicy;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Import(FdfsClientConfig.class)
@SpringBootApplication
@EnableTransactionManagement
@MapperScan("vip.ddm.ddm.dao")
@EnableScheduling
public class DdmApplication {

    public static void main(String[] args) {
        SpringApplication.run(DdmApplication.class, args);
    }
}
