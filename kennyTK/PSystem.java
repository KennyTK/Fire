package kennyTK;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PVector;

public class PSystem
{
	private PApplet p;

	private PVector loc;

	private float vel, velMin, velMax;

	private float acc, accMin, accMax;

	private float spreadX, spreadY;

	private float size, spreadSize;

	private int lifeSpan, spreadLifeSpan, particleMax;

	private int color;

	private ArrayList<Particle> particles;

	PSystem(PApplet p, float x, float y,float vel, float velMin, float velMax, float acc, float accMin, float accMax, float spreadX, float spreadY, float size, float spreadSize, int color, int particleMax, int lifeSpan, int spreadLifeSpan)
	{
		this.p = p;
		
		loc = new PVector(x, y);
		
		this.vel = vel;
		this.velMin = velMin;
		this.velMax = velMax;
		
		this.acc = acc;
		this.accMin = accMin;
		this.accMax = accMax;

		this.spreadX = spreadX;
		this.spreadY = spreadY;

		this.size = size;
		this.spreadSize = spreadSize;

		this.lifeSpan = lifeSpan;
		this.spreadLifeSpan = spreadLifeSpan;

		this.color = color;

		this.particleMax = particleMax;

		particles = new ArrayList<Particle>();
	}

	void draw()
	{
		while (particles.size() < particleMax)
		{
			particles.add(new Particle(p, loc.x + p.random(-spreadX, spreadX), loc.y + p.random(-spreadY, spreadY), 10, 10, size + p.random(-spreadSize, spreadSize), color,
					(int) (lifeSpan + p.random(-spreadLifeSpan, spreadLifeSpan))));
		}

		for (int i = particles.size() - 1; i >= 0; i--)
		{
			Particle p = particles.get(i);

			p.draw();

			if (p.getLifeSpan() <= 0)
			{
				particles.remove(i);
			}
		}
	}
}
