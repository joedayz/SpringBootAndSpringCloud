package pe.joedayz.customerservice.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.boot.actuate.metrics.GaugeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import pe.joedayz.customerservice.dao.jpa.RsMortgageCustomerRepository;
import pe.joedayz.customerservice.domain.Customer;


/*
* Service class to do CRUD for User and Address through JPS Repository
*/
@Service
public class RsMortgageCustomerService {

	private static final Logger log = LoggerFactory.getLogger(RsMortgageCustomerService.class);
	
	@Autowired
	private RsMortgageCustomerRepository customerRepository;
	
	@Autowired
	CounterService counterService;
	
	@Autowired
	GaugeService gaugeService;

	public RsMortgageCustomerService() {
	}

	public Customer createCustomer(Customer customer) {
		if (customer.getDateOfBirth() != null) {
			log.info("Customer Date of Birth :" + customer.getDateOfBirth());
		} else {
			log.info("Customer Date of Birth is null :");
		}
	
		return customerRepository.save(customer);
	}

	public Customer getCustomer(long id) {
		return customerRepository.findOne(id);
	}

	public void updateCustomer(Customer customer) {
		customerRepository.save(customer);
	}

	public void deleteCustomer(Long id) {
		customerRepository.delete(id);
	}

	public Page<Customer> getAllCustomersByPage(Integer page, Integer size) {
		Page pageOfCustomers = customerRepository.findAll(new PageRequest(page, size));
		// example of adding to the /metrics
		if (size > 50) {
			counterService.increment("pe.joedayz.getAll.largePayload");
		}
		return pageOfCustomers;
	}

	public List<Customer> getAllCustomers() {
		Iterable<Customer> pageOfCustomers = customerRepository.findAll();
		List<Customer> customers = new ArrayList<Customer>();
		for (Customer customer : pageOfCustomers) {
			customers.add(customer);
		}
		log.info("In Real Service getAllCustomers size :" + customers.size());

		return customers;
	}
}
