package net.javaguides.springboot.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.javaguides.springboot.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment,Long> {
    
}
