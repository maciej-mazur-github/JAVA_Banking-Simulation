import com.arrayLists.banking.Bank;

public class Main {
    public static void main(String[] args) {
        Bank goldman = new Bank("Goldman");

        goldman.addBranch("Stock Exchange");
        goldman.listAllCustomers(true);
        goldman.addCustomer("Stock Exchange", "Britney", 100.0);
        goldman.addCustomer("Stock Exchange", "Tommy", 120.0);
        goldman.addCustomer("Stock Exchange", "Loki", 300.0);
        goldman.addCustomer("Stock Exchange", "Thor", 200);

        goldman.listAllCustomers(true);
        goldman.addCustomerTransaction("Stock Exchange", "Britney", 100.0);
        goldman.addCustomerTransaction("Stock Exchange", "Britney", 500);
        goldman.addCustomerTransaction("Stock Exchange", "Britney", 1500);
        goldman.addCustomerTransaction("Stock Exchange", "Tommy", 250);
        goldman.addCustomerTransaction("Stock Exchange", "Thor", 50);

        goldman.listAllCustomers(true);
        goldman.addBranch("Another branch");
        goldman.addCustomer("Another branch", "Mike", 67);
        goldman.addCustomer("Another branch", "Taylor", 20);
        goldman.addCustomer("Another branch", "Kevin", 5);
        goldman.addCustomer("Another branch", "Jack", 0);
        goldman.addCustomer("Another branch", "Martin", 90);
        goldman.addCustomer("Another branch", "Christine", 120);
        goldman.listAllCustomers(true);
        goldman.removeCustomer("Another branch", "Terry");
        goldman.removeCustomer("Another branch", "Martin");
        goldman.listAllCustomers(true);
        goldman.listSpecificBranchCustomers("Stock Exchange", false);
        goldman.removeBranch("SomeBranch");
        goldman.removeBranch("Another branch");
        goldman.listAllCustomers(true);


    }
}
