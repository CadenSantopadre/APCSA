package BouncyBalls;

import javax.swing.JFrame;
public class BallRunner 
{
	public static void main(String[] args) 
	{
		int width = 800;
		int height = 600;
		BouncyBalls panel = new BouncyBalls(width, height);
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		frame.setSize(width, height);
		frame.setVisible(true);
	}
}

