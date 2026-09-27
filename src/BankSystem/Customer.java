package BankSystem;

import java.util.ArrayList;

public class Customer {

    private String firstName;
    private String lastName;

    //Array Ver.
    private Account[] accounts = new Account[5];

    // Arraylist Ver.
    // private ArrayList <Account> accounts = new ArrayList<Account>(); 

    private int numberOfAccounts = 0;

    public Customer(String f, String l) {
        firstName = f;
        lastName = l;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setAccount(Account acct) {
        //Array Ver.
        if (numberOfAccounts < 5) accounts[numberOfAccounts++] = acct;

        // Arraylist Ver.
        // if (numberOfAccounts < 5) accounts.add(acct);
    }

    public Account getAccount(int account_index) {
        // Array ver.
        return accounts[account_index];

        // Arraylist Ver.
        // return accounts.get(account_index);
    }

    public int getNumOfAccounts() {
        return numberOfAccounts;
    }
}