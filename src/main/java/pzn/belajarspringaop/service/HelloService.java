package pzn.belajarspringaop.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class HelloService {

    public String hello(String name) {
        log.info("Call HelloService.hello()");
        return "Hello " + name;
    }

    public String bye(String name) {
        log.info("Call HelloService.bye()");
        return "Bye " + name;
    }
    //coba bayangkan jika bertambah method kita harus menambah juga log.info
    //padahal isinya sama saja, sehingga ini kegunaan dari AOP, kita menulis
    //log satu kali, dan bisa dipakai berkali kali
}
