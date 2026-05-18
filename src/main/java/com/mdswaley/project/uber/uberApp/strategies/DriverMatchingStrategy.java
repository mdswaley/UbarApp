package com.mdswaley.project.uber.uberApp.strategies;

import com.mdswaley.project.uber.uberApp.entities.Driver;
import com.mdswaley.project.uber.uberApp.entities.RideRequest;

import java.util.List;

public interface DriverMatchingStrategy {

    List<Driver> findMatchingDriver(RideRequest rideRequest);
}
