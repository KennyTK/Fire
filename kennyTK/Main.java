package kennyTK;

import processing.core.PApplet;

public class Main extends PApplet
{
	int bgColor = color(10, 100, 100);

	Kenny kenny;
	Board board;

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

		int tileSize = 32;

		kenny = new Kenny(this, width / 2, height / 2, 5, tileSize);

		board = new Board(this, (int) tileSize);

		smooth();
	}

	public void draw()
	{
		background(bgColor);

		board.draw();

		kenny.draw();
	}

	public void keyPressed()
	{
		if (key == ' ')
		{
			exit();
		}
		if (key == 'w')
		{
			kenny.moveUp();
		}
		if (key == 's')
		{
			kenny.moveDown();
		}
		if (key == 'a')
		{
			kenny.moveLeft();
		}
		if (key == 'd')
		{
			kenny.moveRight();
		}
		if (key == 'g')
		{
			// toggle automatic (atleast for testing)
		}

		// if (keyCode == SHIFT)
		// {
		// modif = true;
		// System.out.println("True");
		// }
		//
		// if (keyCode == CONTROL)
		// {
		// board.setTileStats(true);
		// }

		// if (key == 'f' && showTileStats == true)
		// {
		// showTileStats = false;
		// }
		// else if (key == 'f')
		// {
		// showTileStats = true;
		// }

		// System.out.println("Key: " + key);
		// System.out.println("keyCode: " + keyCode);
	}

	public void keyReleased()
	{
		// if (keyCode == SHIFT && modif == true)
		// {
		// modif = false;
		// System.out.println("False");
		// }
	}

	public void mousePressed()
	{
		// if (modif)
		// {
		// kenny.moveTo(mouseX, mouseY);
		// }
	}
}