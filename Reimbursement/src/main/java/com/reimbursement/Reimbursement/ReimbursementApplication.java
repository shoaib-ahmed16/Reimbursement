package com.reimbursement.Reimbursement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
//(exclude={DataSourceAutoConfiguration.class})
public class ReimbursementApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReimbursementApplication.class, args);
	}

}
