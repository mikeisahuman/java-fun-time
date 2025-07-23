import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class DrawGraphics {
	ArrayList<Mover> allSprites = new ArrayList<Mover>();
	private int maxX = SimpleDraw.WIDTH;
	private int maxY = SimpleDraw.HEIGHT;

    /** Initializes this class for drawing. */
    public DrawGraphics() {
		Projectile ball = new Projectile(30, Color.WHITE, Color.RED);
		allSprites.add( new Launcher(maxX/10, (maxY-maxY/2), ball) );
		allSprites.get(0).setLaunch(15, 45);
    }

    /** Draw the contents of the window on surface. */
    public void draw(Graphics surface) {
		for (Mover s: allSprites) {
			s.draw(surface);
		}
    }
}
