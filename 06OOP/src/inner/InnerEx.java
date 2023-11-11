package inner;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InnerEx {
	public static void main(String[] args) {
		Button b = new Button("Start");
//		b.addActionListener(new EventHandler());
		//익명 객체 클래스를 -> 람다식 
		b.addActionListener((e) -> System.out.println("ActionEvnet occurred!!"));
	}

}

class EventHandler implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("ActionEvent occurred!!");
	}

}
