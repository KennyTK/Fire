package kennyTK;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PVector;

public class Particle
{
	private PApplet p;

	private PVector loc;
	private PVector vel;
	private PVector acc;

	private float size;

	private int color;

	private int lifeSpan;

	public Particle(PApplet p, float x, float y, float vel, float acc, float size, int color, int lifeSpan)
	{
		loc = new PVector(x, y);
		this.p = p;
		this.size = size;
		this.color = color;
		this.lifeSpan = lifeSpan;
	}

	private void calc()
	{
		// vel.add(acc);
		// loc.add(vel);
	}

	public void draw()
	{
		calc();

		p.pushStyle();
		p.noStroke();
		
		p.fill(p.red(color),p.green(color),p.blue(color),(float)lifeSpan);

		p.ellipseMode(PConstants.CENTER);
		
		p.ellipse(loc.x, loc.y, size, size);

		p.popStyle();
		
		lifeSpan--;
	}

	public PVector getLoc()
	{
		return loc;
	}

	public int getLifeSpan()
	{
		return lifeSpan;
	}
}
