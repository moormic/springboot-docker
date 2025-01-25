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
	private static final String FILENAME = "/app/data/test.txt";
//	private static final String FILENAME = "C:\\Users\\mmoor\\Developer\\k8s-tutorial\\test.txt";
	private static final Integer LIMIT = 1_000_000;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootDockerApplication.class, args);
		populateFile();
	}

	private static void populateFile() {
		System.out.println("Writing to " + FILENAME);
		var counter = new AtomicInteger(0);
		try {
			var writer = new BufferedWriter(new FileWriter(FILENAME, true));
			while (counter.get() < LIMIT) {
				var message = String.format("%d: %s\n", counter.incrementAndGet(), UUID.randomUUID());
//				System.out.printf(message);
				writer.write(message);
				writer.flush();
			}
			writer.close();
			System.out.printf("Wrote %d messages to %s", LIMIT, FILENAME);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
