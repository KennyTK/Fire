package kennyTK;

import java.awt.geom.Point2D;
import java.util.ArrayList;

import processing.core.PApplet;

public class Main extends PApplet
{
	int bgColor = color(34, 49, 63);

	PSystem flame;
	PSystem smoke;
	PSystem pollution;
	PSystem sparks;
	PSystem coals;
	PSystem fireflies;

	ArrayList<PSystem> systems;
	ArrayList<Point2D.Float> grass;

	boolean fullscreen = false;

	public static void main(String[] args)
	{
		PApplet.main("kennyTK.Main");
	}

	public void settings()
	{
		size(640, 640);
	}

	public void setup()
	{
		frameRate(60);
		colorMode(RGB, 255, 255, 255, 100);
		ellipseMode(CENTER);

		systems = new ArrayList<PSystem>();
		grass = new ArrayList<Point2D.Float>();

		flame 		= new PSystem(this, width / 2, 520, .8f, getRadians(90), 0, .2f, 0, getRadians(0),-.01f, .01f, 30, 10, 3, 2, color(150, 40, 27, 100), 1000, 60, 30);

		smoke 		= new PSystem(this, width / 2, 500, 1f, getRadians(90), 0, 0, 0, 0, 0, 0, 30, 10, 15, 5, color(189, 195, 199, 70), 60, 180, 30);

		pollution	= new PSystem(this, width / 2, 480, .5f, getRadians(90), 0, .1f, 0, getRadians(0), 0f, .02f, 30, 10, 20, 10, color(108, 122, 137, 50), 60, 180, 30);
		
		sparks 		= new PSystem(this, width / 2, 500, 1.2f, getRadians(90), 0, .3f, 0, getRadians(0), 0f, .02f, 20, 10, 3, 2, color(232, 126, 4), 50, 60, 30);

		coals 		= new PSystem(this, width / 2, 525, .8f, getRadians(90), 0, .2f, 0, getRadians(0),-.01f, .01f, 30, 10, 3, 2, color(211, 84, 0, 100), 200, 30, 30);

		fireflies	= new PSystem(this, 320, 250, 0, getRadians(0), -.2f, .2f, 0, getRadians(90), -.005f, .005f, 320, 250, 2, 2, color(233,212,96, 100), 10, 120, 30);

		// draw order
		systems.add(sparks);
		systems.add(smoke);
		systems.add(flame);
		systems.add(pollution);
		systems.add(coals);
		systems.add(fireflies);

		grass.add(new Point2D.Float(640, 640));
		grass.add(new Point2D.Float(0, 640));
		for (int i = 0; i <= width; i += 5)
		{
			grass.add(new Point2D.Float(i, 520 + noise(i) * 5));
		}
		grass.add(new Point2D.Float(640, 640));
	}
	
	float getRadians(float degrees)
	{
		return -(float) (degrees * Math.PI / 180);
	}

	public void draw()
	{
		background(bgColor);

		pushStyle();
		noStroke();
		fill(30, 130, 76);
		beginShape();
		for (Point2D.Float loc : grass)
		{
			vertex(loc.x, loc.y);
		}
		endShape();
		popStyle();

		for (PSystem system : systems)
		{
			system.draw();
		}
		
		pushStyle();

		stroke(210, 215, 211);
		strokeWeight(3);
		fill(236, 240, 241);
		ellipse(100, 100, 75, 75);

		popStyle();

	}

	public void keyPressed()
	{
		if (key == ' ')
		{
			exit();
		}
	}
}