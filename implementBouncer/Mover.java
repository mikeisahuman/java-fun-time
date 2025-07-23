import java.awt.Graphics;

public interface Mover {
    /** Starts moving the object in the direction (xIncrement, yIncrement). */
    public void setMovementVector(int xIncrement, int yIncrement);

	/** Draws the sprite at its current position on to surface. */
    public void draw(Graphics graphics);
}

