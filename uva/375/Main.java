
import java.util.Scanner;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.File;

public class Main {
    Scanner in = new Scanner(System.in, "ISO-8859-1");
    PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out, "ISO-8859-1"));
    public Main() throws Exception {
    }

    public static void main(String[] args) throws Exception {
	Main m = new Main();
	m.run();
	m.release();
    }
    void release() {
	in.close();
	out.close();
    }

    /*
      1. Compute the largest radius and the factor by which the triangle gets reduced.
      2. Sum up all the radii larger than or equal to 0.000001.
      3. Print out 2*PI times the total radius sum. 
    */
    void run() {
        int cnt = in.nextInt();
        while (cnt-- > 0) {
            double b = in.nextDouble()/2;
            double h = in.nextDouble();
            double l = Math.sqrt(h*h + b*b);
            double len = 0;
            double r;
            double pi = 3.14159265358979323846;

            while (true) {
                r = (b*h)/(l+b);
                h = h - 2*r;
                //out.println(pi + " : " + p);
                if (r < 1e-6)
                    break;
                len += 2*r;
            }
            out.printf("%13.6f%n", len*pi);
            if (cnt > 0)
                out.println();
        }
    }

}
