// Hardcoders -- Daniel, Eric, Maxwell
// APCS1 Pd2
// HW11 -- Breaking the Bank
// 2017-10-04

//----------------------------------------------------------------------

// Team Kitkat - Tabassum Fabiha, Kaitlin Wan, Bill Ni
// APCS1 pd2
// HW10 -- More Supreme BankAccount
// 2017-10-03

public class BankAccount
{
    //instance variables
    private String name;
    private String passwd;
    private int pin;
    private int acctNum;
    private double balance;
    
         /* default constructor: initializes instance vars to default vals
       precondition:  none
       postcondition: instance vars have appropriate default vals
       ````````````````````````````````````````````````````*/
    public BankAccount() {
        name = "John Smith";
        passwd = "abc123";
        pin = 1234;
        acctNum = 123456789;
        balance = 0;
    }

    /* overloaded constructor: allows caller to specify account 
                               number and passwd. Assigns defaults
                               to other instance vars.
       precondition:  params are passed in specified order
       postcondition: instance vars have values specified by params
       ````````````````````````````````````````````````````*/
    public BankAccount( int newAcctNum, String newPass ) {
        name = "John Smith";
        passwd = newPass;
        pin = 1234;
        acctNum = newAcctNum;
        balance = 0;
    }

    /* overloaded constructor: allows caller to specify instance vars
       precondition:  params are passed in specified order
       postcondition: instance vars have values specified by params
       ````````````````````````````````````````````````````*/
    public BankAccount( int newAcctNum, String newPass, 
            double newBal, String newName, int newPin ) {
	name = newName;
	passwd = newPass;
	pin = newPin;
	acctNum = newAcctNum;
		balance = newBal;
            }
   

    //mutators
    //method setting the name of the account holder's name
    //returns the previous account holder name
    public String setName( String newName )
    {
    String oldName = name;
    name = newName;
    return oldName;
    }

    //method setting the password for the Bank Account
    //returns the previous password
    public String setPasswd( String newPasswd )
    {
    String oldPasswd = passwd;
    passwd = newPasswd;
    return oldPasswd;
    }

    //sets the 4-Digit pin number of the bank account, which should be in interval [1000,9998]
    //if the pin is outside of that interval, it sets pin to 9999 and returns an "error message" telling why the input is invalid
    //returns the previous 4-Digit pin
    public int setPin( int newPin )
    {
    int oldPin = pin;
    
    //WILL BE THE NEWPIN VALUE AS LONG AS NEWPIN MEETS THE CRITERIA
    int settingPin = newPin;
    
    if ((newPin > 9998) || (newPin < 1000)) {
        //Will set the Pin to 9999 and print error message
        settingPin = 9999;
        System.out.println("That number is INVALID. Must be between 1000 and 9998");
    }
    
    pin = settingPin;
    return oldPin;
    }

    //method setting the account number of the Bank Account, which should be in interval [1000000,999999998]
    //returns the previous Bank Account number
    public int setAcctNum( int newAcctNum ){
    int oldAcctNum = acctNum;
      
    //WILL SET ACCOUNT NUM IF BETWEEN [100000000,999999998]
    int settingNum = newAcctNum;
      
    if ((newAcctNum > 999999998) || (newAcctNum < 100000000)){
        //Will set the Account Number to 999999999 and print error message
        settingNum = 999999999;
        System.out.println("That number is INVALID. Must be between 100000000 and 999999998");
    }
      
    // Will set new Account Num 
    acctNum = settingNum;
    return oldAcctNum;
    }
       
    //method setting the balance of Bank Account
    //returns the previous balance
    public double setBalance( double newBalance )
    {
    double oldBalance = balance;
    balance = newBalance;
    return oldBalance;
    }

    //method allowing you to deposit money into the Bank Account, which alters the current balance
    public void deposit( double depositAmount ) {
    balance = balance + depositAmount;
    }

    //NEW WITHDRAW METHOD
    //method allowing you to withdraw money
    //if withdraw amount is greater than current balance, error message is returned and the withdrawal is prevented
    //returns true if able to withdraw and false otherwise
    public boolean withdraw(double withdrawal){
    if (withdrawal > balance){
        //EROR MESSAGE FOR IF THE USER TRIES TO WITHDRAW MORE THAN THEY HAVE
        String message;
        message = "Transaction failed.";
        message += "\nYou currently only have "+balance+" in your balance.";
        System.out.println(message);
            
        return false;
            
    } else {
        //TAKES OUT MONEY FROM THE BALANCE
        double newBalance;
        newBalance = balance - withdrawal;
        setBalance(newBalance);
          
        return true;
    }
    } 
    
    //method that authenticates user by checking if inputs match variable values for account number and password
    public void auth(int inAcctNum, String inAcctPass){
    if((inAcctNum == acctNum) && (inAcctPass == passwd)){
        //CHECKS IF GIVEN ACCOUNT NUMBER + PASS ARE THE SAME AS THE ONE ON FILE
        System.out.println("Welcome to your bank account, " + name);
    }
    else {
        System.out.println("Incorrect. Please try again");
        
    }}// END OF AUTH
    
    //overwritten toString()
    //prints out all of the attributes of Bank Account at once
    public String toString() {
    String retStr = "\nAccount info:\n=======================";
    retStr = retStr + "\nName: " + name;
    retStr = retStr + "\nPassword: " + passwd;
    retStr = retStr + "\nPIN: " + pin;
    retStr = retStr + "\nAccount Number: " + acctNum;
    retStr = retStr + "\nBalance: " + balance;
    retStr = retStr + "\n=======================";
    return retStr;
    }


    //main method for testing
    public static void main( String[] args )
    {
    BankAccount richard = new BankAccount();
    System.out.println(richard);
    richard.setName("richard");
    richard.setAcctNum(111111111);
    richard.setPasswd("coolbro");
    System.out.println(richard);
    richard.auth(1111111, "hi");
    richard.auth(1111111, "coolbro");
    richard.auth(111111111, "hi");
    richard.auth(111111111, "coolbro");
    System.out.println(richard);
    }//end main()

}//end class BankAccount
