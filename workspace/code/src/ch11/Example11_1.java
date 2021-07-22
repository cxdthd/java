package ch11;

import java.awt.Color;
import java.awt.Container;

import javax.swing.JFrame;

public class Example11_1 {
	public static void main(String[] args) {
		JFrame jFrame = new JFrame();
		Container con = jFrame.getContentPane();
		jFrame.setBackground(Color.gray);
		jFrame.setBounds(60, 100, 188, 108);
		jFrame.setVisible(true);
	}
}
