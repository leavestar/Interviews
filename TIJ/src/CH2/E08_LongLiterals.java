package CH2;

/****************** Exercise 8 *****************
 * Show that hex and octal notations work with long
 * values. Use Long.toBinaryString() to display
 * the results.
 ***********************************************/
public class E08_LongLiterals {
    public static void main(String[] args) {
      long l1 = 0x2f; // Hexadecimal (lowercase)
      System.out.println("l1: " + Long.toBinaryString(l1));
      long l2 = 0X2F; // Hexadecimal (uppercase)
      System.out.println("l2: " + Long.toBinaryString(l2));
      long l3 = 0177; // Octal (leading zero)
      System.out.println("l3: " + Long.toBinaryString(l3));
    }
  }
