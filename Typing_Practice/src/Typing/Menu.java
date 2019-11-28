package Typing;

import javax.swing.JFrame;
import java.awt.*;

public class Menu extends JFrame {
	
	public static void main(String[] args) {

		JFrame Frame = new JFrame(); 		// JFrame 媛앹껜 �깮�꽦
		
		Frame.setSize(800, 600);			 // JFrame �궗�씠利�
		Frame.setTitle("Typing Practice");	// JFrame �씠由�
		Frame.setLocationRelativeTo(null);	 // JFrame�쓣 紐⑤땲�꽣�쓽 以묒븰�뿉 �쑉寃� �븿
		
		
		
		Frame.add(new Component());
		Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Frame.setVisible(true);
		
	}
}