package pe.joedayz.customerservice;

import java.util.NoSuchElementException;

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

@Aspect
@Component
public class RestControllerAspect {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    CounterService counterService;

    @Before("execution(public * pe.joedayz.customerservice.api.rest.*Controller.*(..))")
    public void logBeforeRestCall(JoinPoint pjp) throws Throwable {
        logger.info(":::::AOP Before for Customer REST call:::::" + pjp);
    }

    @AfterReturning("execution(public * pe.joedayz.customerservice.api.rest.*Controller.createCustomer*(..))")
    public void afterCallingCreateCustomer(JoinPoint pjp) {
        logger.info(":::::AOP @AfterReturning Create Customer REST call:::::" + pjp);
        counterService.increment("pe.joedayz.customerservice.api.rest.CustomerController.createCustomer");
    }

    @AfterReturning("execution(public * pe.joedayz.customerservice.api.rest.*Controller.getAllCustomersByPage*(..))")
    public void afterCallingGetAllCustomersByPage(JoinPoint pjp) {
        logger.info(":::::AOP @AfterReturning Customer getAllCustomersByPage REST call:::::" + pjp);

        counterService.increment("pe.joedayz.customerservice.api.rest.CustomerController.getAllCustomersByPage");
    }

    @AfterReturning("execution(public * pe.joedayz.customerservice.api.rest.*Controller.getAllCustomers*(..))")
    public void afterCallingGetAllCustomer(JoinPoint pjp) {
        logger.info(":::::AOP @AfterReturning CustomerController getAllCustomers REST call:::::" + pjp);
        counterService.increment("pe.joedayz.customerservice.api.rest.CustomerController.getAllCustomers");
    }

    @AfterReturning("execution(public * pe.joedayz.customerservice.api.rest.*Controller.getCustomer*(..))")
    public void afterCallingGetCustomer(JoinPoint pjp) {
        logger.info(":::::AOP @AfterReturning CustomerController getCustomer REST call:::::" + pjp);
        counterService.increment("pe.joedayz.customerservice.api.rest.CustomerController.getCustomer");
    }

    @AfterReturning("execution(public * pe.joedayz.customerservice.api.rest.*Controller.updateCustomer*(..))")
    public void afterCallingUpdateCustomer(JoinPoint pjp) {
        logger.info(":::::AOP @AfterReturning CustomerController updateCustomer REST call:::::" + pjp);
        counterService.increment("pe.joedayz.customerservice.api.rest.CustomerController.updateCustomer");
    }

    @AfterReturning("execution(public * pe.joedayz.customerservice.api.rest.*Controller.deleteCustomer*(..))")
    public void afterCallingDeleteCustomer(JoinPoint pjp) {
        logger.info(":::::AOP @AfterReturning CustomerController deleteCustomer REST call:::::" + pjp);
        counterService.increment("pe.joedayz.customerservice.api.rest.CustomerController.deleteCustomer");
    }

    @AfterThrowing(pointcut = "execution(public * pe.joedayz.customerservice.api.rest.*Controller.*(..))", throwing = "e")
    public void afterCustomerThrowsException(NoSuchElementException e) {
        counterService.increment("counter.errors.customer.controller");
    }
}
