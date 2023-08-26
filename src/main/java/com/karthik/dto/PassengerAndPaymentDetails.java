package com.karthik.dto;

import com.karthik.Entity.PassengerInfo;
import com.karthik.Entity.PaymentInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PassengerAndPaymentDetails {
    private PassengerInfo passengerInfo;
    private PaymentInfo paymentInfo;
}
