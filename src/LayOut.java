import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.*;
import javax.swing.Timer;
import javax.swing.JPanel;

public class LayOut extends JPanel implements ActionListener,KeyListener 
{
	//Attributes For Game Play
	protected boolean start=false;
	protected Timer timer;
	protected int speed = 5;
	protected boolean initial = true;
	protected int score = 0;
	//Attributes For Bricks
	protected int inRow = 8;
	protected int inCol = 4;
	protected int totalBricks = inRow * inCol;
	//Attributes For Pause
	protected boolean pause = false;
	protected int pauseSymbol = 1000;
	protected boolean pauseOnOff = true;
	//Attributes For Slider
	protected int sliderX = 300;
	protected int sliderY = 650;
	//Attributes For Ball
	protected int ballX = sliderX + 40;
	protected int ballY = sliderY-20;
	protected int ballMotionX;
	protected int ballMotionY;
	protected int direction;
	//Attributes For Cheat
	protected boolean cheata = false;
	protected boolean cheatb = false;
	protected boolean cheatinitial = false;
	protected int cheatgen;
	protected int randgen;
	protected boolean cheatOk;
	protected boolean cheatPause = false;
	//Object For Bricks Class
	protected Bricks brickObj;
	
	
	//Constructor of LayOut
	public LayOut()
	{
		brickObj = new Bricks();
		brickObj.setInRow(inRow);
		brickObj.setInCol(inCol);
		brickObj.setBrickHeight(200/brickObj.getInCol());
		brickObj.setBrickWidth(500/brickObj.getInRow());
		brickObj.setBricks();
		brickObj.setBricks1();
		
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		timer = new Timer(speed,this);
		timer.start();  
	}
	
	//Layout section
	public void paint(Graphics g)
	{
		//Window BackGround color
		g.setColor(Color.black);
		g.fillRect(0, 0, 700, 720);
		
		//Window Border
		g.setColor(Color.red);
		g.fillRect(5, 706, 673, 5);
		g.setColor(Color.yellow);
		g.fillRect(0, 0, 5, 720);
		g.fillRect(0, 0, 700, 40);
		g.fillRect(679, 0, 5, 720);
		
		//Score & No.of bricks
		g.setColor(Color.black);
		g.fillRect(20, 5, 200, 30);
		g.fillRect(470, 5, 200, 30);
		g.setColor(Color.white);
		g.setFont(new Font("calibri",Font.BOLD,20));
		g.drawString("SCORE: " +score, 45, 27);
		g.drawString("BRICKS: " +totalBricks, 495, 27);
		
		//Slider
		g.setColor(Color.red);
		g.fillOval(sliderX, sliderY, 10, 10);
		g.fillOval(sliderX+90, sliderY, 10, 10);
		g.setColor(Color.DARK_GRAY);
		g.fillRect(sliderX+25, sliderY, 50, 10);
		g.setColor(Color.GRAY);
		g.fillRect(sliderX+5, sliderY, 20, 10);
		g.fillRect(sliderX+75, sliderY, 20, 10);
		
		//Bricks
		for(int x = 0; x < inRow; x++)
		{
			for(int y = 0; y < inCol; y++) 
			{
				if(brickObj.getBricks()[x][y])
				{
					g.setColor(Color.white);
					g.fillRect(x * brickObj.getBrickWidth() + 100, y * brickObj.getBrickHeight() + 100 , brickObj.getBrickWidth(), brickObj.getBrickHeight());
					((Graphics2D) g).setStroke(new BasicStroke(3));
					g.setColor(Color.black);
					g.drawRect(x * brickObj.getBrickWidth() + 100, y * brickObj.getBrickHeight() + 100 , brickObj.getBrickWidth(), brickObj.getBrickHeight());
				}
			}	
		}
		
		//Ball
		g.setColor(Color.yellow);
		g.fillOval(ballX, ballY, 20, 20);
		if(ballY > 700 || totalBricks == 0) 
		{
			start = false;
			ballMotionX = 0;
			ballMotionY = 0;
			g.setColor(Color.ORANGE);
			g.setFont(new Font("calibri",Font.BOLD,30));
			g.drawString("GAME OVER...YOUR SCORE WAS: " +score, 125, 300);
		}
		if(ballY > 700 || totalBricks == 0 || (pause) ) 
		{
			start = false;
			g.setColor(Color.red);
			g.setFont(new Font("calibri",Font.BOLD,20));
			g.drawString("PRESS ENTER TO RESTART...", 225, 330);
			g.setFont(new Font("calibri",Font.BOLD,20));
			g.drawString("OR ESCAPE TO EXIT...", 245, 350);
		}
		
		//Pause
		g.setColor(Color.darkGray);
		g.fillRect(pauseSymbol, 180, 20, 100);
		g.fillRect(pauseSymbol+70, 180, 20, 100);
		
		g.dispose();
	}

	@Override
	public void keyPressed(KeyEvent e){}
	@Override
	public void actionPerformed(ActionEvent e) {}	
	@Override
	public void keyTyped(KeyEvent e) {}
	@Override
	public void keyReleased(KeyEvent e) {}

}
