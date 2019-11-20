package Typing;

import javax.swing.JFrame;
import java.awt.*;

public class Menu extends JFrame {
	
	public static void main(String[] args) {

		JFrame Frame = new JFrame(); 		// JFrame 객체 생성
		
		Frame.setSize(800, 600);			 // JFrame 사이즈
		Frame.setTitle("Typing Practice");	// JFrame 이름
		Frame.setLocationRelativeTo(null);	 // JFrame을 모니터의 중앙에 뜨게 함
		Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Component comp = new Component();
		Frame.add(comp);
		Frame.setVisible(true);
	}
	
}