public class BigSib {
    private String helloMsg;
    public static void main(String[] args) {}
    public void setHelloMsg(String newMsg) {
	helloMsg = newMsg;
	helloMsg += " ";
    }
    public  String greet(String msg){
	helloMsg += msg;
	return helloMsg;
	    }
    
}	
