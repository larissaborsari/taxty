package Texty;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class TextEditor extends JFrame implements ActionListener {
	
	JTextArea textArea;
	JScrollPane scrollPane;
	JSpinner fontSizeSpinner;
	JLabel fontLabel;
	JButton fontColorButton;
	JComboBox fontBox;


	TextEditor(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Texty");
		this.setSize(750,750);
		this.setLayout(new FlowLayout());
		this.setLocationRelativeTo(null); //makes the window open in the middle of the screen
		
		textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		textArea.setFont(new Font("Arial", Font.PLAIN, 16));
		
		scrollPane = new JScrollPane(textArea);
		scrollPane.setPreferredSize(new Dimension(715,715));
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		fontLabel = new JLabel("Size: ");
		
		fontSizeSpinner = new JSpinner();	
		fontSizeSpinner.setPreferredSize(new Dimension(50,25));
		fontSizeSpinner.setValue(16);
		fontSizeSpinner.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				
				textArea.setFont(new Font(textArea.getFont().getFamily(),Font.PLAIN,(int) fontSizeSpinner.getValue()));
				
			}
			
		});
		
		fontColorButton = new JButton("Color: ");
		fontColorButton.addActionListener(this);
		
		String[] fonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();		
		
		fontBox = new JComboBox(fonts);
		fontBox.addActionListener(this);
		fontBox.setSelectedItem("Arial");
		
		this.add(fontLabel);
		this.add(fontSizeSpinner);
		this.add(fontColorButton);
		this.add(fontBox);
		this.add(scrollPane);
		this.setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == fontColorButton) {
			JColorChooser colorChooser = new JColorChooser();
			
			Color color = colorChooser.showDialog(null, "Choose a color",Color.black);
			
			textArea.setForeground(color);
		}
		
	}
	
	

}
