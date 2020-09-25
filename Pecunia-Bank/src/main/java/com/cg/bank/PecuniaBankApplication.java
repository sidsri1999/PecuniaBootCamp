package com.cg.bank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.cg.bank.interceptor.SecurityInterceptor;

@SpringBootApplication
public class PecuniaBankApplication extends WebMvcConfigurerAdapter {
	
	@Autowired
	SecurityInterceptor interceptor;
		
		
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// TODO Auto-generated method stub
		System.out.println("Inside Add Interceptor");
		registry.addInterceptor(interceptor);
	}

	public static void main(String[] args) {
		System.out.println("Inside Main");
		SpringApplication.run(PecuniaBankApplication.class, args);
	}

}