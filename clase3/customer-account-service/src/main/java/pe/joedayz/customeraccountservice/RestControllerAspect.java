package pe.joedayz.customeraccountservice;

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

	@Before("execution(public * pe.joedayz.customeraccountservice.api.rest.*Controller.*(..))")
	public void logBeforeRestCall(JoinPoint pjp) throws Throwable {
		logger.info(":::::AOP Before REST call:::::" + pjp);
	}
	
	@AfterReturning("execution(public * pe.joedayz.customeraccountservice.api.rest.*Controller.createCustomerAccount*(..))")
    public void afterCallingCreateCustomerAccount(JoinPoint pjp) {
		logger.info(":::::AOP @AfterReturning Create REST call:::::" + pjp);
        counterService.increment("pe.joedayz.customeraccountservice.api.rest.CustomerAccountController.createCustomerAccount");
    }
	
	@AfterReturning("execution(public * pe.joedayz.customeraccountservice.api.rest.*Controller.getAllCustomersAccountByPage*(..))")
    public void afterCallinggetAllCustomerAccount(JoinPoint pjp) {
		logger.info(":::::AOP @AfterReturning getAllCustomerAccount REST call:::::" + pjp);
        counterService.increment("pe.joedayz.customeraccountservice.api.rest.CustomerAccountController.getAllCustomerAccount");
    }

	
	@AfterReturning("execution(public * pe.joedayz.customeraccountservice.api.rest.*Controller.getAllCustomerAccounts*(..))")
    public void afterCallinggetCustomerAccount(JoinPoint pjp) {
		logger.info(":::::AOP @AfterReturning getCustomerAccount REST call:::::" + pjp);
        counterService.increment("pe.joedayz.customeraccountservice.api.rest.CustomerAccountController.getCustomerAccount");
    }

	@AfterReturning("execution(public * pe.joedayz.customeraccountservice.api.rest.*Controller.updateCustomerAccount*(..))")
    public void afterCallingUpdateCustomerAccount(JoinPoint pjp) {
		logger.info(":::::AOP @AfterReturning updateCustomerAccount REST call:::::" + pjp);
        counterService.increment("pe.joedayz.customeraccountservice.api.rest.CustomerAccountController.updateCustomerAccount");
    }
	
	
    @AfterThrowing(pointcut = "execution(public * pe.joedayz.customeraccountservice.api.rest.*Controller.*(..))", throwing = "e")
    public void afterGetGreetingThrowsException(NoSuchElementException e) {
        counterService.increment("counter.errors.CustomerAccount.controller");
    }
}
