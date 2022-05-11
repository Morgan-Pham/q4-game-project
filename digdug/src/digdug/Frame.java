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
	 *  get james' speed movement
	 * 
	 * 
	 */

public class Frame extends JPanel implements ActionListener, MouseListener, KeyListener {
	Miner m = new Miner(100, 700);
	Goblins c = new Goblins(1000, 45);
	Background bg = new Background();
	Background2 bg2 = new Background2();
	Bitcoin b;
	Doge d;
	Ethereum et;
	ArrayList<Goblins> goList = new ArrayList<>();
	ArrayList<Bitcoin> bList = new ArrayList<Bitcoin>();
	ArrayList<Doge> dList = new ArrayList<Doge>();
	ArrayList<Ethereum> eList = new ArrayList<Ethereum>();
	int[][] arr = new int[2048][2048];
	private int score = 0;
	private boolean test = true;
	boolean right;
	boolean left;
	private boolean ingame;
	private Timer timer;
	int time = 60;
	counter timeCounter = new counter();

	public void paint(Graphics g) {
		
		bg.paint(g);
		bg2.paint(g);
	
		for(Bitcoin b: bList) {
			b.paint(g);
		Rectangle r3 = new Rectangle(m.getX(), m.getY(), m.getX()+10, m.getY()+5);
	    Rectangle r2 = new Rectangle(b.getX(), b.getY(), b.getX()+5, b.getY()+5);

	    if (r3.intersects(r2)==true) {
	       b.setX(1000);
	    	}
		}
		for(Doge d: dList) {
			d.paint(g);
		}
		for(Ethereum et: eList) {
			et.paint(g);
		}
	
		m.paint(g);
		if(test = true) {
			//if(m.getY() > 250) {
				m.setY(250);
			}
			//(m.getImage(), m.getX(), m.getY(),this));
		//}.
		
		
		
		
		Font f = new Font("Times New Roman", Font.BOLD, 50);
		g.setFont(f);
		g.drawString("Bitcoin Miner", 340, 50);
		g.drawString(score+"", 800, 50);
		g.drawString(String.valueOf(time), 45, 50);
		if(timeCounter.getY()>=40) {
			timeCounter.setY(0);
			time--;
		}
		Font y = new Font("Times New Roman", Font.BOLD, 20);
		g.setFont(y);
		timeCounter.setY(timeCounter.getY()+1);
	}
	
	public static void main(String[] arg) {
		Frame f = new Frame();
		
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
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	
		for(int i = 0; i<11; i++) {
			Bitcoin temp = new Bitcoin((int)(Math.random()*800)+1, (int)(Math.random()*700)+200);
			bList.add(temp);
		}
		for(int i = 0; i<11; i++) {
			Doge temp = new Doge((int)(Math.random()*800)+1, (int)(Math.random()*700)+200);
			dList.add(temp);
		}
		for(int i = 0; i<11; i++) {
			Ethereum temp = new Ethereum((int)(Math.random()*800)+1, (int)(Math.random()*700)+200);
			eList.add(temp);
		}
	
	}
	
	
	
	private Rectangle Rectangle(int x, int y, int i, int j) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
	
		System.out.println(arg0.getX()+" "+arg0.getY());
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
		if(arg0.getKeyCode() == 39) {
			m.setX(m.getX()+10);
			m.changePicture("minerR.png");
			right = true;
			left = false;
		}
		
		if(arg0.getKeyCode() == 37) {
			m.setX(m.getX()-10);
			m.changePicture("minerL.png");
			left = true;
			right = false;
		}
		
		if(arg0.getKeyCode() == 38) {
			m.jump();
		}
		
		if(right == true) {
			if(arg0.getKeyCode() == 32) {
			m.changePicture("mineR.png");
			}
		}
	
		if(left == true) {
			if(arg0.getKeyCode() == 32) {
			m.changePicture("mineL.png");
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
