package com.mdswaley.project.uber.uberApp.controllers;

import com.mdswaley.project.uber.uberApp.entities.Ride;
import com.mdswaley.project.uber.uberApp.exceptions.ResourceNotFoundException;
import com.mdswaley.project.uber.uberApp.repositories.RideRepository;
import com.mdswaley.project.uber.uberApp.services.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/payment")
public class PaymentController {
    private final PaymentService paymentService;
    private final RideRepository rideRepository;

    @PostMapping("/process/{rideId}")
    public ResponseEntity<String> processPayment(@PathVariable Long rideId){
        Ride ride = rideRepository.findById(rideId)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Ride not found with id: " + rideId));

        paymentService.processPayment(ride);

        return ResponseEntity.ok("Payment processed successfully");
    }


}
