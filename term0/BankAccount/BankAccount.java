// Hard Coders Maxwell Vale, Daniel Gelfand, Eric Wong
// APCS1 pd2
// HW10 -- Mo Money Mo Problem
// 2017-10-03 T
public class BankAccount
{
    //instance variables
    private String name;
    private String passwd;
    private int pin;
    private int acctNum;
    private double balance;


    //mutators
    public String setName( String newName )
    {
    String oldName = name;
    name = newName;
    return oldName;
    }

    public String setPasswd( String newPasswd )
    {
    String oldPasswd = passwd;
    passwd = newPasswd;
    return oldPasswd;
    }

    //sets pin, limited to 4 digits
    public int setPin( int newPin )
    {
    if (newPin > 1000 && newPin < 9998) {
        int oldPin = pin;
        pin = newPin;
        return oldPin;
        }
    else {
	int oldPin = pin;
        pin = 9999;
        System.out.println("Invalid pin number. Make sure the new Pin contains 4-digits and does not start with a 0.");
	return oldPin;
        }
    }

    //sets account number and limits it to 9 digits
    public int setAcctNum( int newAcctNum )
    {
    if (newAcctNum >= 100000000 && newAcctNum <= 999999998) 
    {
    int oldAcctNum = acctNum;
    acctNum = newAcctNum; 
    return oldAcctNum;
    }
       
    else {
	int oldAcctNum = acctNum;
        acctNum = 999999999;
        System.out.println("Invalid number. Make sure the account number contains 9-digits");
	return oldAcctNum;
    }

    }


    public double setBalance( double newBalance )
    {
    double oldBalance = balance;
    balance = newBalance;
    return oldBalance;
    }
    
    //adds money into account
    public void deposit( double depositAmount ) {
    balance = balance + depositAmount;
    }

    //takes out money, only if the amount to be taken out is less than balance
    public boolean withdraw(double withdrawAmount){
    if(balance < withdrawAmount)
        {
        System.out.println("Transaction will not go through. Insufficient balance");
	return (balance < withdrawAmount);
        }
        else
        {
        balance -= withdrawAmount;
        return (balance > withdrawAmount);
        }
    }
   public boolean authenticate(int accountNum, String pass) {
           return(accountNum == acctNum && pass == passwd);
}



    //overwritten toString()
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
        BankAccount Kevin = new BankAccount();
        Kevin.setName("Bob");
        Kevin.setPasswd("password");
        Kevin.setPin(99299);
	Kevin.setAcctNum(45672345);
        System.out.println(Kevin);
    }//end main()

    }//end class BankAccount
