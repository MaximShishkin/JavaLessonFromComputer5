import javax.swing.*;

public class prog {

	public static void main(String[] args) {

	for (int i=0; i<500;i++)
	{
		JFrame wnd = new JFrame();
		wnd.setBounds((int) (Math.random()*1000),(int) (Math.random()*800) , 100, 100);
		wnd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		wnd.setVisible(true);
	}
		
		auto a1 = new auto();
		a1.color = "red";
		a1.mas = 2000;
		a1.speed = 210;
		a1.zapr(20);
		
		auto a2 = new auto();
		a2.color = "blue";
		a2.mas = 1500;
		a2.speed = 50;
		a2.zapr(15);
		
	}

}

class auto
{
	int speed;
	int mas;
	String color;
	
	void zapr(int kol)
	{
		mas +=kol;
	}
}