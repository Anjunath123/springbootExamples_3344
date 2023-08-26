package com.karthik.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "passenger_Info")
public class PassengerInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Or another appropriate strategy
    @Column(name = "id")
    private Long pid;

    private String name;
    private String source;
    private String destination;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy") // Use "MM" for month
    private Date travelDate;

    private String pickupTime;
    private String arrivalTime;
    private Double fare;
}
