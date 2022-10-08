package com.joel.mspurchase.repositories;

import com.joel.mspurchase.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestRepository extends JpaRepository<Order, Long> {
}
