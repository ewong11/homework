public class Teller
{
    public static void main(String[] args){
    BankAccount bob = new BankAccount();
    System.out.println("--------name change--------");
    bob.setName("Bobby");
    System.out.println(bob);
    System.out.println("------password change----------");
    bob.setPasswd("password");
    System.out.println(bob);
    System.out.println("--------pin change--------");
    bob.setPin(56738);
    System.out.println(bob);
    System.out.println("--------acct num change--------");
    bob.setAcctNum(23567890);
    System.out.println(bob);
    System.out.println("--------balance change--------");
    bob.setBalance(30);
    System.out.println(bob);
    System.out.println("--------deposit money--------");
    bob.deposit(10);
    System.out.println(bob);
    System.out.println("--------withdraw money--------");
    bob.withdraw(70);
    System.out.println(bob);
    System.out.println("--------authenticate--------");
    System.out.println(bob.authenticate(123, "hello"));
    }}
