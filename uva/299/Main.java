
import java.util.Scanner;
public class Main {
    Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
	Main m = new Main();
	m.run();
    }

    int[] ls = new int[100];
    int len = 0;
    void run() {
	int cnt = in.nextInt();
	for (int i = 0 ; i < cnt ; i++) {
	    len = in.nextInt();
	    for (int j = 0; j < len ; j++) {
		ls[j] = in.nextInt();
	    }
	    int n = 0;
	    for (int j = 0; j < len; j++) {
		for (int k = len - 1; k > j; k--) {
		    if (ls[k] < ls[k-1]) {
			int t = ls[k];
			ls[k] = ls[k-1];
			ls[k-1] = t;
			n++;
		    }
		}
	    }
	    System.out.println("Optimal train swapping takes " + n + " swaps.");
	    
	}
    }

}
