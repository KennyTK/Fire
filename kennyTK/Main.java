package kennyTK;

import java.util.ArrayList;

import processing.core.PApplet;

public class Main extends PApplet
{
	int bgColor = color(34, 49, 63);

	PSystem flame;
	PSystem smoke;
	PSystem sparks;
	PSystem fireflies;

	ArrayList<PSystem> systems;

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

		flame = new PSystem(this, width / 2, height / 2, 0, 0, 0, 0, 0, 0, 500, 500, 5, 4, color(150, 40, 27, 100), 1000, 60, 30);
		smoke = new PSystem(this, width / 2, height / 2, 0, 0, 0, 0, 0, 0, 100, 100, 10, 10, color(108, 122, 137, 100), 30, 120, 30);
		sparks = new PSystem(this, width / 2, height / 2, 0, 0, 0, 0, 0, 0, 100, 200, 5, 10, color(243, 156, 18, 100), 5, 240, 60);
		fireflies = new PSystem(this, width / 2, height / 2, 1000, 0, 0, 0, 0, 0, 100, 200, 5, 10, color(232, 126, 4, 100), 20, 240, 60);

		// the leading int is where it sits in the draw order
		systems.add(0, flame);
		systems.add(1, smoke);
		systems.add(2, sparks);
		systems.add(3, fireflies);
	}

	public void draw()
	{
		background(bgColor);

		for (PSystem system : systems)
		{
			system.draw();
		}
	}

	public void keyPressed()
	{
		if (key == ' ')
		{
			exit();
		}
		if (key == 'a')
		{

		}
		if (key == 's')
		{
		}
		if (key == 'd')
		{
		}
		if (key == 'f')
		{

		}
	}
}