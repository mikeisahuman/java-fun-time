// BouncingSpinningStar : for drawing a bouncing, spinning star

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

public class BouncingStar {
    int x;
    int y;
    Color color;
    Color edgec;
    int xDirection = 0;
    int yDirection = 0;
    int SIZE;			// = 40;
    int minSIZE;		// = (int) (0.40*SIZE);
    // N-point star
	int Npoints;
    int starN;			// = 2*Npoints;
    int[] starX;		// = new int[starN];
    int[] starY;		// = new int[starN];
    double[] starAng;	// = new double[starN];
	double offsetAng = Math.PI/2.0;
	double angDirection = 0;
	// track all stars
	static ArrayList<BouncingStar> allStars = new ArrayList<BouncingStar>();
		

    /**
     * Initialize a new star with its center located at (startX, startY), filled
     * with startColor.
     */
    public BouncingStar(int startX, int startY, int starpoints, int sz, double minfac, 
							Color startColor, Color edgeColor) {
		x = startX;
        y = startY;
		Npoints = starpoints;
		starN = 2*Npoints;
		starX = new int[starN];
		starY = new int[starN];
		starAng = new double[starN];
		SIZE = sz;
		minSIZE = (int) (minfac * SIZE);
        color = startColor;
		edgec = edgeColor;
		allStars.add(this);
    }

	private int myRound(double x) {
		int theint = (int) x;
		int res = theint;
		double rem = x - (double) theint;
		if (rem < 0.5) {
			 return res;
		}
		return (res + 1);
	}

	private int sgn(int x) {
		if (x == 0) {
			return 0;
		} else if (x > 0) {
			return 1;
		}
		return -1;
	}

    /** Draws the star at its current position on to surface. */
    public void draw(Graphics surface) {
		// Make lists for polygon angles & (x,y) locations
		for (int i=0; i<starN; i++) {
		 starAng[i] = offsetAng + i*2*Math.PI/((double) starN);
			if ( (i%2) == 0) {
			  starX[i] = x + myRound( SIZE * Math.cos(starAng[i]) );
			  starY[i] = y - myRound( SIZE * Math.sin(starAng[i]) );
			} else {
			  starX[i] = x + myRound( minSIZE * Math.cos(starAng[i]) );
			  starY[i] = y - myRound( minSIZE * Math.sin(starAng[i]) );
			}
		}
        // Draw the object
        surface.setColor(color);
        surface.fillPolygon(starX, starY, starN);
        surface.setColor(edgec);	//Color.BLACK);
        ((Graphics2D) surface).setStroke(new BasicStroke(2.0f));
        surface.drawPolygon(starX, starY, starN);
        
        // Move the center of the object each time we draw it
        x += xDirection;
        y += yDirection;
		// Rotate by an angle as well
		offsetAng += angDirection;

        // If we have hit the edge and are moving in the wrong direction, reverse direction
        // We check the direction because if a box is placed near the wall, we would get "stuck"
        // rather than moving in the right direction
        if ((x - SIZE <= 0 && xDirection < 0) ||
                (x + SIZE >= SimpleDraw.WIDTH && xDirection > 0)) {
            xDirection = -xDirection;
        }
        if ((y - SIZE <= 0 && yDirection < 0) ||
                (y + SIZE >= SimpleDraw.HEIGHT && yDirection > 0)) {
            yDirection = -yDirection;
        }

		// Check for collisions with other stars, and change direction(s) appropriately.
		for (BouncingStar s: allStars) {
			int dist = myRound( Math.sqrt( (double) ((this.x - s.x)*(this.x - s.x) 
						+ (this.y - s.y)*(this.y - s.y)) ) );
			// circular poximity dictates the collision condition (along with star type/number of points)
			if (this.Npoints != s.Npoints && dist > 5 && dist < (this.SIZE + s.SIZE)) {
				// tangential collision (one component of motion agrees in sign)
				if (sgn(this.xDirection)==sgn(s.xDirection) && sgn(this.yDirection)!=sgn(s.yDirection)) {
					this.yDirection = - this.yDirection;
					s.yDirection = -s.yDirection;
				} else if (sgn(this.yDirection)==sgn(s.yDirection) && sgn(this.xDirection)!=sgn(s.xDirection)) {
					this.xDirection = - this.xDirection;
					s.xDirection = -s.xDirection;
				}
				// true collision (niether component of motion agrees)
				if (sgn(this.xDirection)!=sgn(s.xDirection) && sgn(this.yDirection)!=sgn(s.yDirection)) {
					this.xDirection = - this.xDirection;
					this.yDirection = - this.yDirection;
					s.xDirection = - s.xDirection;
					s.yDirection = - s.yDirection;
				}
				// rear-end, or overlap (both components of motion agree)
				if (sgn(this.xDirection)==sgn(s.xDirection) && sgn(this.yDirection)==sgn(s.yDirection)) {
					this.xDirection = - this.xDirection;
					this.yDirection = - this.yDirection;
					s.xDirection = - s.xDirection;
					s.yDirection = - s.yDirection;
				}
			} else if (this.Npoints == s.Npoints) {
				s.x = this.x;
				s.y = this.y;
				s.xDirection = this.xDirection;
				s.yDirection = this.yDirection;
			}
			// last check: if the stars are the same type (Npoints), force them to stay overlapped & matched
		}
	}

    public void setMovementVector(int xIncrement, int yIncrement) {
        xDirection = xIncrement;
        yDirection = yIncrement;
    }

	public void setRotation(double angIncrement) {
		angDirection = angIncrement * Math.PI/180.0;
	}
} 


