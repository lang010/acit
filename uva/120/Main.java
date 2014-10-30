
import java.util.Scanner;
public class Main {
    Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
	Main m = new Main();
	m.run();
    }

    int N;
    int[] ls = new int[100];

    void run() {
	String s = null;
	while (in.hasNext()) {
	    s = in.nextLine();
	    String[] sl = s.split(" ");
	    N = sl.length;
	    for (int i = 0; i < N ; i++) {
		ls[i] = Integer.valueOf(sl[i]);
	    }
	    System.out.println(s);
	    for (int i = N - 1; i >= 0; i--) {
		int id = i;

		for (int j = id-1; j >= 0; j--) {
		    //System.out.println(": " + i + ", " + id + ", " + j);
		    
		    if (ls[id] < ls[j]) {
			id = j;
		    }
		}
		if (id < i) {
		    if (id>0) {
			flip(id);
		    }
		    flip(i);
		}
	    }
	    System.out.println("0");
	}
    }

    void flip(int id) {
	System.out.print(N-id + " ");
	int t;
	int b = 0;
	while (b < id) {
	    t = ls[id];
	    ls[id] = ls[b];
	    ls[b] = t;
	    b++;
	    id--;
	}
    }

}
