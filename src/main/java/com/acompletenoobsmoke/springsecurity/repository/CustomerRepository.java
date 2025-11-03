package com.acompletenoobsmoke.springsecurity.repository;

import com.acompletenoobsmoke.springsecurity.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {

    Optional<Customer> findByEmail(String email);
    Optional<Customer> findById(Long id);
    Optional<Customer> findAllByRole(String role);

}