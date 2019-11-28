package Typing;

import javax.swing.JOptionPane;

public class WordRaining extends Thread{

	
	public void run() {
		
		System.out.println("게임 시작");
		
		int life = 3;
		
		while(true) {
			try {
				for(int i=0; i<10; i++) {
					int x = Component.problems[i].getX();
					int y = Component.problems[i].getY();
				
					y += 10;
					Component.problems[i].setLocation(x, y);	//y자표를 10 더해서 위치 수정
																//글자가 떨어짐
					
					if(Component.problems[i].isVisible() && y> 320) {		//바다에 빠지면
						Component.problems[i].setVisible(false);	//글자 안보이게 함
						
						if(life == 3) {			//라이프가 3개일 경우
							Component.lifeLabel[2].setVisible(false);
							life=2;
						}
						else if(life == 2) {	//라이프가 2개일 경우
							Component.lifeLabel[1].setVisible(false);
							life=1;
						}
						else if(life == 1) {	//라이프가 1개일 경우
							Component.lifeLabel[0].setVisible(false);
							JOptionPane.showMessageDialog(null, "Game Over");	//GameOver 메세지 창 띄우기
							System.exit(0);		//게임 종료
						}
						Component.endGame();
					}
				}
				Thread.sleep(Component.speed);	//Component.java의 speed를 기준으로 Thread 속도 조절
			}
			catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
