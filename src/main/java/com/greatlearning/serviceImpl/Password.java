package com.greatlearning.serviceImpl;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class Password {

	public static void main(String[] args) {
		PasswordEncoder pe = new BCryptPasswordEncoder();
		System.out.println(pe.encode("priya05"));
		System.out.println(pe.encode("nila05"));

	}

}
