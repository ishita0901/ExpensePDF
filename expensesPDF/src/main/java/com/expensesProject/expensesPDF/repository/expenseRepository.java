package com.expensesProject.expensesPDF.repository;

import com.expensesProject.expensesPDF.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface expenseRepository {
    Expense save(Expense expense);

    List<Expense> findAll();

    @Repository
    public interface ExpenseRepository extends JpaRepository<Expense, Long> {
    }
}
