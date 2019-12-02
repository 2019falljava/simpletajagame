package Typing;

import javax.swing.JOptionPane;

public class WordRaining extends Thread{

	public void run() {
		
		System.out.println("���� ����");
		
		int life = 3;
		
		while(true) {
			try {
				for(int i=0; i<10; i++) {
					int x = Component.problems[i].getX();
					int y = Component.problems[i].getY();
				
					y += 10;
					Component.problems[i].setLocation(x, y);	//y��ǥ�� 10 ���ؼ� ��ġ ����
																//���ڰ� ������
					
					if(Component.problems[i].isVisible() && y> 320) {		//�ٴٿ� ������
						Component.problems[i].setVisible(false);	//���� �Ⱥ��̰� ��
						
						if(life == 3) {			//�������� 3���� ���
							Component.lifeLabel[2].setVisible(false);
							life=2;
						}
						else if(life == 2) {	//�������� 2���� ���
							Component.lifeLabel[1].setVisible(false);
							life=1;
						}
						else if(life == 1) {	//�������� 1���� ���
							Component.lifeLabel[0].setVisible(false);
							JOptionPane.showMessageDialog(null, "Game Over");	//GameOver �޼��� â ����
							System.exit(0);		//���� ����
						}
						Component.endGame();
					}
				}
				Thread.sleep(Component.speed);	//Component.java�� speed�� �������� Thread �ӵ� ����
			}
			catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
