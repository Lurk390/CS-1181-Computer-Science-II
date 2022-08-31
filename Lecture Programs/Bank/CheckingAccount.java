package Bank;

class CheckingAccount extends BankAccount {
    private double overdraftFee;

    CheckingAccount(String firstName, String lastName, String 
                    accountNumber, double balance, double 
                    interestRate, double overdraftFee) {
        super(firstName, lastName, accountNumber, balance,
              interestRate);
        this.overdraftFee = overdraftFee;
    }
}
