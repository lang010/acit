
import java.util.Scanner;
import java.math.BigInteger;
public class Main {
    Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
	Main m = new Main();
	m.run();
    }

    void run() {
	BigInteger sum = new BigInteger("0");
	while (true) {
	    String s = in.nextLine();
	    if (s.equals("0"))
		break;
	    sum = sum.add(new BigInteger(s));
	}
	System.out.println(sum);
    }

}
