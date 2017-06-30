package edu.tests.TestForSure;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.tests.TestForSure.service.TestServices;

/**
 * Hello world!
 *
 */

@EnableAutoConfiguration
public class App {


    public static void main(String[] args) throws Exception {
        SpringApplication.run(TestServices.class, args);
    }

}