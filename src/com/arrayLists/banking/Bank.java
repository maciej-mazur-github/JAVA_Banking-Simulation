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

    public void listAllCustomers(boolean withTransactions) {
        if(branches.size() == 0) {
            System.out.println("There are no branches nor customers added yet");
            return;
        }

        Branch currentlyPrintedBranch;
        Customer currentlyPrintedCustomer;
        System.out.println("Bank name: " + name);

        for(int i = 0; i < branches.size(); i++) {
            currentlyPrintedBranch = branches.get(i);
            System.out.println("\tBranch " + currentlyPrintedBranch.getName() + ":");

            for(int j = 0; j < currentlyPrintedBranch.getCustomers().size(); j++) {
                currentlyPrintedCustomer = currentlyPrintedBranch.getCustomers().get(j);
                System.out.println("\t\t" + currentlyPrintedCustomer.getName());

                if(withTransactions) {
                    ArrayList<Double> currentlyPrintedTransactions = currentlyPrintedCustomer.getTransactions();
                    System.out.print("\t\t\t");

                    for(int k = 0; k < currentlyPrintedTransactions.size(); k++) {
                        System.out.print(currentlyPrintedTransactions.get(k) + "  ");
                    }
                }
            }


        }
    }

    public void listSpecificBranchCustomers(String branchName, boolean withTransactions) {
        System.out.println("Branch " + branchName);
        Branch branchToPrint = findBranch(branchName);

        if(branchToPrint == null) {
            System.out.println("There is no branch " + branchName + " in this bank");
            return;
        }

        Customer currentlyPrintedCustomer;  // created this variable for optimization purposes (fewer method calls this way)

        for(int i = 0; i < branchToPrint.getCustomers().size(); i++) {
            currentlyPrintedCustomer = branchToPrint.getCustomers().get(i);
            System.out.println("\t" + currentlyPrintedCustomer.getName());

            if(withTransactions) {
                System.out.println("\t\t");

                for(int j = 0; j < currentlyPrintedCustomer.getTransactions().size(); j++) {
                    System.out.print(currentlyPrintedCustomer.getTransactions().get(j) + "  ");
                }
            }
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
