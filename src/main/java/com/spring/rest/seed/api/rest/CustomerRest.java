package com.spring.rest.seed.api.rest;

import com.spring.rest.seed.api.rest.entity.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
}
