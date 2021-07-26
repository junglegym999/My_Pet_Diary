package _0_base;

import java.awt.EventQueue;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

//전체 공통 프레임
public class Mainframe {

	public JFrame Mainframe = new JFrame("My Pet Diary");

	public Mainframe() {
		Mainframe.setLocation(400, 60);
		Mainframe.setSize(400, 600);
		Mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Mainframe.getContentPane().setLayout(null);
	}
	
	public JFrame getMainframe() {
		return Mainframe;
	}

	public void setMainframe(JFrame Mainframe) {
		this.Mainframe = Mainframe;
	}
}
