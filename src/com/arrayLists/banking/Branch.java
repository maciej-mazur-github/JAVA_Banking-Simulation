package com.arrayLists.banking;

import java.util.ArrayList;

class Branch {
    private String name;
    private ArrayList<Customer> customers;

    public Branch(String name) {
        this.name = name;
        this.customers = new ArrayList<>();
    }

    private void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public boolean addCustomer(String name, double initialAmount) {
         if(findCustomer(name) == null) {
            addCustomer(new Customer(name, initialAmount));
            return true;
        } else {
             return false;
         }
    }

    private void removeCustomer(Customer customer) {
        customers.remove(customer);
    }

    public boolean removeCustomer(String name) {
        Customer customerToRemove = findCustomer(name);

        if(customerToRemove != null) {
            removeCustomer(customerToRemove);
            return true;
        } else {
            return false;
        }
    }

    private Customer findCustomer(String name) {
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getName().equals(name)) {
                return customers.get(i);
            }
        }

        return null;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }
}
