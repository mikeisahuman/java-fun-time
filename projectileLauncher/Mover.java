import java.awt.Graphics;

public interface Mover {
    /** Starts moving the object in the direction (xIncrement, yIncrement). */
    public void setMovementVector(int xIncrement, int yIncrement);

	public void setLaunch(double launchSpeed, double launchAngle);

	/** Draws the sprite at its current position on to surface. */
    public void draw(Graphics graphics);
}

