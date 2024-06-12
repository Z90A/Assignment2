package assignmenttask2;

class BankAccount extends Account {//BankAccount is a subclass of Account
    private String name;//private fields
    private double balance;

    public BankAccount(String acctID, String name, double balance) {
        super(acctID);//super class
        this.name = name;
        this.balance = balance;
    }

    public String getName() {//getters and setters
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}//end of class BankAccount

