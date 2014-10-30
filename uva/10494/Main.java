
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
	    BigInteger l = new BigInteger(in.next());
	    String f = in.next();
	    BigInteger r = new BigInteger(in.next());
	    if (f.equals("%")) {
		l = l.mod(r);
	    } else {
		l = l.divide(r);
	    }
	    System.out.println(l);
	}
    }

}
