package kennyTK;

import processing.core.PApplet;
import processing.core.PVector;

public class Kenny
{
	PApplet p;

	PVector loc;

	float tileSize;

	float r;

	public Kenny(PApplet p, float x, float y, float r, float tileSize)
	{
		this.p = p;
		this.loc = new PVector(x, y);
		this.r = r;
		this.tileSize = tileSize;
	}

	public void draw()
	{
		p.fill(255);
		p.stroke(255, 0, 0);
		p.ellipse(loc.x, loc.y, r, r);
	}

	public void showStats()
	{
		p.fill(200, 200, 200);
		p.stroke(0);

		// p.rect(loc.x + 10, loc.y - 90, 80, 80);

		p.fill(255, 50, 50);
		p.textSize(15);

		// p.text("Bob is here", loc.x + 15, loc.y - 85, 80, 80);

		p.stroke(0, 0, 255);
		p.strokeWeight(2);

		// p.line(x1, y1, x2, y2);

		// if (showStats)
		// {
		// kenny.showStats();
		// kenny.drawLineTo(panels[1][2].getLoc().x, panels[1][2].getLoc().y);
		// }
	}

	float rate = 3;

	public void moveUp()
	{
		if (loc.y > 0 + rate)
			loc.y -= rate;
	}

	public void moveDown()
	{
		if (loc.y < p.height - rate)
			loc.y += rate;
	}

	public void moveLeft()
	{
		if (loc.x > 0 + rate)
			loc.x -= rate;
	}

	public void moveRight()
	{
		if (loc.x < p.width - rate)
			loc.x += rate;
	}

	public void moveTo(float x, float y)
	{
		loc.x = x;
		loc.y = y;
	}

	public int getGridX(float x)
	{
		return (int) ((x - (x % tileSize)) / tileSize);
	}

	public int getGridY(float y)
	{
		return (int) ((y - (y % tileSize)) / tileSize);
	}

	public int getKennyX()
	{
		return getGridX(loc.x);
	}

	public int getKennyY()
	{
		return getGridY(loc.y);
	}

	// a getCenter() so a line can be drawn between bob and the center

	@SuppressWarnings("unused")
	private PVector getCenter(PVector point)
	{
		return new PVector(0, 0);
	}

	void drawLineTo(float x, float y)
	{
		p.pushStyle();
		p.stroke(255, 0, 0);
		p.strokeWeight(1);

		p.line(loc.x, loc.y, x, y);
		p.popStyle();
	}

}
