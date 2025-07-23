// for calculating details of projectile motion

public class ProjMotion {
	private double v0;	// in meters per second
	private double ang;	// in degrees
	private double dx = 0;		// displacement in x
	private double dy = 0;		// 		..		in y
	private static double dt = ((double) SimpleDraw.frameDelay()) / 1000.0;	// set time interval from frame rate
	private static double g = 9.80;	// gravitational acceleration (Earth, in m/s^2)
	private double angr;	// angle (radians)
	private double t = 0;	// time (seconds)

	public ProjMotion (double speed, double angle) {
		this.v0 = speed;
		this.ang = angle;
		this.angr = ang*(Math.PI/180.0);
	}

	private int myRound(double x) {
		int pos = 1;
		if (x < 0) {
			x = -x;
			pos = -1;
		}
		int theint = (int) x;
		int res = theint;
		double rem = x - (double) theint;
		if (rem < 0.5) {
			 return pos*res;
		}
		return pos*(res + 1);
	}
	
	public int get_dx () {
		return myRound(dx);
	}
	public int get_dy () {
		return myRound(dy);
	}

	public void increment () {
		this.dx = v0*Math.cos(angr)*dt;
		this.dy = -v0*Math.sin(angr)*dt;
		this.dy += g*t*dt;		// down is positive!
		this.t += dt;
	}
}
