package pe.joedayz.customeraccountservice;

import org.springframework.beans.BeansException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableAutoConfiguration
@ComponentScan(basePackages = "pe.joedayz")
@EnableJpaRepositories("pe.joedayz.customeraccountservice.dao.jpa")
@EnableSwagger2
@EnableDiscoveryClient
@EnableFeignClients
@EnableCircuitBreaker
public class CustomerAccountServiceApplication implements ApplicationContextAware {

	public static void main(String[] args) {
		SpringApplication.run(CustomerAccountServiceApplication.class, args);
	}

	@Override
	public void setApplicationContext(ApplicationContext ac) throws BeansException {
		//force the bean to get loaded as soon as possible
		ac.getBean("requestMappingHandlerAdapter");
	}
}
