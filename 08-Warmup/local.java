public class local{
  public static int bunnyEars(int bunnies) {
    if (bunnies <= 0) //base case
      return 0;
    else
      return 2 + bunnyEars(bunnies-1);
  }
  public static int fibonacci(int n) {
    if (n == 0) {
      return 0;
    }
    else if(n == 1)
      return 1;
    else
      return fibonacci(n-1) + fibonacci(n-2);
  }
  public static int bunnyEars2(int bunnies){
    if (bunnies <= 0)
      return 0;
    else if(bunnies%2 == 0)
      return 3 + bunnyEars2(bunnies - 1);
    else
      return 2 + bunnyEars2(bunnies -1);
  }
  public static int triangle(int rows) {
    if (rows == 0)
      return 0;
    else
      return rows + triangle(rows - 1);
  }
  public static int sumDigits(int n){
    if (n == 0)
      return 0;
    else
      return (n%10) + sumDigits(n/10);
  }
  public static int count7(int n){
    if (n == 0)
      return 0;
    else if(n%10 == 7)
      return 1 + count7(n/10);
    else
      return count7(n/10);
  }
  public static int count8(int n){
    if (n == 0)
      return 0;
    else if(n%100 == 88)
      return 2 + count8(n/10);
    else if(n%10 == 8)
      return 1 + count8(n/10);
    else
      return count8(n/10);
  }
  public static int powerN(int base, int a){
    if(a == 0)
      return 1;
    if (a == 1)
      return base;
    else return base * powerN(base, a-1);
  }

  public static int countX(String str) {
    if (str.length() == 0)
      return 0;
    else if (str.substring(0,1).equals("x"))
      return 1 + countX(str.substring(1));
    else
      return countX(str.substring(1));
  }

  public static int countHi(String str) {
    if (str.length() == 0)
      return 0;
    else if(str.substring(0,1).equals("h") && str.length() >= 2) {
      if(str.substring(1,2).equals("i"))
        return countHi(str.substring(1)) + 1;
      else {
          return countHi(str.substring(1));
        }
      }
    else {
      return countHi(str.substring(1));
    }
  }

  public static String changeXY(String str) {
    if (str.length() <= 0)
      return "";
    else if (str.substring(0,1).equals("x"))
      return "y" + changeXY(str.substring(1));
    else
      return str.substring(0,1) + changeXY(str.substring(1));
  }

  public static String changePi(String str) {
    if (str.length() == 1 )
      return str.substring(0,1);
    if (str.length() == 0 )
      return "";
    else if (str.substring(0,2).equals("pi"))
      return "3.14" + changePi(str.substring(2));
    else
      return str.substring(0,1) + changePi(str.substring(1));
  }
  public static String noX(String str) {
    if (str.length() == 0)
      return "";
    else if(str.substring(0,1).equals("x"))
      return noX(str.substring(1));
    else
      return str.substring(0,1) + noX(str.substring(1));
  }
  public static boolean array6(int[] nums, int index) {
    if (index == nums.length)
      return false;
    else if(nums[index] == 6)
      return true;
    else
      return array6(nums, index+1);

  }
  public static void main(String[] args) {
    /*---------------------------------
    System.out.println(bunnyEars(2));
    System.out.println(fibonacci(8));
    System.out.println(bunnyEars2(2));
    System.out.println(triangle(2));
    System.out.println(sumDigits(49));
    System.out.println(count8(8));
    System.out.println(count8(818));
    System.out.println(count8(88888));
    System.out.println(powerN(3,1));
    System.out.println(countX("afcf"));
    System.out.println(countHi("xhixhxihihhhih"));
    System.out.println(changeXY("xxx"));
    System.out.println(changePi("pipiip"));
    System.out.println(noX("abc"));
    ----------------------------------*/
    System.out.println(array6([1,2,3],0));
  }
}
