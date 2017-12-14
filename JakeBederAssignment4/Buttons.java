import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Buttons extends JFrame {
	
	// Some code was inspired by class examples
	
	private final DrawPoints _drawPoints;
	
	public Buttons() {
		super("Buttons!");
		setLayout(new BorderLayout());
		
		_drawPoints = new DrawPoints();
		_drawPoints.setPreferredSize(new Dimension(500, 500));
		add(_drawPoints, BorderLayout.CENTER);
		
		JButton blackButton = new JButton("Black");
		blackButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				_drawPoints.setGlobalColor(Color.BLACK);
				
			}			
		});
		
		JButton greenButton = new JButton("Green");
		greenButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				_drawPoints.setGlobalColor(Color.green);	
				
			}			
		});
		
		JButton yellowButton = new JButton("Yellow");
		yellowButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				_drawPoints.setGlobalColor(Color.YELLOW);		
			}			
		});
		
		JButton grayButton = new JButton("Gray");
		grayButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				_drawPoints.setGlobalColor(Color.GRAY);		
			}			
		});
		

		JPanel buttonPanel = new JPanel(new GridLayout(4,1));
		buttonPanel.add(blackButton);
		buttonPanel.add(greenButton);
		buttonPanel.add(yellowButton);
		buttonPanel.add(grayButton);
		add(buttonPanel, BorderLayout.WEST);	
		
		
		JButton smallButton = new JButton("Small");
		smallButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				_drawPoints.setGlobalSize(15);		
			}			
		});
		
		JButton mediumButton = new JButton("Medium");
		mediumButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				_drawPoints.setGlobalSize(25);		
			}			
		});
		
		JButton largeButton = new JButton("Large");
		largeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				_drawPoints.setGlobalSize(35);		
			}			
		});
		
		JButton clearButton = new JButton("Clear");
		clearButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				_drawPoints.setClearPoints();		
			}			
		});
		
		
		JPanel buttonPanel2 = new JPanel(new GridLayout(4,1));
		buttonPanel2.add(smallButton);
		buttonPanel2.add(mediumButton);
		buttonPanel2.add(largeButton);
		buttonPanel2.add(clearButton);
		add(buttonPanel2, BorderLayout.EAST);
}
}