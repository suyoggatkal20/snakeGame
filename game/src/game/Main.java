package game;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

class Main{

	
	public static void main(String args[])
	{
		JFrame f=new JFrame("SNAKE");
		f.setBounds(600,120,428,500);
		f.setResizable(false);
		f.setVisible(true);
		f.areFocusTraversalKeysSet(JFrame.EXIT_ON_CLOSE);
		f.add(new Play());
		
		
	}
}
