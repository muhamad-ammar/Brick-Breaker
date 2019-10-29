import javax.swing.JFrame;

public class Main {

	public static void main(String[] args)
	{
		
		// Objects of Play classes
		Play play = new Play();
		
		//JFrame creating
		JFrame frame = new JFrame();
		frame.setBounds(200,10, 700 , 750);
		frame.setTitle("Brick Breaker");
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
		
		// Components in JFrame
		frame.add(play);
	}

}
