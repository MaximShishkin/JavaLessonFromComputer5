package ru.shishkin.javaLessonFromComputer12.newYearsRain;// ��������� ��� ������, ���� ����������!
// package game4;


// ����������� ����������� ���������
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// ����� ��� �������, ��������� ������
class PodarNYR {
	
	public Image img; // ����������� �������
    public int x,y; // ��������� ������� �� ������� ����, � ��������, x - ������ �����, y - ������ ������
    public Boolean act; // ���������� ����������� ����, ������������ ���������� �������, ���� �� ������� ���� ��� ���
    Timer timerUpdate; // ������, ���������� �� �������� ������� ����
    private int napr= 0;
    public int g=0;
    
    // ����������� ������
    public PodarNYR(Image img)
    {
    	// �������� � ��������� �������, ����������� �� �������� ������� ����
		timerUpdate = new Timer(500,new ActionListener() {				
			public void actionPerformed(ActionEvent e) {
	            vniz(); // �����, �������������� �������� ������� ����
		}
	    });		
    	this.img = img; // �������� ����������� �� ������� ������ ������������ ������ � ���������� ������
    	act=false; // ���������� ������ ������� ����������, ������������� �� ������� ����    	
    }
    
    // �����, ����������� ����������� ������� �� ������� ����, ����� ��� ������ �������� ����
    public void start()
    {
    	timerUpdate.setDelay(30); // ��������� ��������� �������� ��� �������
        timerUpdate.start(); // ������ �������
        y = 0; // ������ ������ � ��������
        x = (int)(Math.random()*700); // ������ ����� � ��������, �������� ��������� ������� �� 0 �� 700
        act = true; // 
    }
    
    // �����, �������������� �������� ������� ���� 
    public void vniz()
    {
    	if (napr==8) y-=6;
        if (napr==2) y+=6;
        if (napr==9) {y-=6;x+=6;}
        if (napr==6) x+=6;
        if (napr==3) {y+=6;x+=6;}
        if (napr==1) {y+=6;x-=6;}
        if (napr==4) x-=6;
        if (napr==7) {y-=6;x-=6;}
        if(y<=0)
        {
     	   napr=(int)(Math.random()*3+1);
     	  return;
        }
       
        if (g==0)
        {if ((act==true)&&(y<=6)) // ���� ������� ������� �� ������� ����
       {
    	   napr=2;
    	   g=1;
    	   return;
    	   
    	   //napr=(int)(Math.random()*3+7); // ���������� ������� ������ �� 6 ��������
       }}
        else {
       if ((y+img.getHeight(null))>=470) // ���� ������� ������ ������ �������
       {
    	   //napr=8;
    	   napr=(int)(Math.random()*3+7);
    	   return;
    	   //timerUpdate.stop(); // ��������� �������
       }
       if(y<=0)
       {
    	   napr=(int)(Math.random()*3+1);
    	  return;
       }
       if(y<=0)
       {
    	   napr=(int)(Math.random()*3+1);
    	   return;
       }
       if(x<=0)
       {
    	   napr=((int)(Math.random()*3+1))*3;
    	   return;
       }
       if(x>=670)
       {
    	   napr=(((int)(Math.random()*3+1))*3)-2;
    	   return;
       }}
      
       
    }
    
    // �����, ����������� ��������� ������� �� ������� ����, ���� �� �������
    public void draw(Graphics gr)
    {
    	if (act==true)
    	{
    	   gr.drawImage(img,x,y,null); // ��������� �����������
    	}    	
    }
}
