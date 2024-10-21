package com.tony.customer;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository  extends JpaRepository<Customer,Integer> {

    boolean existsByEmail(String email); // Method to check if email exists
}
