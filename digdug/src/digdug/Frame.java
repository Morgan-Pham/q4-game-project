package digdug;


import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

	/*	get an attack that destroys the closest square to the miner
	 * 	get collision and jumping
	 */

public class Frame extends JPanel implements ActionListener, MouseListener, KeyListener {
	Miner m = new Miner(100, 150); 
	Background bg = new Background();
	Background2 bg2 = new Background2();
	Bitcoin b;
	Doge d;
	Ethereum e;
	Music ms = new Music("digdug.wav", true);
	Music co = new Music("coin.wav", false);
	Music dig = new Music("dig.wav", false);
	Music yell = new Music("scream.wav", false);
	ArrayList<Bitcoin> bList = new ArrayList<Bitcoin>();
	ArrayList<kirby> kList = new ArrayList<kirby>();
	ArrayList<Doge> dList = new ArrayList<Doge>();
	ArrayList<Ethereum> eList = new ArrayList<Ethereum>();
	ArrayList<Rect> arr = new ArrayList<Rect>();
	private int score = 0;
	int time = 20;
	counter timeCounter = new counter();

	public void paint(Graphics g) {
		bg.paint(g);
		
		bg2.paint(g);
		
		for(kirby k: kList) {
			k.paint(g);
		Rectangle rm = new Rectangle(m.getX()+5, m.getY(), 85, 60);
		Rectangle rk = new Rectangle(k.getX(), k.getY(), 60, 60);
				    
			if (rm.intersects(rk)==true) {
				yell.play();
				k.setX(1000);
				score-=50;
			}
		}  
		
	//	for(int i = 0; i < arr.size(); i++) {
	//			g.fillRect((int)arr.get(i).getX(), (int)arr.get(i).getY(), 50, 50);
	//	}
		for(Rect r : arr) {
			g.fillRect((int)r.getX(), (int)r.getY(), 50, 50);
			System.out.println(r.getX() + " " + r.getY() );
		}
		if(m.getSpeed() > 0 || m.getSpeed() < 0) {
				arr.add(new Rect(m.getX(), m.getY()));
				System.out.println(m.getX() + " " + m.getY());
		} 
		if(m.getSped() > 0 || m.getSped() < 0) {
			arr.add(new Rect(m.getX(), m.getY()));
			//g.fillRect((int)arr.get(i).getX(), (int)arr.get(i).getY(), 50, 50);
		} 
		
		for(Bitcoin b: bList) { //collision for bitcoin
			b.paint(g);
		Rectangle rm = new Rectangle(m.getX()+5, m.getY(), 85, 60);
	    Rectangle rd = new Rectangle(b.getX(), b.getY(), 60, 60);
	    
	    if (rm.intersects(rd)==true) {
	    	co.play();
	       b.setX(1000);
	       score+=100;
	    	}
		}

		for(Doge d: dList) { //collision for doge
			d.paint(g);
		Rectangle rm = new Rectangle(m.getX()+5, m.getY(), 85, 60);
		Rectangle rd = new Rectangle(d.getX(), d.getY(), 60, 60);
		    
		    if (rm.intersects(rd)==true) {
		    	co.play();
		    	d.setX(1000);
		       score+=20;
		    }
		}
		
		for(Ethereum e: eList) { //collision for ethereum
			e.paint(g);
		Rectangle rm = new Rectangle(m.getX()+5, m.getY(), 85, 60);
		Rectangle re = new Rectangle(e.getX(), e.getY(), 60, 60);
			    
			if (rm.intersects(re)==true) {
			   e.setX(1000);
			   co.play();
			   score+=70;
			}
		}
		
		
			
		m.paint(g);
		if(m.getY() <= 150) {
			m.setY(150);
		}
		if(m.getX() <= 0) {
			m.setX(0);
		}
		if(m.getX() >= 790) {
			m.setX(790);
		}
		if(m.getY() >= 875) {
			m.setY(875);
		}
	    

		Font f = new Font("Times New Roman", Font.BOLD, 50);
		g.setFont(f);
		g.setColor(Color.yellow);
		g.drawString("Crypto Miner", 290, 50);
		g.drawString(score+"", 750, 50);
		Font e = new Font("Times New Roman", Font.BOLD, 50);
		g.setFont(e);
		g.drawString(String.valueOf(time), 45, 50);
		if(timeCounter.getY()>=40) {
			timeCounter.setY(0);
			time--;
		}
		if(time == 0) {
			Font h = new Font("Times New Roman", Font.BOLD, 200);
			g.setFont(h);
			g.setColor(Color.yellow);
			g.drawString("UR DONE", 0, 500);
		}
		if(time == -1) {
			System.exit(0);
		}
		Font y = new Font("Times New Roman", Font.BOLD, 30);
		g.setFont(y);
		g.setColor(Color.yellow);
		timeCounter.setY(timeCounter.getY()+1);

	}
	
	public static void main(String[] arg) {
		Frame r = new Frame();
	}
	public Frame() {
		JFrame f = new JFrame("Bitcoin Miner");
		f.setSize(new Dimension(890, 990));
		f.setBackground(Color.white);
		f.add(this);
		f.setResizable(false);
		f.setLayout(new GridLayout(1,2));
		f.addMouseListener(this);
		f.addKeyListener(this);
		Timer t = new Timer(16, this);
		t.start();
		ms.play();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		for(int i = 0; i<11; i++) {
			Bitcoin temp = new Bitcoin((int)(Math.random()*800)+1, (int)(Math.random()*700)+250);
			bList.add(temp);
		}
		for(int i = 0; i<11; i++) {
			Doge temp = new Doge((int)(Math.random()*800)+1, (int)(Math.random()*700)+250);
			dList.add(temp);
		}
		for(int i = 0; i<11; i++) {
			Ethereum temp = new Ethereum((int)(Math.random()*800)+1, (int)(Math.random()*700)+250);
			eList.add(temp);
		}
		for(int i = 0; i<21; i++) {
			kirby temp = new kirby((int)(Math.random()*800)+1, (int)(Math.random()*700)+250);
			kList.add(temp);
		}
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
	System.out.println(arg0.getX() + " " + arg0.getY());
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		repaint();
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println(arg0.getKeyCode());
		if(arg0.getKeyCode() == 39) { //right
			m.setSpeed(+5);
			dig.play();
			m.changePicture("minerR.png");
		}
		
		if(arg0.getKeyCode() == 37) { //left
			m.setSpeed(-5);
			dig.play();
			m.changePicture("minerL.png");
		}
		
		if(arg0.getKeyCode() == 40) {  //down
			m.setSped(+5);
			dig.play();
		}
	
		if(arg0.getKeyCode() == 38) {   //up
			m.setSped(-5);
			dig.play();
		}
		
	}
	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getKeyCode() == 39) {
			m.setSpeed(0);
		}
		if(arg0.getKeyCode() == 37) {
			m.setSpeed(0);
		}
		if(arg0.getKeyCode() == 38) {
			m.setSped(0);
		}
		if(arg0.getKeyCode() == 40) {
			m.setSped(0);
		}

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}