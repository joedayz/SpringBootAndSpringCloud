package pe.joedayz.personservice;



import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.stereotype.Component;

import java.util.NoSuchElementException;

@Aspect
@Component
public class RestControllerAspect {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    CounterService counterService;

    @Before("execution(public * pe.joedayz.personservice.api.*Controller.*(..))")
    public void logBeforeRestCall(JoinPoint pjp) throws Throwable{
        logger.info(":::::::AOP Before REst call ::::::" + pjp);
    }
    @AfterReturning("execution(public * pe.joedayz.personservice.api.*Controller.createPerson*(..))")
    public void afterCallCreatePerson(JoinPoint pjp){
        logger.info(":::::::AOP After returning create person::::::" + pjp);
        counterService.increment("pe.joedayz.personservice.api.PersonController.createPerson");
    }

    @AfterThrowing(pointcut = "execution(public * pe.joedayz.personservice.api.*Controller.*(..))", throwing = "e")
    public void afterGetGreetingThrowsException(NoSuchElementException e) {
        counterService.increment("counter.errors.person.controller");
    }
}
