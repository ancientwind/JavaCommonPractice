package com.swingTest;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class UIMain extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3522894870730622099L;

	private JPanel contentPanel;
	private JLabel panelTitle;
	private JLabel content;
	private JButton confirm;
	
	private String panelTitle1;
	
	public UIMain(){
		this.setTitle("UI Swing");
		this.setSize(300, 200);
		this.setResizable(false);
		this.setVisible(false);
		this.setLayout(new BorderLayout());
		initUI();
//		this.setContentPane(contentPanel);
		this.add(contentPanel, BorderLayout.CENTER);
	}
	
	public void initUI(){
		contentPanel = new JPanel();
		panelTitle1 = "Common Panel";
//		contentPanel.setBorder(BorderFactory.createTitledBorder(panelTitle1));
//		contentPanel.setBorder(BorderFactory.createEmptyBorder(0, 9, 0, 9));
		contentPanel.setBorder(BorderFactory.createLineBorder(Color.CYAN, 2));
		panelTitle =new JLabel("Panel");
		content = new JLabel("Hello Java UI!");
		confirm = new JButton("OK");
		
//		contentPanel.add(panelTitle);
		contentPanel.add(content);
		contentPanel.add(confirm);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame jf = new UIMain();
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);
	}

}
