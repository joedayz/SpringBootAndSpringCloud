package pe.joedayz.customerservice.service;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pe.joedayz.customerservice.domain.Customer;


@FeignClient("customer-service")
interface CustomerClient {
	
	
	@RequestMapping(method = RequestMethod.GET, value="/customerservice/v1/customer/all")
	List<Customer> getCustomers();
	
	@RequestMapping(method = RequestMethod.GET, value="/ustomerservice/v1/customer/simple/{id}")
	Customer getCustomer(@PathVariable("id") Long id);
	
}