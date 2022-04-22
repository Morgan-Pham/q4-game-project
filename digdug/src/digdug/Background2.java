package digdug;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import java.net.URL;

public class Background2{
	
	//add location attributes
	private int x, y; //position of the bird
	private Image img; 	
	private AffineTransform tx;

	public Background2() {
		img = getImage("grass.jpg"); //load the image for Tree
		this.x = x;

		tx = AffineTransform.getTranslateInstance(x, y);
		init(x, y); 				//initialize the location of the image
									//use your variables
	}

	public void changePicture(String newFileName) {
		img = getImage(newFileName);
		init(x, y);
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void paint(Graphics g) {
		//these are the 2 lines of code needed draw an image on the screen
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(img, tx, null);
		
		update();
		//call update to update the actual picture location
	}
	
	//update the picture variable location
	private void update() {
		tx.setToTranslation(x, y);
		tx.scale(1.0, 1.0);
		x = 0;
		y = 200;
	}

	private void init(double a, double b) {
		tx.setToTranslation(a, b);
		tx.scale(1.0, 1.0);
	}

	private Image getImage(String path) {
		Image tempImage = null;
		try {
			URL imageURL = Background.class.getResource(path);
			tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempImage;
	}
}
