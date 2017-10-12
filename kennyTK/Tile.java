package kennyTK;

import java.math.RoundingMode;
import java.text.DecimalFormat;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PVector;

public class Tile
{
	private PApplet p;

	private PVector loc;

	private float food;
	private float size;
	private float halfSize;

	private DecimalFormat df;

	private boolean isHighlighted;

	public Tile(PApplet p, float x, float y, float size, float food)
	{
		loc = new PVector(x, y);

		this.p = p;

		this.food = food;
		this.size = size;
		this.halfSize = size / 2;

		df = new DecimalFormat("##.#");
		df.setRoundingMode(RoundingMode.DOWN);

		isHighlighted = false;
	}

	public void draw()
	{
		p.pushStyle();
		p.strokeWeight(2);
		p.stroke(100);
		
		if (isHighlighted)
		{
			p.fill(255, 210, 210);
			isHighlighted = false; // reset the hover check
		}
		else
			p.fill(food / 2, food * 2, food / 2);
		
		p.rect(loc.x, loc.y, size, size);

		p.popStyle();
	}

	public void showStats()
	{
		p.fill(0, 255, 0);
		p.stroke(0, 0, 255);
		p.rect(loc.x - 2, loc.y - 2, 4, 4);

		p.fill(255, 0, 0);
		p.textSize(12);

		p.textAlign(PConstants.CENTER);

		p.text(df.format(food), loc.x, loc.y + halfSize / 2);
	}

	public PVector getLoc()
	{
		return loc;
	}

	public void setFood(float food)
	{
		this.food = food;
	}

	public void setHighlighted(boolean isHighlighted)
	{
		this.isHighlighted = isHighlighted;
	}
}
