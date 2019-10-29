import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

public class Bricks {
	private boolean bricks[][];
	private boolean bricks1[][];
	private int brickHeight;
	private int brickWidth;
	private int inRow;
	public int getInRow() {
		return inRow;
	}

	public void setInRow(int inRow) {
		this.inRow = inRow;
	}

	public int getInCol() {
		return inCol;
	}

	public void setInCol(int inCol) {
		this.inCol = inCol;
	}

	private int inCol = 3;
		
	public boolean[][] getBricks() {
		return bricks;
	}

	public void setBricks() 
	{
		bricks = new boolean[inRow][inCol];
		
		for(int x = 0; x < inRow; x++)
		{
			for(int y = 0; y < inCol; y++)
				{
					bricks[x][y] = true;
				}
		}
	}

	public int getBrickHeight() {
		return brickHeight;
	}

	public void setBrickHeight(int brickHeight) {
		this.brickHeight = brickHeight;
	}

	public int getBrickWidth() {
		return brickWidth;
	}

	public boolean[][] getBricks1() {
		return bricks1;
	}

	public void setBricks1() {
		
		bricks1 = new boolean[inRow][inCol];
		for(int x = 0; x < inRow; x++)
		{
			for(int y = 0; y < inCol; y++)
				{
					bricks1[x][y] = true;
				}
		}
	}

	public void setBrickWidth(int brickWidth) {
		this.brickWidth = brickWidth;
	}

	public void drawBricks(Graphics2D g)
	{
		
	}
	
}
