package com.moormic.springbootdocker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

@SpringBootApplication
public class SpringbootDockerApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringbootDockerApplication.class, args);
	}
}
