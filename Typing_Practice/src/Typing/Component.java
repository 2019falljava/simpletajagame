package Typing;

import javax.swing.JComponent;
import javax.swing.JTextField;

import java.awt.*;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Component extends JComponent implements ActionListener, KeyListener{
	
	public int speed;	//글자가 내려오는 속도
	
	private JButton startButton, rankButton, exitButton, easyButton, normalButton, hardButton, startButton2;
	public static ImageIcon nameIcon,numberIcon,background2, background, title, startIcon, rankIcon, exitIcon,
	easyIcon, easyIconSelected, normalIcon, normalIconSelected, hardIcon, hardIconSelected,inputIcon;
	
	private JTextField inputUserName, inputUserNumber, inputText;
	private String userName, userNumber;
	private JPanel userNameIcon, userNumberIcon;
	private JLabel numLabel, nameLabel,tilteLabel, inputLabel,inputNameLabel,inputNumLabel,javaTeamLabel;
	public Component() {
		setSize(800, 596); // 패널 사이즈를 800x600으로 지정한다
		setLayout(null); // 위치를 절대값 위치로 지정하기 때문에, 레이아웃을 null로 지정한다

		/***  이미지 연결 ***/
		background = new ImageIcon("image/background.png");
		
		title = new ImageIcon("image/title.png");
		startIcon = new ImageIcon("image/start.png");
		rankIcon = new ImageIcon("image/rank.png");
		exitIcon = new ImageIcon("image/exit.png");
		easyIcon = new ImageIcon("image/easy.png");
		normalIcon = new ImageIcon("image/normal.png");
		hardIcon = new ImageIcon("image/hard.png");
		easyIconSelected = new ImageIcon("image/easy_selected.png");
		normalIconSelected = new ImageIcon("image/normal_selected.png");
		hardIconSelected = new ImageIcon("image/hard_selected.png"); 
		nameIcon = new ImageIcon("image/name.png");
		numberIcon = new ImageIcon("image/number.png");
		inputIcon= new ImageIcon("image/input.png");

		tilteLabel = new JLabel(title);
		tilteLabel.setOpaque(false);
		tilteLabel.setBounds(120, 20, 500, 250);
		add(tilteLabel);
		
		inputLabel = new JLabel(inputIcon);
		inputLabel.setBounds(250, 493, 100, 58);
		inputLabel.setOpaque(true);
		add(inputLabel);
		inputLabel.setVisible(false);
		
		inputNameLabel = new JLabel(inputIcon);
		inputNameLabel.setBounds(0, 4, 50, 70);
		inputNameLabel.setOpaque(true);
		add(inputNameLabel);
		inputNameLabel.setVisible(false);
		
		inputNumLabel = new JLabel(inputIcon);
		inputNumLabel.setBounds(0, 14, 50, 70);
		inputNumLabel.setOpaque(true);
		add(inputNumLabel);
		inputNumLabel.setVisible(false);

		javaTeamLabel = new JLabel("java team");
		javaTeamLabel.setBounds(750, 550, 50, 46);
		javaTeamLabel.setOpaque(true);
		add(javaTeamLabel);
		javaTeamLabel.setVisible(false);
		
		/***  버튼 추가  ***/
		easyButton = new JButton(easyIcon);
		easyButton.setOpaque(false);
		easyButton.setBounds(270, 260, 52, 70);
		add(easyButton);
		easyButton.addActionListener(this);
		
		normalButton = new JButton(normalIcon);
		normalButton.setOpaque(false);
		normalButton.setBounds(350, 260, 52, 70);
		add(normalButton);
		normalButton.addActionListener(this);
		
		hardButton = new JButton(hardIcon);
		hardButton.setOpaque(false);
		hardButton.setBounds(430, 260, 52, 70);
		add(hardButton);
		hardButton.addActionListener(this);
		
		startButton = new JButton(startIcon);
		startButton.setOpaque(false);
		startButton.setBounds(275, 340, 200, 50);
		add(startButton);
		startButton.addActionListener(this);
		
		rankButton = new JButton(rankIcon);
		rankButton.setOpaque(false);
		rankButton.setBounds(275, 400, 200, 50);
		add(rankButton);
		
		exitButton = new JButton(exitIcon);
		exitButton.setOpaque(false);
		exitButton.setBounds(275, 460, 200, 50);
		add(exitButton);
		exitButton.addActionListener(this);
		
		startButton2 = new JButton(startIcon);			//두번째 startButton
		startButton2.setOpaque(false);
		startButton2.setBounds(275, 360, 200, 50);
		add(startButton2);
		startButton2.addActionListener(this);
		startButton2.setVisible(false);
		

		
	}


	
	/***  버튼 클릭했을 때  ***/
	public void actionPerformed(ActionEvent e) {
		
		/***  난이도 버튼  ***/
		if(e.getSource() == easyButton) {
			easyButton.setIcon(easyIconSelected);
			normalButton.setIcon(normalIcon);
			hardButton.setIcon(hardIcon);
		}
		else if(e.getSource() == normalButton) {
			easyButton.setIcon(easyIcon);
			normalButton.setIcon(normalIconSelected);
			hardButton.setIcon(hardIcon);
		}
		else if(e.getSource() == hardButton) {
			easyButton.setIcon(easyIcon);
			normalButton.setIcon(normalIcon);
			hardButton.setIcon(hardIconSelected);
		}
		
		
		/***  메인 버튼  ***/
		if(e.getSource() == startButton) {	//startButton 클릭하면
			inputID();
			
		}
		
		if(e.getSource() == exitButton) {	//exitButton 클릭하면
			System.exit(0);		//종료
		}
		
		if(e.getSource() == startButton2) {
			userName = inputUserName.getText();			//텍스트필드에 입력한 값을
			userNumber = inputUserNumber.getText();		//String 변수에 저장
			nameLabel = new JLabel(userName);
			numLabel = new JLabel(userNumber);
			gameStart();		
			System.out.println("이름, 학번 인풋함");
		}
	}
	private void gameStart() {//시작하기 버튼 눌렀을때
		
		inputText = new JTextField(2);
		inputText.addKeyListener(this); // 텍스트필드에 키 이벤트 추가(엔터)
		inputText.setBounds(360, 493, 150, 58);
		inputText.setOpaque(true);
		inputText.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		add(inputText); // 답을 입력하는 텍스트필드를 투명으로 만들어서 추가한다
		

		add(numLabel); // 학번 JLabel을 추가한다
		add(nameLabel); // 학생이름 JLabel을 추가한다
		numLabel.setBounds(105, 4, 100, 60);
		nameLabel.setBounds(110, 34, 100, 60);
		
		startButton2.setVisible(false); // 시작 버튼 안보이게
		//이름,학번 안보이게
		userNameIcon.setVisible(false);
		userNumberIcon.setVisible(false);
		inputUserName.setVisible(false);
		inputUserNumber.setVisible(false);
		
		inputText.setVisible(true); // 답 입력창 보이게 함
		//난이도 버튼 안보익게
		easyButton.setVisible(false);
		normalButton.setVisible(false);
		hardButton.setVisible(false);
		tilteLabel.setVisible(false);
		background = new ImageIcon("image/background2.png"); // 배경 이미지를 두번째 이미지로 바꿈
		inputLabel.setVisible(true);
		inputNameLabel.setVisible(true);
		inputNumLabel.setVisible(true);
		javaTeamLabel.setVisible(true);
		
	}
	
	
	/***  이름, 번호 입력받기  ***/
	private void inputID() {
		
		/***  이미지 연결  ***/
		userNameIcon = new JPanel();
		JLabel nameIcon = new JLabel(new ImageIcon("image/name.png"));
		userNameIcon.add(nameIcon);
		userNameIcon.setBounds(245, 245, 160, 25);
		userNameIcon.setOpaque(false);
		add(userNameIcon);
		
		userNumberIcon = new JPanel();
		JLabel numberIcon = new JLabel(new ImageIcon("image/number.png"));
		userNumberIcon.add(numberIcon);
		userNumberIcon.setBounds(245, 295, 160, 25);
		userNumberIcon.setOpaque(false);
		add(userNumberIcon);
		

		
		/***  텍스트필드 생성  ***/
		inputUserName = new JTextField(20);
		inputUserName.setOpaque(true);
		inputUserName.setBounds(300, 240, 150, 40);
		add(inputUserName);
		
		inputUserNumber = new JTextField(20);	
		inputUserNumber.setOpaque(true);
		inputUserNumber.setBounds(300, 290, 150, 40);
		add(inputUserNumber);
		
		
		/***  나머지 버튼 설정  ***/
		startButton2.setVisible(true);		//보이게
		startButton.setVisible(false);		//안보이게
		rankButton.setVisible(false);
		exitButton.setVisible(false);
		easyButton.setVisible(false);
		normalButton.setVisible(false);
		hardButton.setVisible(false);
		tilteLabel.setVisible(true);
	
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == 10) { // 엔터가 눌리면
			
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	/***  배경화면 설정  ***/
	public void paintComponent(Graphics g) {
	
		g.drawImage(background.getImage(), 0, 0,null );	//배경화면 추가
		//g.drawImage(title.getImage(), 170, 20, null);	//타이틀 추가
		setOpaque(false);	 //그림을 표시하게 설정,투명하게 조절
        super.paintComponent(g);
	}
	
}