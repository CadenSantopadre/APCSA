package BouncyBalls;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.JPanel;

public class BouncyBalls extends JPanel implements Runnable, MouseListener, MouseWheelListener
{
	//The width and height of the window
	private int width, height;
	private Thread thread; //This is for time I think
	private ArrayList<Ball> balls; //We don't need to declare private Ball ball because we just look at the arraylist
	public BouncyBalls(int width, int height)
	{
		this.width = width;
		this.height = height;
		balls = new ArrayList<>(); //init the balls
		thread = new Thread(this);
		thread.start();
		addMouseListener(this);
		addMouseWheelListener(this);
		setBackground(Color.black);
	}
	@Override
	public void run() 
	{
		//Loops until the thread is interruped
		//Sleeps for 50 milliseconds and then calls repaint() which calls paintComponent()
		while(true)
    	{
    		try {
    			Thread.sleep(50);
    		} catch (InterruptedException e) { 
    			System.out.println("Thread stopped");
    			thread.interrupt();
    			return;
    		}
    		repaint();
    	}
	}
	@Override
    public void paintComponent(Graphics g) 
    {
		super.paintComponent(g);
		//move the ball and then redraw it
		for(int i=0; i<balls.size();i++){ //Loop through each ball in balls
			if(balls.get(i).getBounces()<3){ //Do an action on the ball in particular
				balls.get(i).move();
				balls.get(i).draw(g);
			} else{
				balls.remove(i);
			}
		}
		//smooths drawing on linux
        Toolkit.getDefaultToolkit().sync();
    }
	//This method is called every time you click a mouse button on the JPanel.
	@Override
	public void mouseClicked(MouseEvent event) 
	{
		int xpos = event.getX();
		int ypos = event.getY();
		//left click is button 1
		if(event.getButton() == 1)
		{
			balls.add(new Ball(width, height,xpos,ypos));
			System.out.printf("Left Click @ (%d, %d)\n", xpos, ypos);

		}
		//right click is button 3
		else if(event.getButton() == 3)
		{
			double rand40 = (Math.random() * 80.0) - 40.0;
			balls.add(new Ball(width, height,xpos,ypos, rand40, 0));//Make sure to add the random velocity
			System.out.printf("Right Click @ (%d, %d)\n", xpos, ypos);
		}
	}
	@Override
	public void mouseEntered(MouseEvent event) {}
	@Override
	public void mouseExited(MouseEvent event) {}
	@Override
	public void mousePressed(MouseEvent event) {}
	@Override
	public void mouseReleased(MouseEvent event) {}

	@Override
	public void mouseWheelMoved(MouseWheelEvent event) {
		double direction = event.getWheelRotation(); 
		double amount = event.getScrollAmount();
		
		double adj = direction * amount *0.1; //0.1 so we can actually see and it doesnt blow up

		if(adj!=0){
			for(int i=0; i<balls.size();i++){
				balls.get(i).adjustSpeed(adj);
			}
		}
	}

}

