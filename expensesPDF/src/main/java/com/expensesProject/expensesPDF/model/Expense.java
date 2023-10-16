package com.expensesProject.expensesPDF.model;

import jakarta.persistence.*;

@Entity
@Table(name = "expense")
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "travel")
    private double travel;
    @Column(name = "food")
    private double food;
    @Column(name = "claim total")
    private double total;

    public Expense(){

    }

    public Expense(double travel, double food, double total) {
        super();
        this.travel = travel;
        this.food = food;
        this.total = total;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getTravel() {
        return travel;
    }

    public void setTravel(double travel) {
        this.travel = travel;
    }

    public double getFood() {
        return food;
    }

    public void setFood(double food) {
        this.food = food;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
