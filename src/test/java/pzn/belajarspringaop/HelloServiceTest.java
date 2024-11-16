package pzn.belajarspringaop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pzn.belajarspringaop.service.HelloService;

@SpringBootTest
public class HelloServiceTest {

    @Autowired
    private HelloService helloService;

    @Test
    public void testHelloService() {
        Assertions.assertEquals("Hello World", helloService.hello("World"));
        Assertions.assertEquals("Bye World", helloService.bye("World"));
    }
}
