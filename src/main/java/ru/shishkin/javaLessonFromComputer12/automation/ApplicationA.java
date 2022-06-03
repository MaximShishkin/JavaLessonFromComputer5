package ru.shishkin.javaLessonFromComputer12.automation;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ApplicationA {
	public static Robot rob=null;
	
	public static void main(String[] args) {
		try
		{
			rob = new Robot();
		}
		catch (Exception e) {}

		JFrame wnd = new JFrame();
		wnd.setUndecorated(true);
		wnd.setAlwaysOnTop(true);
		wnd.setLocation(0, 0);
		wnd.setLayout(new FlowLayout());

		JButton[] btn = new JButton[6];		
		for (int i=0; i<6; i++)
		{
		   btn[i] = new JButton();
		   btn[i].setName("b"+i);
		   btn[i].addActionListener(new ActionListener() {
			  public void actionPerformed(ActionEvent e) {
				  JButton b = (JButton)e.getSource();
				  String name = b.getName();

				  if (name.equals("b0"))
				  {
				        try
				        {

				ProcessBuilder proc = new ProcessBuilder(
	"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe",
	"http:\\club.1c.ru");
						  proc.start();
					  }
					  catch (Exception ex) {}
				  }
				  else if (name.equals("b1"))
				  {
				     for (int i=500; i>=0; i--)
				     {
					  rob.mouseMove(i, i);
					  rob.delay(5);
				     }
				     rob.mouseMove(50, 30);									

				    rob.mousePress(MouseEvent.BUTTON1_MASK);

				    rob.delay(200);

				    rob.mouseRelease(MouseEvent.BUTTON1_MASK);
				  }
				  else if (name.equals("b2"))
				  {
				        try
				        {

		     ProcessBuilder proc = new ProcessBuilder("calc");
						 proc.start();
					  }
					  catch (Exception ex) {}

				        rob.delay(5000);


				        rob.keyPress(KeyEvent.VK_ALT);
				        rob.delay(100);
				        rob.keyPress(KeyEvent.VK_F4);
				        rob.delay(100);
				        rob.keyRelease(KeyEvent.VK_F4);
				        rob.delay(100);
				        rob.keyRelease(KeyEvent.VK_ALT);
				        rob.delay(100);				        

				  }
				  else if (name.equals("b3"))
				  {
					  for (int i=0; i<10; i++)
					  {
					     rob.keyPress(KeyEvent.VK_CAPS_LOCK);
					     rob.delay(500);
					     rob.keyRelease(KeyEvent.VK_CAPS_LOCK);						    

					     rob.keyPress(KeyEvent.VK_NUM_LOCK);
					     rob.delay(500);
					     rob.keyRelease(KeyEvent.VK_NUM_LOCK);

					     rob.keyPress(KeyEvent.VK_SCROLL_LOCK);
					     rob.delay(500);
					     rob.keyRelease(KeyEvent.VK_SCROLL_LOCK);
					  }
				  }				  
				  else if (name.equals("b4"))
				  {
					  System.exit(0);
				  }
				  else if (name.equals("b5")) 
				  {
					    rob.keyPress(KeyEvent.VK_WINDOWS);
				        rob.keyPress(KeyEvent.VK_R);
				        rob.delay(200);
				        rob.keyRelease (KeyEvent.VK_WINDOWS);
				        rob.keyRelease(KeyEvent.VK_R);
				        
				        rob.keyPress(KeyEvent.VK_BACK_SPACE);
				        rob.delay(200);
				        rob.keyRelease(KeyEvent.VK_BACK_SPACE);
				        
				        rob.keyPress(KeyEvent.VK_C);
				        rob.delay(200);
				        rob.keyRelease(KeyEvent.VK_C);
				        
				        rob.keyPress(KeyEvent.VK_M);
				        rob.delay(200);
				        rob.keyRelease(KeyEvent.VK_M);
				        
				        rob.keyPress(KeyEvent.VK_D);
				        rob.delay(200);
				        rob.keyRelease(KeyEvent.VK_D);
				        
				        rob.keyPress(KeyEvent.VK_ENTER);
				        rob.delay(200);
				        rob.keyRelease(KeyEvent.VK_ENTER);
				        
				        rob.keyPress(KeyEvent.VK_F);
				        rob.delay(200);
				        rob.keyRelease(KeyEvent.VK_F);
				        
				        rob.keyPress(KeyEvent.VK_O);
				        rob.delay(200);
				        rob.keyRelease(KeyEvent.VK_O);
				        
				        rob.keyPress(KeyEvent.VK_R);
				        rob.delay(200);
				        rob.keyRelease(KeyEvent.VK_R);
				        
				        rob.keyPress(KeyEvent.VK_M);
				        rob.delay(200);
				        rob.keyRelease(KeyEvent.VK_M);
				        
				        rob.keyPress(KeyEvent.VK_A);
				        rob.delay(200);
				        rob.keyRelease(KeyEvent.VK_A);
				        
				        rob.keyPress(KeyEvent.VK_T);
				        rob.delay(200);
				        rob.keyRelease(KeyEvent.VK_T);
				        
				        rob.keyPress(KeyEvent.VK_SPACE);
				        rob.delay(200);
				        rob.keyRelease(KeyEvent.VK_SPACE);
				        
				        rob.keyPress(KeyEvent.VK_D);
				        rob.delay(200);
				        rob.keyRelease(KeyEvent.VK_D);
				        
				        rob.keyPress(KeyEvent.VK_SHIFT);
				        rob.keyPress(KeyEvent.VK_ALT);
				        rob.delay(500);
				        rob.keyRelease(KeyEvent.VK_SHIFT);
				        rob.keyRelease(KeyEvent.VK_ALT);
				        
				        rob.keyPress(KeyEvent.VK_SHIFT);
				        rob.keyPress(KeyEvent.VK_6);
				        rob.delay(500);
				        rob.keyRelease(KeyEvent.VK_SHIFT);
				        rob.keyRelease(KeyEvent.VK_6);
				        		                
				             
				        rob.keyPress(KeyEvent.VK_ENTER);
				        rob.delay(100);
				        rob.keyRelease(KeyEvent.VK_ENTER);
				        
				  }
			  }
		   });
		   wnd.add(btn[i]);
		}

		btn[0].setText("�������");
		btn[1].setText("����");
		btn[2].setText("�����������");
		btn[3].setText("�������");
		btn[4].setText("�����");
		btn[5].setText("�������������");

		wnd.pack();

		wnd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		wnd.setVisible(true);
		
	}
}

