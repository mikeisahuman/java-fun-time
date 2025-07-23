// simple projectile motion example

public class projectile_test {
	static double g = 9.8;	// gravitational accel. (m/s^2)
	static double v0 = 20;	// initial velocity (m/s)
	static double ang = 60;// initial angle (degrees)
	static double angr = ang*(Math.PI/180.0);	// angle (radians)
	static double t0 = 0;	// initial time (seconds)
	static double x0 = 0;	// initial x position (meters)
	static double y0 = 0;	// initial y position (meters)
	
	public static double x (double t) {
		double res = x0;
		res += v0*Math.cos(angr)*t;
		return res;
	}
	public static double y (double t) {
		double res = y0;
		res += v0*Math.sin(angr)*t;
		res += -0.5*g*t*t;
		return res;
	}

	public static void main(String[] args) {
		double t = 2.125;	// chosen final time (seconds)

		System.out.println("\n\tBeginning at (x0, y0)=(" + x0 + ", " + y0 + "):\n");
		System.out.println("After " + t + " seconds... ");
		System.out.println("\t(x, y)=(" + x(t) + ", " + y(t) + ")\n");
	
	}
}