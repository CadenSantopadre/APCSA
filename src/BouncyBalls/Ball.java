package BouncyBalls;

import java.awt.Color;
import java.awt.Graphics;

public class Ball 
{
	//The width and height of the screen
	private int width, height;
	//The (x, y) position of the upper left corner of a square containing the ball
	private int x, y;
	//The diameter of the ball
	private int d;
	//Gravity
	private double g;
	//Time interval
	private double dt;
	//The horizontal and vertical velocities of the ball
	private double vx, vy;

	private int bounces;
	//The current ball color
	private Color color;
	//Java doesn't mess with default parameters, like double vx=0, double vy=0... you gotta make two constructors
	public Ball(int width, int height, int x, int y)
	{
		this.width = width;
		this.height = height;
		vx = 0.0;
		vy = 0.0;
		d = 40;
		g = 9.8;
		dt = 0.20;
		bounces=0;
		//initialize the ball in the center of the screen
		this.x = x;
		this.y = y;
		color = getRandomColor1();
	}
	public Ball(int width, int height, int x, int y, double vx, double vy)
	{
		this.width = width;
		this.height = height;
		this.vx = vx;
		this.vy = vy;
		d = 40;
		g = 9.8;
		dt = 0.20;
		bounces=0;
		//initialize the ball in the center of the screen
		this.x = x;
		this.y = y;
		color = getRandomColor1();
	}
	//picks a random color from an array of colors
	private Color getRandomColor1()
	{
		Color[] colors = {Color.red, Color.pink, Color.blue, Color.green, Color.magenta, Color.cyan, Color.white, Color.gray};
		return colors[(int)(Math.random() * colors.length)];
	}
	
	public void draw(Graphics g)
	{
		g.setColor(color);
		g.fillOval(x, y, d, d);
	}
	public void move()
	{
		//increase the velocity by gravity times the time interval (v = at)
		vy += g * dt;
		//change the y position based on vertical velocity (y = vt)
		y += vy * dt;

		x+=vx*dt;
		//bounce if it hits the floor
		if(y + d > height)
		{
			vy = -vy;
			bounces++;
		}

		if(x-d < 0)
		{
			vx = -vx;
			bounces++;
		}
		if(x + d > width)
		{
			vx = -vx;
			bounces++;
		}

	}

	public int getBounces(){
		return bounces;
	}

	public void adjustSpeed(double adj){
		dt += adj;
		if(dt < 0){
			dt=0;
		}
	}
}
