package com.karthik.Service;

import com.karthik.Entity.PassengerInfo;
import com.karthik.Entity.PaymentInfo;
import com.karthik.Entity.Repository.PassengerInfoRepository;
import com.karthik.Entity.Repository.PaymentInfoRepository;
import com.karthik.PaymentUtils.PaymentUtils;
import com.karthik.dto.FlightBookingAcknowledgment;
import com.karthik.dto.FlightBookingRequest;
import com.karthik.dto.PassengerAndPaymentDetails;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PassengerPaymentService {
    @Autowired
    private PassengerInfoRepository passengerInfoRepo;

    @Autowired
    private PaymentInfoRepository paymentInfoRepo;


    @Transactional
    public FlightBookingAcknowledgment bookFlightTicket(FlightBookingRequest request) {

        PassengerInfo passengerInfo = request.getPassengerInfo();
        passengerInfoRepo.save(passengerInfo);

        PaymentInfo paymentInfo = request.getPaymentInfo();
        PaymentUtils.validateCreditLimit(paymentInfo.getAccountNo(), passengerInfo.getFare());


       paymentInfo.setPassengerId(passengerInfo.getPid());
       paymentInfo.setAmount(passengerInfo.getFare());
       paymentInfoRepo.save(paymentInfo);

        paymentInfoRepo.save(paymentInfo);
        return new FlightBookingAcknowledgment("SUCCESS", passengerInfo.getFare(),
                UUID.randomUUID().toString().split("-")[0], passengerInfo);
    }
    public PassengerInfo getPassengerDetailsByPid(Long pid) {
        return passengerInfoRepo.findById(pid).orElse(null);
    }
    public PassengerAndPaymentDetails getPassengerAndPaymentDetailsByPid(Long pid) {
        PassengerInfo passengerInfo = passengerInfoRepo.findById(pid).orElse(null);
        PaymentInfo paymentInfo = (PaymentInfo) paymentInfoRepo.findByPassengerId(pid).orElse(null);

        return new PassengerAndPaymentDetails(passengerInfo, paymentInfo);
    }

}

