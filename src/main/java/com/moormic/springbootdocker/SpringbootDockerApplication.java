package com.moormic.springbootdocker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootDockerApplication {


	public static void main(String[] args) {
		SpringApplication.run(SpringbootDockerApplication.class, args);
		populateFile();
	}

	private static void populateFile() {

	}

	//TODO: Create a runner that writes to a file, and have that file mounted to the pod via NFS in civo k8s
}
