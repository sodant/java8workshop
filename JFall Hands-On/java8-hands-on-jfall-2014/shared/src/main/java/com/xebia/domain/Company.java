package com.xebia.domain;

import java.util.ArrayList;
import java.util.List;

public class Company {

    public final String name;
    public final List<Person> employees = new ArrayList<>();

    public Company(String name, List<Person> employees) {
        this.name = name;
        this.employees.addAll(employees);
    }

    public String toString() {
        return String.format("Company[name=%s, employees=%s]", name, employees);
    }

}
