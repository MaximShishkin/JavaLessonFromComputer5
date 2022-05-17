package ru.shishkin.javaLessonFromComputer12.shishkin.lesson

import java.awt.*;
import java.io.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.imageio.*;
import javax.swing.*;

public class prog {
	public static void main(String[] args) {
		// ������� ������ ����
		new myFrame(); 				
	}
}

class myFrame extends JFrame
{
	// ���������� ���� Robot
	private Robot rob;
	// ���������� ���� ������
	private Timer tm;
	// ������� ����������
	private int kol=0;
	// ���� ��� ����������
	private Frame wnd;

	// ����������� ������
	public myFrame()
	{
		try
		{
			// ������� ����� ������ ������ Robot
			rob = new Robot();
		}
		catch (Exception e) {}
				
	    // ������� ������ � ��������� � 10 ������
	    tm = new Timer(10000,new ActionListener() {
		 public void actionPerformed(ActionEvent e) {
		    // ������� �������� ������ � ���������� ��� � ����
		    saveScreen();
		}
	    });	
	    // ��������� ������
	    tm.start();
		
	  // �� ��������� ������ ���������� ��� �������� ����
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        // ������� ����
	  setVisible(true);
	  // � ����� ��� ������
	  setVisible(false);
	}
	
	// ����� ������ ��������� ������ � ���������� ��� � ����
	private void saveScreen()
	{
		// ������� ���������� ����������
		kol++;
		
		// ���������� ������� ���������� ������
		Dimension dm = Toolkit.getDefaultToolkit().getScreenSize();
		int w = dm.width;
		int h = dm.height;
		
		try
		{
	         // ������� �������� ������ � ������� ������ Robot
		   BufferedImage img = 
                  rob.createScreenCapture(new Rectangle(0,0,w,h));
      // ��������� ����������� � PNG ����� 
	ImageIO.write(img, "PNG", new File("c:\\mobile\\img"+kol+".png"));
		}
		catch (Exception e) {}
		
		// ����� ������ ���� ������
		if (kol==6)
		{
		    // ������ �������������
		    tm.stop();
			
		    // ������� ����
		    wnd = new Frame();
		    // ��������� ����������� ��������� �������� ����
		    wnd.setResizable(false);
		    // ������������� ������� � ������ �����
		    wnd.setBounds(0, 0, w, h);
		    // ������������� ���� ���� �������
		    wnd.setBackground(Color.RED);
		    // ��������� ���� ������ ������ ����
		    wnd.setAlwaysOnTop(true);
		    // ������� ����� ����
		    wnd.setUndecorated(true);
		    // ������ ������������ 50%
		    wnd.setOpacity(0.5f);
		    
		    // ���������� ���������� �������
		    wnd.addWindowListener(new WindowAdapter() {
		    	// ��� ������������ ����
			public void windowIconified(WindowEvent arg0) {
			      // ��������� ���� �� ������ ����� 
				wnd.setExtendedState(Frame.MAXIMIZED_BOTH);
	            	}
	        });
		    		    
		    // ������� ����
		    wnd.setVisible(true);
			
	// ������� ������ � ��������� � 10 ����������� (100 ��� � �������)
		    tm = new Timer(10,new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				    // ������� ���� �� �������� ����
				    wnd.toFront();						
				}
			});	
		    // ��������� ������
		    tm.start();
		    
		}		
	}
}
