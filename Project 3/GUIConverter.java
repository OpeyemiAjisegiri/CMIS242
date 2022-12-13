/**
 * Author: Opeyemi Ajisegiri
 * Class: CMIS 242, Intermediate Programming
 * Project: Assignment 3: GUI & Polymorphism
 * Date: April 25th, 2021
 * File: GUIConverter Class and Main Function
 * Purpose:  Creates a Graphic User Interface through which the user inputs the 
 * 				temperature or distance to be converted and outputs the converted result. 
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;


public class GUIConverter{
	/*	Declaring class attributes and global parameters
	 * 	for the user interface.	*/
	static JPopupMenu DCPopup, TCPopup;

	/*	Constructor: creates and makes interface visible to the user*/
	public GUIConverter() {
		/*	Creating a window and windows container	*/
		JFrame window = new JFrame("Welcome To Converter");
		JPanel content = new JPanel();
		content.setLayout(new BorderLayout());

        final JLabel label = new JLabel();          
        label.setHorizontalAlignment(JLabel.CENTER);  
        label.setSize(400,100);
		
        /*	Creating and Laying out buttons [contents in container] */
		JButton DCButton = new JButton("Distance Converter");
		DCButton.setSize(250, 200);
		content.add(DCButton);
		JButton TCButton = new JButton("Temperature Converter");
		TCButton.setLocation(250, 200);
		content.add(TCButton, BorderLayout.LINE_END);
		JButton ExitButton = new JButton("Exit");
		ExitButton.setSize(500, 200);
		content.add(ExitButton, BorderLayout.PAGE_END);
		
		/* Creating pages to display when buttons are clicked*/
        JOptionPane DistanceOption = new JOptionPane(); 
        JOptionPane TempOption = new JOptionPane(); 

        /*	Adding listeners to Distance Button and accepting input 
         * 	to convert through the DistanceConverter class	*/
        DCButton.addMouseListener(new MouseAdapter() {
        	public void mouseClicked(MouseEvent e) {
        		String input = JOptionPane.showInputDialog(DistanceOption, "Input Distance in Miles to convert.");
        		int Distance = Integer.parseInt(input);
        		DistanceConverter DConversion = new DistanceConverter(Distance);
        		double kiloMetres = DConversion.Convert();
        	    JOptionPane.showMessageDialog(null, Distance +"miles equals "  + kiloMetres);
        	}
        });
        
        /*	Adding listeners to Temperature Button and accepting input 
         * 	to convert through the TemperatureConverter class	*/
        TCButton.addMouseListener(new MouseAdapter() {
        	public void mouseClicked(MouseEvent e) {
        		String input = JOptionPane.showInputDialog(TempOption, "Input Temperature in Farenheit to convert.");
        		int Temperature = Integer.parseInt(input);
        		TemperatureConverter DConversion = new TemperatureConverter(Temperature);
        		double Celsius = DConversion.Convert();
        	    JOptionPane.showMessageDialog(null, Temperature +"F equals "  + Celsius);
        	}
        }); 
        
        /*	Exiting program if the exit button is clicked on	*/
        ExitButton.addMouseListener(new MouseAdapter() {
        	public void mouseClicked(MouseEvent e) {
        		System.exit(0);
        	}
        });
		
        /*	Making window and content visible	*/
		window.setContentPane(content);
		window.setLocation(150, 150);
	    window.setSize(500, 300);
	    window.setVisible(true);

	}
	
	/*	Main Function	*/
	public static void main(String[] args) {
		
		/*	Creating and instantiating the User Interface	*/
		new GUIConverter();
	
	}
}
