package com.example.QLBH_ABC.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.QLBH_ABC.models.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>  {
 
}