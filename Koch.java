/** Draws the Koch curve and the the Koch snowflake fractal. */
public class Koch {

	public static void main(String[] args) {

		//// Uncomment the first code block to test the curve function.
		//// Uncomment the second code block to test the snowflake function.
		//// Uncomment only one block in each test, and remember to compile
		//// the class whenever you change the test.

        /*
		// Tests the curve function:
		// Gets n, x1, y1, x2, y2,
		// and draws a Koch curve of depth n from (x1,y1) to (x2,y2).
		curve(Integer.parseInt(args[0]),
			  Double.parseDouble(args[1]), Double.parseDouble(args[2]), 
		      Double.parseDouble(args[3]), Double.parseDouble(args[4]));
		*/

		/*
		// Tests the snowflake function:
		// Gets n, and draws a Koch snowflake of n edges in the standard canvass.
		snowFlake(Integer.parseInt(args[0]));
		*/
	}

	/** Gets n, x1, y1, x2, y2,
     *  and draws a Koch curve of depth n from (x1,y1) to (x2,y2). */
	public static void curve(int n, double x1, double y1, double x2, double y2) {
		if (n == 0) {
			StdDraw.line(x1, y1, x2, y2);
			return;
		}
		double dx = (x2 - x1) / 3.0;
		double dy = (y2 - y1) / 3.0;
		double xA = x1 + dx;
		double yA = y1 + dy;
		double xB = x1 + 2 * dx;
		double yB = y1 + 2 * dy;
		double xPeak = (Math.sqrt(3) * (y1 - y2) / 3.0) + (x1 + x2) / 2.0;
		double yPeak = (Math.sqrt(3) * (x2 - x1) / 3.0) + (y1 + y2) / 2.0;
		curve(n - 1, x1, y1, xA, yA);
		curve(n - 1, xA, yA, xPeak, yPeak);
		curve(n - 1, xPeak, yPeak, xB, yB);
		curve(n - 1, xB, yB, x2, y2);
	}

    /** Gets n, and draws a Koch snowflake of n edges in the standard canvass. */
	public static void snowFlake(int n) {
		// A little tweak that makes the drawing look better
		StdDraw.setYscale(0, 1.1);
		StdDraw.setXscale(0, 1.1);
		// Draws a Koch snowflake of depth n
		double x1 = 0.2, y1 = 0.1;
		double x2 = 0.8, y2 = 0.1;
		double side = x2 - x1;
		double x3 = 0.5;
		double y3 = y1 + Math.sqrt(3) * side / 2.0;
		curve(n, x1, y1, x2, y2);
		curve(n, x2, y2, x3, y3);
		curve(n, x3, y3, x1, y1);
	}
}
