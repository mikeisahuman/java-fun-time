// DrawGraphics : file for actually placing (drawing) graphics

import java.awt.Color;
import java.awt.Graphics;

public class DrawGraphics {
    int winWidth = SimpleDraw.WIDTH;
	int winHeight = SimpleDraw.HEIGHT;

    //BouncingBox box;
    BouncingStar star6;
    BouncingStar star5;
    BouncingStar star4;
    BouncingStar star3;
    BouncingStar star3b;
    BouncingStar star2a;
    BouncingStar star2b;
    
    /** Initializes this class for drawing. */
    public DrawGraphics() {
        //box = new BouncingBox(400, 100, Color.BLUE, Color.GREEN);	// (x, y, face, edge)
	   //box.setMovementVector(2,3);	// (xmotion, ymotion)
	   // (x, y, points, size, minfac, face, edge)
	   star6 = new BouncingStar(200, 400, 6, 45, 0.5, Color.CYAN, Color.YELLOW);
	   star6.setMovementVector(-3,4);
	   star6.setRotation(10.0);	// in degrees (per frame)
	   star5 = new BouncingStar(220, 220, 5, 45, 0.5, Color.WHITE, Color.CYAN);
	   star5.setMovementVector(-3,4);
	   star5.setRotation(5.5);	
	   star4 = new BouncingStar(450, 250, 4, 40, 0.5, Color.YELLOW, Color.BLUE);
	   star4.setMovementVector(4,3);
	   star4.setRotation(-6.0);
	   star3 = new BouncingStar(500, 500, 3, 50, 0.33, Color.GREEN, Color.WHITE);
	   star3.setMovementVector(-2,5);
	   star3.setRotation(7.5);
	   star3b = new BouncingStar(500, 500, 3, 50, 0.33, Color.MAGENTA, Color.GREEN);
	   star3b.setMovementVector(-2,5);
	   star3b.setRotation(-7.5);
	   star2a = new BouncingStar(100, 180, 2, 40, 0.33, Color.RED, Color.GRAY);
	   star2a.setMovementVector(2,3);
	   star2a.setRotation(7.0);
	   star2b = new BouncingStar(100, 180, 2, 40, 0.33, Color.GRAY, Color.RED);
	   star2b.setMovementVector(2,3);
	   star2b.setRotation(-7.0);
    }

    /** Draw the contents of the window on surface. Called 20 times per second. */
    public void draw(Graphics surface) {
	   surface.setColor(Color.WHITE);
	   surface.drawLine(winWidth/2, 0, 0, 2*winHeight/3);
	   surface.drawLine(winWidth/2, 0, winWidth, 2*winHeight/3);
	   surface.drawLine(winWidth/2, winHeight, 0, winHeight/3);
	   surface.drawLine(winWidth/2, winHeight, winWidth, winHeight/3);
        //surface.drawLine(50, 50, 250, 350);	// (xi, yi, xf, yf)
        //box.draw(surface);
	   star6.draw(surface);
	   star5.draw(surface);
	   star4.draw(surface);
	   star3.draw(surface);
	   star3b.draw(surface);
	   star2a.draw(surface);
	   star2b.draw(surface);
    }
} 

