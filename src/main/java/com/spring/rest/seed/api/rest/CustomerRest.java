package com.spring.rest.seed.api.rest;

import com.google.gson.Gson;
import com.spring.rest.seed.api.rest.entity.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by emrahsoytekin on 22.10.2017.
 */
@Component
@RequestMapping("/customer")
public class CustomerRest {


    private static final Logger logger = LoggerFactory.getLogger (CustomerRest.class);

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<Customer> getCustomers(){
        Authentication authentication = SecurityContextHolder.getContext ().getAuthentication ();
        logger.debug ("incoming getCustomer request from user: {}", authentication.getName ());
        List<Customer> customers = new ArrayList <Customer> ();
        Customer a = new Customer ();
        a.setName ("aCustomerName");
        a.setSurname ("aCustomerSurname");

        customers.add (a);


        Customer b = new Customer ();
        b.setName ("bCustomerName");
        b.setSurname ("bCustomerSurname");

        customers.add (b);
        return customers;

    }

    /**
     * Content-Type : application/x-www-form-urlencoded
     * @param customer
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public Customer saveCustomer(@ModelAttribute Customer customer) {
        String username = SecurityContextHolder.getContext ().getAuthentication ().getName ();
        logger.debug ("incoming post request for : {}", customer);
        logger.debug ("authenticated user is : {}", username);
        //TODO: save operations


        return customer;
    }

    /**
     * Content-Type: application/json
     * @param json
     * @return
     */
    @RequestMapping(method = RequestMethod.PUT)
    @ResponseBody
    public Customer updateCustomer(@RequestBody String json) {
        Gson gson = new Gson();
        Customer customer = gson.fromJson (json, Customer.class);
        logger.debug ("incoming put request for {}", customer);

        //TODO: update operations


        return customer;

    }


    @RequestMapping(value = "/{customerId}", method = RequestMethod.DELETE)
    @ResponseStatus (value = HttpStatus.OK)
    public void deleteCustomer(@PathVariable("customerId") long customerId) {

        logger.debug ("incoming delete request for id :" + customerId);

        //TODO: use customerId param to delete customer

    }
}
