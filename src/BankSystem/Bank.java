package BankSystem;

import java.util.ArrayList;

public class Bank {

    // Array ver.
    private Customer[] customers;

    // Arraylist ver.
    // private ArrayList <Customer> customers;

    private static int numberOfCustomers;

    public Bank(){
        // Array ver.
        customers = new Customer[100];

        // Arraylist ver.
        // customers = new ArrayList<Customer>();

        numberOfCustomers = 0;
    }

    public void addCustomer(String f, String l){
        Customer newCustomer = new Customer(f, l);
        
        // Array ver.
        customers[numberOfCustomers] = newCustomer;

        // Arraylist ver.
        // customers.add(newCustomer);

        numberOfCustomers++;
    }

    public int getNumOfCustomers (){
        return numberOfCustomers;
    }

    public Customer getCustomer(int id){
        // Array ver.
        return customers[id];

        // Arraylist ver.
        // return customers.get(id);
    }

}
