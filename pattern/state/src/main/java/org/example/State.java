package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class State {
    public static void main( String[] args ) {
        SpringApplication.run(State.class, args);
        System.out.println( "Hello World!" );
    }
}
