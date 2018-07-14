package pe.joedayz.customeraccountservice.api.rest;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;



import pe.joedayz.customeraccountservice.domain.Account;
import pe.joedayz.customeraccountservice.domain.Customer;
import pe.joedayz.customeraccountservice.exception.HTTP400Exception;
import pe.joedayz.customeraccountservice.service.CustomerAccountService;
/*
 * Demonstrates how to set up RESTful API endpoints using Spring MVC
 */

@RestController
@RequestMapping(value = "/customer-account-service/v1/customer-account")
public class CustomerAccountController extends AbstractRestController {

    @Autowired
    private CustomerAccountService customerAccountService;
  
    @RequestMapping(value = "",
            method = RequestMethod.POST,
            consumes = {"application/json", "application/xml"},
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.CREATED)
    public void createCustomerAccount(@RequestBody Account account,
                                 HttpServletRequest request, HttpServletResponse response) throws Exception {
    	Account createdAccount = this.customerAccountService.createAccount(account);
        response.setHeader("Location", request.getRequestURL().append("/").append(createdAccount.getId()).toString());
    }

    @RequestMapping(value = "",
            method = RequestMethod.GET,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    public
    @ResponseBody
    Page<Account> getAllCustomersAccountByPage(@RequestParam(value = "page", required = true, defaultValue = DEFAULT_PAGE_NUM) Integer page,
                                               @RequestParam(value = "size", required = true, defaultValue = DEFAULT_PAGE_SIZE) Integer size,
                                               HttpServletRequest request, HttpServletResponse response) {
        return this.customerAccountService.getAllAccountsByPage(page, size);
    }
    
    @RequestMapping(value = "/all",
            method = RequestMethod.GET,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    public
    @ResponseBody
    List<Account> getAllCustomerAccounts(@RequestParam(value = "page", required = true, defaultValue = DEFAULT_PAGE_NUM) Integer page,
                                      @RequestParam(value = "size", required = true, defaultValue = DEFAULT_PAGE_SIZE) Integer size,
                                      HttpServletRequest request, HttpServletResponse response) {
        return this.customerAccountService.getAllAccounts();
    }
    
    @RequestMapping(value = "/all/{customerId}",
            method = RequestMethod.GET,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    public
    @ResponseBody
    List<Account> getAllCustomerAccountsForSingleCustomer(@RequestParam(value = "page", required = true, defaultValue = DEFAULT_PAGE_NUM) Integer page,
                                      @RequestParam(value = "size", required = true, defaultValue = DEFAULT_PAGE_SIZE) Integer size,
                                      @PathVariable("id") Long id,
                                      HttpServletRequest request, HttpServletResponse response) {
        return this.customerAccountService.getAllAccountsForCustomer(new Customer());
    }

    
    @RequestMapping("/simple/{id}")
	public Account getSimpleCustomerAccount(@PathVariable("id") Long id) {
    	Account account = this.customerAccountService.getAccount(id);
         checkResourceFound(account);
         return account;
	}

    @RequestMapping(value = "/{id}",
            method = RequestMethod.GET,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    public
    @ResponseBody
    Account getAccount(@PathVariable("id") Long id,
                             HttpServletRequest request, HttpServletResponse response) throws Exception {
    	Account account = this.customerAccountService.getAccount(id);
        checkResourceFound(account);
        return account;
    }

    @RequestMapping(value = "/{id}",
            method = RequestMethod.PUT,
            consumes = {"application/json", "application/xml"},
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCustomerAccount(@PathVariable("id") Long id, @RequestBody Account account,
                                 HttpServletRequest request, HttpServletResponse response) throws Exception {
        checkResourceFound(this.customerAccountService.getAccount(id));
        if (id != account.getId()) throw new HTTP400Exception("ID doesn't match!");
        this.customerAccountService.updateAccount(account);
    }

    @RequestMapping(value = "/{id}",
            method = RequestMethod.DELETE,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCustomerAccount(@PathVariable("id") Long id, HttpServletRequest request,
                                 HttpServletResponse response) {
        checkResourceFound(this.customerAccountService.getAccount(id));
        this.customerAccountService.deleteAccount(id);
    }
}
