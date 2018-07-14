package pe.joedayz.customeraccountservice.dao.jpa;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;


import pe.joedayz.customeraccountservice.domain.Account;
import pe.joedayz.customeraccountservice.domain.Customer;


public interface CustomerAccountRepository extends PagingAndSortingRepository<Account, Long> {
    List<Account> findCustomerAccountsByCustomer(Customer customer);

    Page findAll(Pageable pageable);
}
