package com.expensesProject.expensesPDF;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.expensesProject.expensesPDF.repository")
public class ExpensesPdfApplication {

	public static void main(String[] args) {

		SpringApplication.run(ExpensesPdfApplication.class, args);
	}

}
