package com.expensesProject.expensesPDF.controller;

import com.expensesProject.expensesPDF.model.Expense;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.expensesProject.expensesPDF.service.expenseService;

import java.util.List;
    @RestController
    @RequestMapping("/expenses")
    public class expenseController {
        @Autowired
        private expenseService expenseService;

        @PostMapping("/expense")
        public ResponseEntity<Expense> createExpense(@RequestBody Expense expense) {
            Expense createdExpense = com.expensesProject.expensesPDF.service.expenseService.createExpense(expense);
            return new ResponseEntity<>(createdExpense, HttpStatus.CREATED);
        }

        @GetMapping("/allexpenses")
        public List<Expense> getAllExpenses() {
            return expenseService.getAllExpenses();
        }
    }
