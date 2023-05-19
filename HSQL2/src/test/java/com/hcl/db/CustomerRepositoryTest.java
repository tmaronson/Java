package com.hcl.db;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hcl.domain.Customer;

@SpringBootTest
public class CustomerRepositoryTest {
    
    @Autowired
    private CustomerRepository customerRepository;
    
    @Test
    public void testWhenFindingCustomerById() {
        customerRepository.save(new Customer("John", "john@domain.com"));
        assertNotNull(customerRepository.findById(1L)); //.isInstanceOf(Optional.class);
    }
    
    @Test
    public void testWhenFindingAllCustomers() {
        customerRepository.save(new Customer("John", "john@domain.com"));
        customerRepository.save(new Customer("Julie", "julie@domain.com"));
        assertEquals(2L, customerRepository.count());
    }
    
    @Test
    // Technically tests are not supposed to be dependent on each other
    // but since the data is persisted, there will be 2 records in db from above.
    public void testWhenSavingCustomer() {
        customerRepository.save(new Customer("Bob", "bob@domain.com"));
        Customer customer = customerRepository.findById(3L).orElseGet(() 
          -> new Customer("john", "john@domain.com"));
        assertEquals("Bob", customer.getName());
    }
}
