import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Projectile implements Sprite {
    private int width;
    private int height;
    private Color color;
	private Color edge;

    /**
     * Create a projectile (ball) that has dimensions width and height, filled with
     * color.
     */
    public Projectile(int size, Color color, Color edge) {
        this.width = size;
        this.height = size;
        this.color = color;
		this.edge = edge;
    }

    public void draw(Graphics surface, int x, int y) {
        // Draw the object
        surface.setColor(color);
        surface.fillOval(x, y, width, height);
        surface.setColor(edge);
        ((Graphics2D) surface).setStroke(new BasicStroke(2.0f));
        surface.drawOval(x, y, width, height);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}

