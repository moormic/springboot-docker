package com.moormic.springbootdocker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

@SpringBootApplication
public class SpringbootDockerApplication {
	private static final Integer LIMIT = 1_000_000;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootDockerApplication.class, args);
		populateFile();
	}

	private static void populateFile() {
		var counter = new AtomicInteger(0);
		try {
			var writer = new BufferedWriter(new FileWriter("/app/data/test.txt"));
			while (counter.get() < LIMIT) {
				writer.write(String.format("%d: %s", counter.getAndIncrement(), UUID.randomUUID()));
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	//TODO: Create a runner that writes to a file, and have that file mounted to the pod via NFS in civo k8s
}
