package kennyTK;

import processing.core.PApplet;

public class Board
{
	private PApplet p;
	private Point2D gridSize;
	private int tileSize;
	private Tile[][] panels;

	private boolean isShowingStats = false;

	Board(PApplet p, float tileSize)
	{
		this(p, (int) (p.width / tileSize), (int) (p.height / tileSize), (int) tileSize);
	}

	Board(PApplet p, int xy)
	{
		this(p, xy, xy, p.height / xy);
	}

	private Board(PApplet p, int width, int height, int tileSize)
	{
		this.p = p;
		gridSize = new Point2D(width, height);
		this.tileSize = tileSize;
		panels = new Tile[gridSize.getX()][gridSize.getY()];

		setup();
	}

	void setup()
	{
		for (int i = 0; i < gridSize.getX(); i++)
		{
			for (int j = 0; j < gridSize.getY(); j++)
			{
				panels[i][j] = new Tile(p, i * tileSize, j * tileSize, tileSize, p.random(50, 200));
			}
		}
	}

	void draw()
	{
		for (int i = 0; i < gridSize.getX(); i++)
		{
			for (int j = 0; j < gridSize.getY(); j++)
			{
				panels[i][j].draw();
			}
		}

		// if(isShowingStats)
		// panels[kenny.getBobX()][kenny.getBobY()].setHighlighted(true);
	}

	void setTileStats(boolean isShowingStats)
	{
		this.isShowingStats = isShowingStats;
	}

}
