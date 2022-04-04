package digdug;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import java.net.URL;

public class Miner{
	
	private int x, y; 
	private double fallSpeed;
	private boolean grounded;
	private double gravity;
	private Image img; 	
	private AffineTransform tx;
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public void setY(int newY) {
		y = newY;
	}
	public void setX(int newX) {
		x = newX;
	}
	public double getFallSpeed() {
		return fallSpeed;
	}
	public void setFallSpeed(double fallSpeed) {
		this.fallSpeed = fallSpeed;
	}
	public boolean isGrounded() {
		return grounded;
	}
	public void setGrounded(boolean grounded) {
		this.grounded = grounded;
	}
	public double getGravity() {
		return gravity;
	}
	public void setGravity(double gravity) {
		this.gravity = gravity;
	}
	

	public Miner(int x, int y) {
		img = getImage("minerR.png"); //load the image for Tree
		this.x = x;
		this.y = y;
		tx = AffineTransform.getTranslateInstance(x, y);
		init(x, y);
		
		fallSpeed = 0.5;
		gravity = 1.5;
		grounded = false;
	}
	
	public void changePicture(String newFileName) {
		img = getImage(newFileName);
		init(x, y);
	}
	
	public void paint(Graphics g) {
		//these are the 2 lines of code needed draw an image on the screen
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(img, tx, null);
		y += fallSpeed;
		fallSpeed += gravity;
		update();
		if(gravity == 0) {
			grounded = true;
		}
		if(y > 200) {
			y = 200;
			fallSpeed = 0;
			gravity = 0;
		}
	}
	
	public void jump() {
		if(grounded) {
			gravity = 1.5;
			fallSpeed = 50*-0.5;
			grounded = false;
		}
	}
	
	public void fall() {
		if(grounded = false) {
			fallSpeed = 100;
		}
	}
	//update the picture variable location
	private void update() {
		tx.setToTranslation(x, y);
		tx.scale(1.0, 1.0);
		
		
	}

	private void init(double a, double b) {
		tx.setToTranslation(a, b);
		tx.scale(1.0, 1.0);
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