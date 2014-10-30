
import java.util.Scanner;
public class Main {

    Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
	Main m = new Main();
	m.run();
    }

    void run() {
	int[] x = new int[5010];
	int[] y = new int[5010];
	int[] z = new int[5010];
	int n = 0;
	while (true) {
	    x[n] = in.nextInt();
	    y[n] = in.nextInt();
	    z[n] = in.nextInt();
	    if (x[n] == 0 && y[n] == 0 && z[n] == 0)
		break;
	    n++;
	}
	int[] dis = new int[20];

	for (int i = 0; i < 10; i++)
	    dis[i] = 0;
	for (int i = 0; i < n ; i++) {
	    double min = 1000000;
	    for (int j = 0; j < n ; j++) {
		if (i == j)
		    continue;
		double d = Math.sqrt(
				     (x[i]-x[j])*(x[i]-x[j]) +
				     (y[i]-y[j])*(y[i]-y[j]) +
				     (z[i]-z[j])*(z[i]-z[j])
				     );
		//System.out.println(d);
		if (d < min)
		    min = d;
		if (min < 1)
		    break;
	    }
	    if (min < 10) {
		int id = (int) min;
		dis[id]++;
	    }
	}
	for (int i = 0; i < 10; i++)
	    System.out.printf("%4d", dis[i]);
	System.out.println();
	
    }

}
