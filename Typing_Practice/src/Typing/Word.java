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
				"Awesome",					"Sejong University",
				"English",					"Korean",
				"Clean", 					"Dark",
				"Qute",						"Return",

				"Enjoy",					"Angry",
				"Happy",					"Java",
				"United States of America",	"China",
				"Republic of Korea",		"True",
				"False",					"Excel",

				"PowerPoint",				"Thank you again.",
				"Go ahead.",				"Samsung",
				"Alphabet",					"Donald Trump",
				"Kpop",						"John F. Kennedy",
				"Blue House",				"Germany"
				};
		
		for (int i=0; i<problems.length; i++) {
			this.str.add(problems[i]);
		}
	}
	
	void shuffle() {			//문자열 배열 Shuffle
		Collections.shuffle(this.str);
	}
}