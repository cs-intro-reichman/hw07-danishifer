/** Draws ths Sierpinski Triangle fractal. */
public class Sierpinski {
	
	public static void main(String[] args) {
		sierpinski(Integer.parseInt(args[0]));
	}
	
	// Draws a Sierpinski triangle of depth n on the standard canvass.
	public static void sierpinski (int n) {
		double height = Math.sqrt(3) / 2.0;
		double[] x = {0.0, 1.0, 0.5};
		double[] y = {0.0, 0.0, height};
		StdDraw.filledPolygon(x, y);
		sierpinski(n, x[0], x[1], x[2], y[0], y[1], y[2]);
	}
	
	// Does the actual drawing, recursively.
	private static void sierpinski(int n, double x1, double x2, double x3,
		                                 double y1, double y2, double y3) {
		if (n == 0) {
			return;
		}
		double mx12 = (x1 + x2) / 2.0;
		double my12 = (y1 + y2) / 2.0;
		double mx23 = (x2 + x3) / 2.0;
		double my23 = (y2 + y3) / 2.0;
		double mx31 = (x3 + x1) / 2.0;
		double my31 = (y3 + y1) / 2.0;
		double[] xHole = {mx12, mx23, mx31};
		double[] yHole = {my12, my23, my31};
		StdDraw.setPenColor(StdDraw.WHITE);
		StdDraw.filledPolygon(xHole, yHole);
		StdDraw.setPenColor(StdDraw.BLACK);
		sierpinski(n - 1, x1, mx12, mx31, y1, my12, my31);
		sierpinski(n - 1, mx12, x2, mx23, my12, y2, my23);
		sierpinski(n - 1, mx31, mx23, x3, my31, my23, y3);
	}
}
