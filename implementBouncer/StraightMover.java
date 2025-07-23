import java.awt.Graphics;

public class StraightMover implements Mover {
    private int x;
    private int y;
    private int xDirection;
    private int yDirection;
    private Sprite sprite;

    /** Create a StraightMover that positions sprite at (startX, startY). */
    public StraightMover(int startX, int startY, Sprite sprite) {
        x = startX;
        y = startY;
        this.sprite = sprite; 
    }

    /** Starts moving the object in the direction (xIncrement, yIncrement). */
    public void setMovementVector(int xIncrement, int yIncrement) {
        xDirection = xIncrement;
        yDirection = yIncrement;
    }

	/** Draws the sprite at its current position on to surface. */
    public void draw(Graphics graphics) {
		// Draw the sprite
        sprite.draw(graphics, x, y);

        // Move the center of the object each time we draw it
        x += xDirection;
        y += yDirection;
    }
}
