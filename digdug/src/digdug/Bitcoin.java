package digdug;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.net.URL;

public class Bitcoin {
	private int x;
	private int y; 
	private int width;
    private int height;
	private Image img; 	
	private boolean visible;
	private AffineTransform tx;
	
	public Image getImg() {
	    return img;
	}
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
	
	
	public Bitcoin(int x, int y) {
		img = getImage("bitcoin.png"); 
		this.x = x;
		this.y = y;
		tx = AffineTransform.getTranslateInstance(x, y);
		init(x, y);
		visible = true;
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
	
		update();
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
			URL imageURL = Goblins.class.getResource(path);
			tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempImage;
	}
	public Rectangle getBoundsB() {
		// TODO Auto-generated method stub
		return new Rectangle(x, y, width, height);
	}
	

}
