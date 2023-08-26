package com.karthik.dto;

import com.karthik.Entity.PassengerInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlightBookingAcknowledgment {

    private String status;
    private Double totalFare;
    private String pnrNo;
    private PassengerInfo passengerInfo;
}
