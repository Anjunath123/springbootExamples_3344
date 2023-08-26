package com.karthik.Controller;


import com.karthik.Entity.PassengerInfo;
import com.karthik.Service.PassengerPaymentService;
import com.karthik.dto.FlightBookingAcknowledgment;
import com.karthik.dto.FlightBookingRequest;
import com.karthik.dto.PassengerAndPaymentDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.*;

@RestController

@EnableTransactionManagement
public class PassengerpaymentController {
    @Autowired
    private PassengerPaymentService service;

    @PostMapping("/save")
    public FlightBookingAcknowledgment bookTicket( @RequestBody FlightBookingRequest request)
    {
        return service.bookFlightTicket(request);
    }
    @GetMapping("/getPassenger/{pid}")
    public PassengerInfo getPassengerDetails(@PathVariable Long pid) {
        return service.getPassengerDetailsByPid(pid);
    }
    @GetMapping("/getPassengerAndPayment/{pid}")
    public PassengerAndPaymentDetails getPassengerAndPaymentDetails(@PathVariable Long pid) {
        return service.getPassengerAndPaymentDetailsByPid(pid);
    }



}
