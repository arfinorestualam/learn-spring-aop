package pzn.belajarspringaop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

//cukup tambahkan annotation ini untuk mengaktifkan AOP
@EnableAspectJAutoProxy
@SpringBootApplication
public class BelajarSpringAopApplication {

    public static void main(String[] args) {
        SpringApplication.run(BelajarSpringAopApplication.class, args);
    }

}
