package digdug;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Point;
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
	 * 
	 */

public class Frame extends JPanel implements ActionListener, MouseListener, KeyListener {
	Miner m = new Miner(100, 400);
	Goblins c = new Goblins(1000, 45);
	Background bg = new Background();
	Background2 bg2 = new Background2();
	Bitcoin b;
	Doge d;
	Ethereum e;
	ArrayList<Goblins> goblinList = new ArrayList<>();
	ArrayList<Bitcoin> bList = new ArrayList<Bitcoin>();
	ArrayList<Doge> dList = new ArrayList<Doge>();
	ArrayList<Ethereum> eList = new ArrayList<Ethereum>();
	private int score = 0;
	private boolean test = true;
	

	public void paint(Graphics g) {
		bg.paint(g);
		for(Bitcoin b: bList) {
			b.paint(g);
		}
		for(Doge d: dList) {
			d.paint(g);
		}
		for(Ethereum e: eList) {
			e.paint(g);
		}
		//bg2.paint(g);
		for(Bitcoin b : bList) {
			if((m.getX() >= b.getX() && m.getX() <= b.getX()+300 && m.getY() >= b.getY() && m.getY() <= b.getY()+300) || (m.getX() >= b.getX() && m.getX() <= b.getX()-300 && m.getY() >= b.getY() && m.getY() <= b.getY()-300)){
				b.setX(1000);
			}
			//miner 135 80
		}
		
		m.paint(g);
		if(test = true) {
			if(m.getY() > 430) {
				m.setY(430);
			}
		}
	/*	for(Goblins c : goblinList) {
			c.paint(g);
			if(c.getX() == 0) {
				
			}
		*/
		Font f = new Font("Times New Roman", Font.BOLD, 50);
		g.setFont(f);
		g.drawString("Bitcoin Miner", 340, 50);
		g.drawString(score+"", 800, 50);
		Font e = new Font("Times New Roman", Font.BOLD, 20);
		g.setFont(e);
	}
	
	public static void main(String[] arg) {
		Frame f = new Frame();
		
	}
	
	
	public Frame() {
		JFrame f = new JFrame("Bitcoin Miner");
		f.setSize(new Dimension(900, 600));
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
	
		
		for(int i = 0; i < 100; i++) {
			Goblins temp2 = new Goblins(500*i, 450);
			goblinList.add(temp2);
		} 
		for(int i = 0; i<6; i++) {
			Bitcoin temp = new Bitcoin((int)(Math.random()*800)+1, (int)(Math.random()*250)+250);
			bList.add(temp);
		}
		for(int i = 0; i<6; i++) {
			Doge temp = new Doge((int)(Math.random()*800)+1, (int)(Math.random()*250)+250);
			dList.add(temp);
		}
		for(int i = 0; i<6; i++) {
			Ethereum temp = new Ethereum((int)(Math.random()*800)+1, (int)(Math.random()*250)+250);
			eList.add(temp);
		}
		
		
	
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
		}
		
		if(arg0.getKeyCode() == 37) {
			m.setX(m.getX()-10);
			m.changePicture("minerL.png");
		}
		
		if(arg0.getKeyCode() == 38) {
			m.jump();
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