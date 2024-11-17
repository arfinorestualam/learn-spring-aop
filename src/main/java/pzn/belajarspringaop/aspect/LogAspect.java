package pzn.belajarspringaop.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

//@Aspect
//@Component
//public class LogAspect {
//}
//jika hanya diatas, aspect tidak berguna, maka harus di tambahkan
//behaviour, dengan ketentuan yang ada.

//penambahan pointcut dibawah

@Slf4j
@Aspect
@Component
public class LogAspect {

    @Pointcut("target(pzn.belajarspringaop.service.HelloService)")
    public void helloServiceMethod() {
    }
    //semua method yang berada di hello service akan di jalankan
    //target harus full satu package menuju kelas yang ingin di gunakan
    // dan target haruslah bean, jika tidak maka akan gagal.

    //disini letak advice, atau mau ngelakuin apa sih dari aspect ini sendiri
    //didalam annotation, masukkan nama pointcut yang ingin di target.
    //advice juga bisa lebih dari 1, dengan annotation yang sama dan target yang sama,
    //ubah method dengan isi yang beda dikit masih bisa tetap jalan.

//    @Before("helloServiceMethod()")
//    public void beforeHelloServiceMethod() {
//        log.info("Before HelloService Method");
//    }
    //arti dari method diatas adalah, sebelum pointcut menjalankan target
    //maka method ini akan dijalankan terlebih dahulu dengan menghasilkan
    //log sebagai bukti kalo sudah berjalan.

    //penggunaan advice parameter dengan joinpoint

//    @Before("helloServiceMethod()")
//    public void beforeHelloServiceMethod(JoinPoint joinPoint) {
//        String className = joinPoint.getTarget().getClass().getSimpleName();
//        String methodName = joinPoint.getSignature().getName();
//        log.info("Before , Class Name: {}, Method Name: {}", className, methodName);
//    }

    //untuk advice around, harus menggunakan parameter proceedingjoinpoint
    //jika tidak, tidak akan berjalan, jangan lupa untuk proceed dengan args

    @Around("helloServiceMethod()")
    public Object aroundHelloServiceMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String methodName = joinPoint.getSignature().getName();

        try {
            log.info("Around Before , Class Name: {}, Method Name: {}", className, methodName);
            return joinPoint.proceed(joinPoint.getArgs());
        } catch (Throwable throwable) {
            log.error("Around Error {}.{}()", className, methodName, throwable);
            throw throwable;
        } finally {
            log.info("Around finally , Class Name: {}, Method Name: {}", className, methodName);
        }
    }
}

//join point dengan beraturan dan berjalan hanya di level method adalah
//point cut.
