package pzn.belajarspringaop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {
}
//jika hanya diatas, aspect tidak berguna, maka harus di tambahkan
//behaviour, dengan ketentuan yang ada.
