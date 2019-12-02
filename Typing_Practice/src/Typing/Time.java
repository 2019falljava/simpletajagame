package Typing;
import javax.swing.JLabel;

public class Time extends Thread {
	public int playTime;
	public JLabel time = new JLabel("0");
	
	public void run() {
		for (playTime = 0; ;playTime++) {
			try {
				Thread.sleep(1000);		//1초에 1씩 증가
			}
			catch(InterruptedException e) {
				e.printStackTrace();
			}
			time.setText(playTime + "");
		}
	}
}
