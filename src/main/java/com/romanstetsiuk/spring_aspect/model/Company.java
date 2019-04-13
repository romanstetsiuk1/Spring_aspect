package com.romanstetsiuk.spring_aspect.model;

import java.math.BigDecimal;

public class Company {

    private String name;
    private int amountWorkers;
    private BigDecimal revenueByYear;
    private String location;

    public Company() {
    }

    public Company(String name, int amountWorkers, BigDecimal revenueByYear, String location) {
        this.name = name;
        this.amountWorkers = amountWorkers;
        this.revenueByYear = revenueByYear;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmountWorkers() {
        return amountWorkers;
    }

    public void setAmountWorkers(int amountWorkers) {
        this.amountWorkers = amountWorkers;
    }

    public BigDecimal getRevenueByYear() {
        return revenueByYear;
    }

    public void setRevenueByYear(BigDecimal revenueByYear) {
        this.revenueByYear = revenueByYear;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
