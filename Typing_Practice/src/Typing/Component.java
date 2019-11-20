package Typing;

import javax.swing.JComponent;
import javax.swing.JTextField;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class Component extends JComponent{
	
	public int speed;	//글자가 내려오는 속도
	
	private JButton startButton, rankButton, exitButton, easyButton, normalButton, hardButton;
	public ImageIcon background, title, startIcon, rankIcon, exitIcon, easyIcon, normalIcon, hardIcon;
	
	public Component() {
		
		/***  이미지 연결 ***/
		background = new ImageIcon("image/background.png");
		title = new ImageIcon("image/title.png");
		startIcon = new ImageIcon("image/start.png");
		rankIcon = new ImageIcon("image/rank.png");
		exitIcon = new ImageIcon("image/exit.png");
		easyIcon = new ImageIcon("image/easy.png");
		normalIcon = new ImageIcon("image/normal.png");
		hardIcon = new ImageIcon("image/hard.png");
		
		/***  버튼 추가  ***/
		easyButton = new JButton(easyIcon);
		easyButton.setOpaque(false);
		easyButton.setBounds(270, 260, 52, 70);
		add(easyButton);
		
		normalButton = new JButton(normalIcon);
		normalButton.setOpaque(false);
		normalButton.setBounds(350, 260, 52, 70);
		add(normalButton);
		
		hardButton = new JButton(hardIcon);
		hardButton.setOpaque(false);
		hardButton.setBounds(430, 260, 52, 70);
		add(hardButton);
		
		startButton = new JButton(startIcon);
		startButton.setOpaque(false);
		startButton.setBounds(275, 340, 200, 50);
		add(startButton);
		
		rankButton = new JButton(rankIcon);
		rankButton.setOpaque(false);
		rankButton.setBounds(275, 400, 200, 50);
		add(rankButton);
		
		exitButton = new JButton(exitIcon);
		exitButton.setOpaque(false);
		exitButton.setBounds(275, 460, 200, 50);
		add(exitButton);
		//exitButton.addActionListener(this);
		
	}

	public void paintComponent(Graphics g) {
		g.drawImage(background.getImage(), 0, 0, null);	//배경화면 추가
		g.drawImage(title.getImage(), 170, 20, null);	//타이틀 추가
		setOpaque(false);	 //그림을 표시하게 설정,투명하게 조절
        super.paintComponent(g);
	}
	
	public void action(ActionEvent e) {
		if(e.getSource() == exitButton) {
			System.exit(0);
		}
		
	}
}