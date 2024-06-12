package assignmenttask2;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        BankAccountApp baa = null;//bank app
        try {
            baa = new BankAccountApp("data/account_data.txt");//reads data file
        } catch (IOException ioe) {//catches data file
            System.out.println("Text file not found");//Prints error message if not found
        }

        baa.searchAccount();//searches the bank account app using searchAccount
        
        System.out.println("Number of accounts: " + baa.countAccounts());//outprints number of accounts
//un-comment to see average balance //System.out.println("Average balance: " + baa.getAverageBalance());//outprints number of average balance
    }
    
}//end of class mains