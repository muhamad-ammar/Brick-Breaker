
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.Random;

public class Play extends LayOut 
{
	
	public void actionPerformed(ActionEvent e) 
	{
		if(cheatinitial && ballY >= 670)
		{
			ballX = sliderX + 40;
			ballY = sliderY-20;
			cheatinitial = false;
			ballMotionY = -1;
			initial = true;
			cheatPause = true;
			repaint();
		}
		else if(cheatPause) 
		{
			repaint();
		}
		else if(pause) 
		{
			repaint();
		}
		else if(start)
		{
			timer.start();
			repaint();
		
			//Ball motion
			ballX += ballMotionX;
			ballY += ballMotionY;
			
			if(ballX < 5)
				ballMotionX *= -1;
			if(ballY < 40)
				ballMotionY *= -1;
			if(ballX > 659)
				ballMotionX *= -1;
			if(cheata)
			{
				if(ballY >= sliderY + 15)
				{
					cheatinitial = true;
				}
			}
			if(!cheata)
			{
				if(ballY >= 710)
				{
					System.exit(0);
				}
			}
			
			//Collision with Slider
			if(new Rectangle(ballX,ballY,20,20).intersects(new Rectangle(sliderX-5, sliderY,100,10)) && ballY <= sliderY+1)
			{
				ballY = sliderY-20;
				ballMotionY *= -1;
//				if(ballMotionX < 4 && ballMotionX > -4)
//				{
//					speed += direction;
//					ballMotionX += direction;
//				}
			}
			else if(new Rectangle(ballX,ballY,20,20).intersects(new Rectangle(sliderX, sliderY,100,10)))
			{
				ballMotionX *= -1;
			}
			
			//Collision with Brick
			outer:
				for(int x = 0; x < brickObj.getInRow(); x++)
				{
					for(int y = 0; y < brickObj.getInCol(); y++) 
					{
						int brickWidth = brickObj.getBrickWidth();
						int brickHeight = brickObj.getBrickHeight();
						Rectangle brick = new Rectangle(x * brickWidth + 100, y * brickHeight + 100 , brickWidth, brickHeight);
						
						if(new Rectangle(ballX,ballY,20,20).intersects(brick))
							{
							if(brickObj.getBricks()[x][y])
							{
								if(new Rectangle(ballX,ballY,20,20).intersects(new Rectangle(x * brickWidth + 100 + brickWidth, y * brickHeight + 101 , 1, brickHeight - 2)) || new Rectangle(ballX,ballY,20,20).intersects(new Rectangle(x * brickWidth + 100, y * brickHeight + 101 , 1, brickHeight - 2)))
								{
									ballMotionX *= -1;
								}
								else if(new Rectangle(ballX,ballY,20,20).intersects(new Rectangle(x * brickWidth + 100 + brickWidth, y * brickHeight + 100 , brickWidth, 1)) || new Rectangle(ballX,ballY,20,20).intersects(new Rectangle(x * brickWidth + 100, y * brickHeight + 99 + brickHeight, brickWidth, 1)))
								{
									ballMotionY *= -1;
								}
//								if(brickObj.getBricks1()[x][y])
//								{
//									brickObj.getBricks()[x][y] = false;
//								}
								brickObj.getBricks()[x][y] = false;
								score += 5;
								totalBricks--;
							}
							break outer;
						}	
					}	
					
				}
		}
	}

	
	public void keyPressed(KeyEvent e) 
	{
		//Moving right
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) 
		{
			if(initial) 
			{
				initial = false;
				ballMotionX = 1;
				ballMotionY = -1;
			}
			else		
			{
				direction = 1;
			}
			
			start = true;
			
			sliderX +=50 ;
			if(sliderX >= 580)
			{
				sliderX = 580;
			}

			cheatPause = false;
			pause = false;
			pauseSymbol = 1000;
		}
		
		//Moving Left
		if(e.getKeyCode() == KeyEvent.VK_LEFT)
		{
			if(initial) 
			{
				initial = false;
				ballMotionX = -1;
				ballMotionY = -1;
			}
			else		
			{
				direction = -1;
			}
				
				
			start = true;

			sliderX -=50;
			if(sliderX <= 20)
			{
				sliderX = 10;
			}

			cheatPause = false;
			pause = false;
			pauseSymbol = 1000;
		}
		
		//Moving straight
		if(e.getKeyCode() == KeyEvent.VK_UP)
		{
			if(initial) 
			{
				initial = false;
				ballMotionX = 0;
				ballMotionY = -1;
			}
			else
			{
				direction = 0;
			}
			
			cheatPause = false;
			pause = false;
			pauseSymbol = 1000;
			start = true;
		}
		
		if(e.getKeyCode() == KeyEvent.VK_ESCAPE)
		{
			if(start)
			{
				if(pauseOnOff)
				{
					pause = true;
					pauseOnOff = false;
					pauseSymbol = 280;
				}
				else
				{
					pause = false;
					pauseOnOff = true;
					pauseSymbol = 1000;
				}
			}
			
			if(!start && !initial)
			{
					System.exit(0);
			}
		}
		
		if(e.getKeyCode() == KeyEvent.VK_C)
		{
			Random rand = new Random();
			cheatgen = rand.nextInt(4);
			cheatgen += 3;
			randgen = cheatgen;
		}
		
		if(e.getKeyCode() == KeyEvent.VK_H)
		{
			cheatgen *= 2;
		}
		
		if(e.getKeyCode() == KeyEvent.VK_E)
		{
			cheatgen += 14;			
		}
		
		if(e.getKeyCode() == KeyEvent.VK_A)
		{
			cheatgen /= 2;	
		}
		
		if(e.getKeyCode() == KeyEvent.VK_T)
		{
			cheatgen -= randgen;
			if(cheatgen == 7)
			{
				cheatOk = true;
			}
		}
		
		if(e.getKeyCode() == KeyEvent.VK_A)
		{
			cheata = true;
			cheatinitial = true;
		}
		
		if(e.getKeyCode() == KeyEvent.VK_B)
		{
			cheatb = true;
		}
		
		if(e.getKeyCode() == KeyEvent.VK_ENTER)
		{
			if(!start && !pause)
			{
				start = true;
				speed = 12;
				initial = true;
				score = 0;
				totalBricks = inRow * inCol;
				pause = false;
				pauseSymbol = 1000;
				pauseOnOff = true;
				sliderX = 300;
				ballX = 340;
				ballY = sliderY-20;
				ballMotionX = 0;
				ballMotionY = 0;
				cheata = false;
				cheatinitial = false;
				brickObj.setBricks();
			}
			if(pause)
			{
				start = true;
				pause = false;
				pauseOnOff = true;
				pauseSymbol = 1000;
			}
		}
	}


}
