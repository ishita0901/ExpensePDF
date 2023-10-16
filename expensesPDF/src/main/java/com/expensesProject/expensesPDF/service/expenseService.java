package com.expensesProject.expensesPDF.service;

import com.expensesProject.expensesPDF.model.Expense;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.expensesProject.expensesPDF.repository.expenseRepository;
@Service
public class expenseService {
        @Autowired
        private static expenseRepository expenseRepository;

        public static Expense createExpense(Expense expense) {
            // Add business logic, validation, and calculation for 'total' here if needed
            return expenseRepository.save(expense);
        }

        public List<Expense> getAllExpenses() {
            return expenseRepository.findAll();
        }
    }

