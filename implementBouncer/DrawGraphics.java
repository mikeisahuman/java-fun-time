import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class DrawGraphics {
	ArrayList<Mover> allSprites = new ArrayList<Mover>();
//	ArrayList<Bouncer> allSprites = new ArrayList<Bouncer>();
//	ArrayList<StraightMover> straights = new ArrayList<StraightMover>();

    /** Initializes this class for drawing. */
    public DrawGraphics() {
        Rectangle box = new Rectangle(45, 55, Color.RED);
        allSprites.add( new Bouncer(100, 170, box) );
        allSprites.get(0).setMovementVector(4, 3);

		Oval ball = new Oval(45, 35, Color.BLUE);
		allSprites.add( new Bouncer(250, 100, ball) );
		allSprites.get(1).setMovementVector(-4, 4);

		Rectangle box2 = new Rectangle(55, 45, Color.GRAY);
        allSprites.add( new StraightMover(50, 200, box2) );
        allSprites.get(2).setMovementVector(3, 4);

		Oval ball2 = new Oval(30, 35, Color.BLACK);
		allSprites.add( new StraightMover(180, 60, ball2) );
		allSprites.get(3).setMovementVector(2, 4);	

//		Rectangle box2 = new Rectangle(55, 45, Color.GRAY);
//        straights.add( new StraightMover(50, 200, box) );
//        straights.get(0).setMovementVector(3, 4);
//
//		Oval ball2 = new Oval(30, 35, Color.BLACK);
//		straights.add( new StraightMover(180, 60, ball) );
//		straights.get(1).setMovementVector(2, 4);	
    }

    /** Draw the contents of the window on surface. */
    public void draw(Graphics surface) {
		for (Mover m: allSprites) {
			m.draw(surface);
		}
//		for (Bouncer s: allSprites) {
//			s.draw(surface);
//		}
//		for (StraightMover s: straights) {
//			s.draw(surface);
//		}
    }
}
