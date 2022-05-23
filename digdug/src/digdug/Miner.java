package digdug;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import java.net.URL;

public class Miner{
	
	private int x, y, width, height; 
	private double fallSpeed;
	private boolean grounded;
	private double gravity;
	private int speed;
	private int sped;
	private Image img; 	
	private AffineTransform tx;
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}
	public void setY(int newY) {
		y = newY;
	}
	public void setX(int newX) {
		x = newX;
	}
	public void setWidth(int newWidth) {
		width = newWidth;
	}
	public void setHeight(int newHeight) {
		height = newHeight;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int newSpeed) {
		speed = newSpeed;
	}
	public int getSped() {
		return sped;
	}
	public void setSped(int newSped) {
		sped = newSped;
	}
	

	public Miner(int x, int y) {
		img = getImage("minerR.png"); //load the image for Tree
		this.x = x;
		this.y = y;
		tx = AffineTransform.getTranslateInstance(x, y);
		init(x, y);
		
	}
	
	public void getImageDimensions() {

        width = img.getWidth(null);
        height = img.getHeight(null);
    }
	
	public void changePicture(String newFileName) {
		img = getImage(newFileName);
		init(x, y);
	}
	
	public void paint(Graphics g) {
		//these are the 2 lines of code needed draw an image on the screen
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(img, tx, null);
		x += speed;
		y += sped;
		update();
		
	}
	
	 
	//update the picture variable location
	private void update() {
		tx.setToTranslation(x, y);
		tx.scale(0.5, 0.5);
		
		
	}

	private void init(double a, double b) {
		tx.setToTranslation(a, b);
		tx.scale(0.5, 0.5);
	}

	private Image getImage(String path) {
		Image tempImage = null;
		try {
			URL imageURL = Miner.class.getResource(path);
			tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempImage;
	}

}
