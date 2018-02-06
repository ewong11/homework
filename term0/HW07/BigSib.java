//Eric Wong
//APCS1 pd 2
//HW07 -- On the Origins of BigSib
//2017-09-26
public class BigSib {
    public String helloMsg;
    public BigSib() {
	helloMsg = "Howdy, ";
    }
    public BigSib(String msg) {
	helloMsg = msg;
	helloMsg += " ";
    }
    public static void main(String[] args) {}
    public  String greet(String msg){
	helloMsg += msg;
	return helloMsg;
	    }
    
}	
