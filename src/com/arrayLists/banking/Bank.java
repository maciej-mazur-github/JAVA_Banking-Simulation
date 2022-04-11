package com.arrayLists.banking;

import java.util.ArrayList;
import java.util.Scanner;

public class Bank {
    private String name;
    private ArrayList<Branch> branches;
    private Scanner scanner = new Scanner(System.in);

    public Bank(String name) {
        this.name = name;
        this.branches = new ArrayList<>();
    }

    public void addCustomer(String branchName, String customerName, double initialTransaction) {
        Branch branchToAddCustomerTo = findBranch(branchName);

        if(branchToAddCustomerTo == null) {
            System.out.println("No " + branchName + " existing. You need to add this branch first.");
            return;
        }

        if(branchToAddCustomerTo.addCustomer(customerName, initialTransaction)) {
            System.out.println("The new customer " + customerName + " has been successfully added to the branch " + branchName + " with the initial amount of money " +
                    " at " + initialTransaction);
        } else {
            System.out.println("The customer " + customerName + " has already existed in this branch. You can't add existing customer name again");
        }
    }

    public void removeCustomer(String branchName, String customerName) {
        Branch branchToRemoveCustomerFrom = findBranch(branchName);

        if(branchToRemoveCustomerFrom == null) {
            System.out.println("No " + branchName + " existing. You can't remove non-existent branches");
            return;
        }

        if(branchToRemoveCustomerFrom.removeCustomer(customerName)) {
            System.out.println("The customer " + customerName + " has been successfully removed from the branch");
        } else {
            System.out.println("The customer " + customerName + " does not exist in this branch. You can't remove non-existent customers");
        }
    }

    private Branch findBranch(String branchName) {
        for(int i = 0; i < branches.size(); i++) {
            if(branches.get(i).getName().equals(branchName)) {
                return branches.get(i);
            }
        }

        return null;
    }
}
