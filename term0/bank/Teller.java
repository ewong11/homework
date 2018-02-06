// Hardcoders -- Daniel, Eric, Maxwell
// APCS1 Pd2
// HW11 -- Breaking the Bank
// 2017-10-04

public class Teller
{
    public static void main(String[] args){
    BankAccount bob = new BankAccount();
    System.out.println("\n--------name change--------");
    bob.setName("Bobby");
    System.out.println(bob);
    
    System.out.println("\n------password change----------");
    bob.setPasswd("password");
    System.out.println(bob);
    
    System.out.println("\n--------pin change--------");
    bob.setPin(5678);
    System.out.println(bob);
    
    System.out.println("\n--------acct num change--------");
    bob.setAcctNum(234567890);
    System.out.println(bob);
    
    System.out.println("\n--------balance change--------");
    bob.setBalance(30);
    System.out.println(bob);
    
    System.out.println("\n--------deposit money--------");
    bob.deposit(10);
    System.out.println(bob);
    
    System.out.println("\n--------withdraw money--------");
    bob.withdraw(20);
    System.out.println(bob);
    
    System.out.println("\n--------authenticate--------");
    bob.auth(123, "hello");
    
    System.out.println("\n--------default constructor--------");
    BankAccount steve = new BankAccount();
    System.out.println(steve);
    
    System.out.println("\n--------overloaded constructor with password and acctNum--------");
    BankAccount john = new BankAccount(987654321, "321cba");
    System.out.println(john);   
    
    System.out.println("\n--------overloaded constructor with all attributes--------");
    BankAccount george = new BankAccount(199745247, "youllneverguess", 1098276.00, "Curious George", 6070 );
    System.out.println(george); 
    }
    }
