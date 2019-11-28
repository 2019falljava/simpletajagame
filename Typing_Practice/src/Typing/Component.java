package Typing;

import javax.swing.JComponent;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Component extends JComponent implements ActionListener, KeyListener{
   Words problemCreator = new Words();					//문제배열 만들어주는 클래스
   static WordRaining rain = new WordRaining();				//글자 떨어지게 하는 클래스
   static Time timer = new Time();								//시간을 체크하는 클래스
   
   public static int speed = 1500;   //글자가 내려오는 속도
   public static JLabel[] problems = new JLabel[10];	//문제(떨어지는 문자들) 배열
   public static JLabel[] lifeLabel = new JLabel[3];	//3개의 생명
   
   private JButton startButton, rankButton, exitButton, easyButton, normalButton, hardButton, startButton2;
   private static ImageIcon nameIcon,numberIcon,background2, background, title, startIcon, rankIcon, exitIcon,
   easyIcon, easyIconSelected, normalIcon, normalIconSelected, hardIcon, hardIconSelected, inputIcon, lifeIcon;
   
   private JTextField inputUserName, inputUserNumber, inputText;
   private String userName, userNumber;
   private JPanel userNameIcon, userNumberIcon;
   private JLabel numLabel, nameLabel, tilteLabel, inputLabel, inputNameLabel, inputNumLabel, javaTeamLabel;
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
      lifeIcon = new ImageIcon("image/life.png");
      inputIcon= new ImageIcon("image/input.png");

      /***  라벨 추가  ***/
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
      
      timer.time.setBounds(675, 470, 110, 90);
      timer.time.setForeground(Color.BLUE);		//배경색 변경
      timer.time.setOpaque(true);
      timer.time.setFont(new Font("", Font.BOLD, 80));	//글꼴 변경
      add(timer.time);
      timer.time.setVisible(false);
      
      for(int i=0; i<3; i++) {		//라이프 3개
    	  lifeLabel[i] = new JLabel(lifeIcon);
    	  lifeLabel[i].setBounds(i*60+5, 480, 55, 70);
    	  lifeLabel[i].setOpaque(true);
    	  add(lifeLabel[i]);
    	  lifeLabel[i].setVisible(false);
      }
      
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
      
      startButton2 = new JButton(startIcon);         //두번째 startButton
      startButton2.setOpaque(false);
      startButton2.setBounds(275, 360, 200, 50);
      add(startButton2);
      startButton2.addActionListener(this);
      startButton2.setVisible(false);

      
      problemCreator.create();		//problemCreator 클래스 내의(Word.java) create메소드 실행
      problemCreator.shuffle();		//shuffle메소드 실행
   }


   
   /***  버튼 클릭했을 때  ***/
   public void actionPerformed(ActionEvent e) {
      
      /***  난이도 버튼  ***/
      if(e.getSource() == easyButton) {
         easyButton.setIcon(easyIconSelected);
         normalButton.setIcon(normalIcon);
         hardButton.setIcon(hardIcon);
         speed = 1500;			//떨어지는 속도 조절 (클수록 느림)
      }
      else if(e.getSource() == normalButton) {
         easyButton.setIcon(easyIcon);
         normalButton.setIcon(normalIconSelected);
         hardButton.setIcon(hardIcon);
         speed = 1000;
      }
      else if(e.getSource() == hardButton) {
         easyButton.setIcon(easyIcon);
         normalButton.setIcon(normalIcon);
         hardButton.setIcon(hardIconSelected);
         speed = 600;
      }
      
      
      /***  메인 버튼  ***/
      if(e.getSource() == startButton) {   //startButton 클릭하면
         inputID();
      }
      
      if(e.getSource() == exitButton) {   //exitButton 클릭하면
         System.exit(0);      //종료
      }
      
      if(e.getSource() == startButton2) {
         userName = inputUserName.getText();         //텍스트필드에 입력한 값을
         userNumber = inputUserNumber.getText();      //String 변수에 저장
         nameLabel = new JLabel(userName);
         numLabel = new JLabel(userNumber);
         gameStart();
         System.out.println("이름, 학번 input");
      }
   }
   /***  게임 시작  ***/
   private void gameStart() {
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
      //난이도 버튼 안보이게
      easyButton.setVisible(false);
      normalButton.setVisible(false);
      hardButton.setVisible(false);
      tilteLabel.setVisible(false);
      background = new ImageIcon("image/background2.png"); // 배경 이미지를 두번째 이미지로 바꿈
      inputLabel.setVisible(true);
      inputNameLabel.setVisible(true);
      inputNumLabel.setVisible(true);
      javaTeamLabel.setVisible(true);
      
      for(int i=0; i<3; i++) {		//라이프 3개 표시
    	  lifeLabel[i].setVisible(true);
      }

      
      /***  글자 뿌리기  ***/
      for(int i=0; i<10; i++) {
    	  problems[i] = new JLabel(problemCreator.str.get(i));
    	  problems[i].setFont(new Font("", Font.BOLD, 15));
    	  problems[i].setBounds(0,0,180,20);
    	  if(i%4 == 0)
    		  problems[i].setLocation(i*70, 0);
    	  else if(i%4 == 1)
    		  problems[i].setLocation(i*70, 50);
    	  else if(i%4 == 2)
    		  problems[i].setLocation(i*70, 100);
    	  else if(i%4 == 3)
    		  problems[i].setLocation(i*70, 20);
    	  add(problems[i]);
      }
      
      timer.time.setVisible(true);	//타이머 보이게 함
      timer.start();		//Time.java 쓰레드 시작
      rain.start();		//WordRaining.java의 쓰레드 시작
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
      startButton2.setVisible(true);      //보이게
      startButton.setVisible(false);      //안보이게
      rankButton.setVisible(false);
      exitButton.setVisible(false);
      easyButton.setVisible(false);
      normalButton.setVisible(false);
      hardButton.setVisible(false);
      tilteLabel.setVisible(true);
   }

   /***  입력값 확인 후 단어 삭제  ***/
   private void removeWord() {
	   for (int i=0; i<10; i++) {
		   if(inputText.getText().equals(problemCreator.str.get(i))) {	//입력값이 맞으면
			   problems[i].setVisible(false);		//해당 단어 안보이게
		   }
	   }
	   inputText.setText("");	//위에서 검사 했으면 텍스트필드 비우기	  
   }
   
   /***  게임 끝내기  ***/
   public static void endGame() {
	   
	   int count=0;
	   
	   for(int i=0; i<10; i++) {
		   if(problems[i].isVisible())
			   count++;			//현재 보이는 단어들 수 count
	   }
	   System.out.println("남은 단어 수: " + count);
	   
	   
	   if(count == 0) {			//보이는 단어가 없으면
		   rain.stop();		//rain 쓰레드 종료
		   timer.stop();
		   JOptionPane.showMessageDialog(null, 
				   (Integer.toString(timer.playTime) + "초"));	//팝업으로 시간 띄우기
		   
		   System.exit(0);		//게임 종료
	   }
   }
   
   @Override
   public void keyPressed(KeyEvent e) {
      if (e.getKeyCode() == 10) { // 엔터가 눌리면
    	  removeWord();
    	  endGame();
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
   
      g.drawImage(background.getImage(), 0, 0,null );   //배경화면 추가
      setOpaque(false);    //그림을 표시하게 설정,투명하게 조절
        super.paintComponent(g);
   }
   
}