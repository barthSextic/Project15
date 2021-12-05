package edu.mtc.egr281.project15;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class ColorSampler extends JFrame implements ActionListener {

	private static final long serialVersionUID = 3462706482435681331L;
	private JTextField messageBox;
	private JButton showColor;
	private Container pane;
	private Color c;
	private boolean check;
	
	public ColorSampler() {
		super();
		this.setTitle("Rick Howell : : : Project 15");
		this.setSize(400, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pane = this.getContentPane();
		this.setLayout(new FlowLayout());
		this.pane.setBackground(Color.WHITE);
		// textfield to enter color
		this.messageBox = new JTextField(31);
		this.pane.add(this.messageBox);
		// input String -> object of Color class (getColor)
		// will call UnKnownColorException
		
		// "Show Me the Color" Button
		this.showColor = new JButton("Show Me the Color");
		this.showColor.addActionListener(this);
		this.pane.add(this.showColor);
		// if the GUI doesn't know the color>
		// change textfield to Unknown Color!"
		// change background color to white
		
	} // constructor
	
	private void getColor(String input) throws UnKnownColorException {
		// throws exception here
		this.c = null;
		this.check = true;
		switch(input) {
			case "BLACK": c = Color.BLACK;
				break;
			case "BLUE": c = Color.BLUE;
				break;
			case "CYAN": c = Color.CYAN;
				break;
			case "DARK_GRAY": c = Color.DARK_GRAY;
				break;
			case "GRAY": c = Color.GRAY;
				break;
			case "GREEN": c = Color.GREEN;
				break;
			case "LIGHT_GRAY" : c = Color.LIGHT_GRAY;
				break;
			case "MAGENTA" : c = Color.MAGENTA;
				break;
			case "ORANGE" : c = Color.ORANGE;
				break;
			case "PINK" : c = Color.PINK;
				break;
			case "RED" : c = Color.RED;
				break;
			case "WHITE" : c = Color.WHITE;
				break;
			case "YELLOW" : c = Color.YELLOW;
				break;
			default: this.check = false;
				break;
		} // switch
		if (!this.check) {
			throw new UnKnownColorException("Color not found");
		} // if
	} // get color

	@Override
	public void actionPerformed(ActionEvent e) {
		
		try {
			getColor(this.messageBox.getText().toUpperCase());
			this.pane.setBackground(this.c);
		} catch (UnKnownColorException uce) {
			System.out.println(uce);
			this.pane.setBackground(Color.WHITE);
			this.messageBox.setText("Unknown Color!");
		} finally {
			System.out.println("Check Complete");
		} // end try catch bloque
	} // action performed
	
} // end class
