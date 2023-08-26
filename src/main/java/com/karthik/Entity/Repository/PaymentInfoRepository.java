package com.karthik.Entity.Repository;

import com.karthik.Entity.PaymentInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PaymentInfoRepository extends JpaRepository<PaymentInfo,String> {

    Optional<Object> findByPassengerId(Long pid);
}
