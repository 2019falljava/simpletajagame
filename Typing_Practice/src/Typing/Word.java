package Typing;

import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JLabel;

abstract public class Word {
	public ArrayList<String> str = new ArrayList<>();
	
	abstract void create();
	abstract void shuffle();
}

class Words extends Word {
	public void create() {
		String problems[] = { 
				"Hello World",				"Beautiful",
				"Awesome",
				"English",					"Korean",
				"Clean", 					"Dark",
				"Qute",						"Return",

				"Enjoy",					"Angry",
				"Happy",					"Java",
				"China",
				"True",
				"False",					"Excel",

				"PowerPoint",				
				"Samsung",
				"Alphabet",					
				"Kpop",						
				"Germany"
				};
		
		for (int i=0; i<problems.length; i++) {
			this.str.add(problems[i]);
		}
	}
	
	void shuffle() {			//���ڿ� �迭 Shuffle
		Collections.shuffle(this.str);
	}
}