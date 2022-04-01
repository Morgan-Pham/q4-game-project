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
	Bitcoin b = new Bitcoin(100, 100);
	Ethereum e = new Ethereum(100, 100);
	Doge d = new Doge(100, 100);
	Background bg = new Background();
	Background2 bg2 = new Background2();
	ArrayList<Goblins> goblinList = new ArrayList<>();
	private int score = 0;
	private boolean test = true;
	
	public void paint(Graphics g) {
		bg.paint(g);
		bg2.paint(g);
		b.paint(g);
		e.paint(g);
		d.paint(g);
		
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
	}
	
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
	
		
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
		}
		
		if(arg0.getKeyCode() == 37) {
			m.setX(m.getX()-10);
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