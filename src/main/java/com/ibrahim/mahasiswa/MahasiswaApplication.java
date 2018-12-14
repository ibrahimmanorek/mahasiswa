package com.ibrahim.mahasiswa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import JavaBasic.SoalA;
import JavaBasic.SoalB;

@SpringBootApplication
public class MahasiswaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MahasiswaApplication.class, args);
		
//		new SoalA().mahasiswa();
		new SoalB().logic1();
	}
	
}
