package com.ibrahim.mahasiswa;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import JavaBasic.SoalA;
import JavaBasic.SoalB;

@SpringBootApplication
public class MahasiswaApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(MahasiswaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		new SoalA().mahasiswa();
		new SoalB().logic1();
	}
	
}
