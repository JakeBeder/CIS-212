

import java.awt.Dimension;



import javax.swing.JFrame;


// Some code was inspired by class examples
public class PaintClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

			Buttons PaintBox = new Buttons();
			PaintBox.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			PaintBox.pack();
			PaintBox.setVisible(true);
			
			DrawPoints Canvas = new DrawPoints();
			Canvas.setPreferredSize(new Dimension (500,500));
			PaintBox.add(Canvas);
			PaintBox.setVisible(true);
			PaintBox.pack();		
	}

}
