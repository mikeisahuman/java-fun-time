import java.awt.Graphics;

public class Launcher implements Mover {
    private int x;
    private int y;
    private int xDirection;
    private int yDirection;
	private Sprite sprite;
	private double speed0;	// in meters per second
	private double angle0;	// in degrees
	private double dx;		// displacement in x
	private double dy;		// 		..		in y
//	static double g = 9.80;	// gravitational acceleration (Earth, in m/s^2)
	private ProjMotion motion;
    

    /** Create a Launcher that positions sprite at (startX, startY). */
    public Launcher(int startX, int startY, Sprite sprite) {
        x = startX;
        y = startY;
        this.sprite = sprite; 
    }

    /** Starts moving the object in the direction (xIncrement, yIncrement). */
    public void setMovementVector(int xIncrement, int yIncrement) {
        xDirection = xIncrement;
        yDirection = yIncrement;
    }

	public void setLaunch(double speed, double angle) {
		speed0 = speed;
		angle0 = angle;
		motion = new ProjMotion(speed0, angle0);
	}

    /** Draws the sprite at its current position on to surface. */
    public void draw(Graphics surface) {
        // Draw the sprite
        sprite.draw(surface, x, y);

        // If we have hit the edge and are moving in the wrong direction, reverse direction
        // We check the direction because if a box is placed near the wall, we would get "stuck"
        // rather than moving in the right direction
//        if ((x <= 0 && dx < 0) ||
//                (x + sprite.getWidth() >= SimpleDraw.WIDTH && dx > 0)) {
//            dx = -dx;
//        }
//        if ((y <= 0 && dy < 0) ||
//                (y + sprite.getHeight() >= SimpleDraw.HEIGHT && dy > 0)) {
//            dy = -dy;
//        }

		// Move the object each time we draw it
        x += motion.get_dx();
        y += motion.get_dy();

		// Calculate displacements in the next timeframe
		motion.increment();
    }
}
