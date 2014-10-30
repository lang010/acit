
import java.util.Scanner;
import java.util.Arrays;
public class Main {
    Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
	Main m = new Main();
	m.run();
    }

    void run() {
	int cnt = 0;
	while (true) {
	    int n = in.nextInt();
	    int q = in.nextInt();
	    if (n == 0 && q == 0)
		break;
	    cnt++;
	    System.out.println("CASE# " + cnt + ":");
	    int[] ls = new int[n];
	    for (int i = 0; i < n ; i++) {
		ls[i] = in.nextInt();
	    }
	    Arrays.sort(ls);
	    for (int i = 0; i < q; i++) {
		int x = in.nextInt();
		int id = Arrays.binarySearch(ls, x);
		if (id > -1) {
		    while (id > 0 && ls[id] == ls[id-1]) {
			if (ls[id/2] == ls[id])
			    id = id/2;
			else
			    id--;
		    }
		    System.out.println(x + " found at " + (id+1));
		    
		} else {
		    System.out.println(x + " not found");
		}
	    }
	    
	}
    }

}
