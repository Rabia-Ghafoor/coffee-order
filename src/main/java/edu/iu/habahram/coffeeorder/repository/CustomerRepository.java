package edu.iu.habahram.coffeeorder.repository;

import iu.edu.homework2.Model.Customer;
import org.springframework.data.repository.CrudRepository;


public interface CustomerRepository
        extends CrudRepository<Customer, String> {
    Customer findByUsername(String username);
}


