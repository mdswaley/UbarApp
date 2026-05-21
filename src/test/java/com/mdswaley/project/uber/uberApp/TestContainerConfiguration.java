package com.mdswaley.project.uber.uberApp;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.testcontainers.containers.MySQLContainer;

@TestConfiguration
public class TestContainerConfiguration {

    @ServiceConnection
    MySQLContainer<?> mySQLContainer() {
        return new MySQLContainer<>("mysql:latest"); // take mySql container from docker image
//        so that we can use dummy database which is similar to original database
    }
}
