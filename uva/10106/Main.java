
import java.util.Scanner;
import java.math.BigInteger;
public class Main {
    Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
	Main m = new Main();
	m.run();
    }

    void run() {
	while (in.hasNext()) {
	    BigInteger l = new BigInteger(in.nextLine());
	    BigInteger r = new BigInteger(in.nextLine());
	    System.out.println(l.multiply(r));
	}
    }

}
