package assignmenttask2;//package name

import java.io.BufferedReader;//import statements used to implement the code
import java.io.FileReader;//reads file type
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.LinkedList;

class BankAccountApp {
    private List<BankAccount> accountList;

    public BankAccountApp(String filename) throws IOException {
    	
        accountList = new LinkedList<>();
        readAccountData(filename);
    }

    public void readAccountData(String filename) throws IOException {//IOException statement used for throwing statement
    	
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {//epic import statement connector
            String line;
            
            while ((line = br.readLine()) != null) {//styles the data that has been read.
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    double balance = Double.parseDouble(parts[0]);
                    String name = parts[1];
                    String acctID = parts[2];
                    BankAccount bankAccount = new BankAccount(acctID, name, balance);
                    accountList.add(bankAccount);//adds to bank account
                }
            }
        }
    }

    public int countAccounts() {
        int count = 0;
        for (BankAccount account : accountList) {
            double balance = account.getBalance();
            if (balance >= 5000 && balance <= 9500) {
                count++;
            }
        }
        return count;
    }

    public void searchAccount() {
        try (Scanner scanner = new Scanner(System.in)) {
			System.out.print("Enter account id: ");
			String accountId = scanner.nextLine();
			boolean accountFound = false;
			for (BankAccount account : accountList) {
			    if (account.getAcctID().equalsIgnoreCase(accountId)) {
			        System.out.println("Search result: " + account.getAcctID() + "\t" +
			                account.getName() + "\t" + account.getBalance());
			        accountFound = true;
			        break;
			    }
			}
			if (!accountFound) {
			    System.out.println("No account found for id: " + accountId);
			}
		}
    }

    public double getAverageBalance() {
        double sum = 0;
        int count = 0;
        for (BankAccount account : accountList) {
            if (account.getBalance() >= 5000) {
                sum += account.getBalance();
                count++;
            }
        }
        if (count > 0) {
            return sum / count;
        }
        return 0;
    }
}//end of class BankAccountApp
