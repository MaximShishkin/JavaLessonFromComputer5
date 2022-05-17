package ru.shishkin.javaLessonFromComputer12.newYearsRain;// ��������� ��� ������, ���� ����������!
// package game4;


// ����������� ����������� ���������
import javax.imageio.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

// ����� ������, ������� �������� ������� �����
class pole extends JPanel
{
	  private Image shapka; // �������� ���������� ������, � ������� ����������� �����
	  private Image fon; // �������� ���������� ������, � ������� ����������� ���
	  public int x = 400; // �������� ���������� ������, � ������� ����������� �����
	  private int slogn; // ���������� ��������� ����
	  private podar[] gamePodar; // ������ ��������
	  private Image end_game; // ����������� ��������� ����
	  public Timer timerUpdate,timerDraw,timercheck; // ��� �������: ������ ��� 
	  public int score=0;
	  public int life=5;
	  public int second=0;
	  public int M=0;
	  public int S=0;
	  	  
	   // ����������� ������ 
	   public pole(int slogn)
	   {		   
		   this.slogn = slogn;			  
		   // �������� ����������� ����� �� �����
		   try
		   {
		     shapka = ImageIO.read(new File("./shapka.png"));
		   }
		   catch(IOException ex) {}
		   
		   // �������� ����������� ���� �� �����
		   try
		   {
		     fon = ImageIO.read(new File("./fon.png"));
		   }
		   catch(IOException ex) {}
		   
    	   // �������� ����������� ��������� ����
		   try
		   {
		     end_game = ImageIO.read(new File("./end_game.png"));
		   }
		   catch(IOException ex) {}		   
		
    		//  �������� ���� ����������� ��������
		   gamePodar = new podar[50];
		   for (int i=0;i<15;i++)
		   {
			   try
			   {
				   gamePodar[i] = new podar(ImageIO.read(new File("./p"+(i%7)+".png")));
			   }
			   catch (IOException ex) {}
		   }

		   // �������� �������, ������� ����� ��� � ��� ������� ��������� � ��������� ������� �� ������� ���� 		   
		   timerUpdate = new Timer(3000,new ActionListener() {				
				public void actionPerformed(ActionEvent e) {
		           updateStart(); // ����� ��� �������� � ���������� �������� �� ������� ����
				}
			});		    
		   timerUpdate.start(); // ������ ������� timerUpdate 		   		   
		   
		   // �������� �������, ������� ����� �������������� ������� ���� 20 ��� � ������� 	   
		   timerDraw = new Timer(50,new ActionListener() {				
				public void actionPerformed(ActionEvent e) {
		           repaint(); // ������ ������ ����������� ���� (public void paintComponent(Graphics gr))
				}
			});		    
		   timerDraw.start(); // ������ ������� ��� �����������
		   
		   timercheck = new Timer(1000,new ActionListener() {				
				public void actionPerformed(ActionEvent e) {
		           second++;
		           if (second % 600==0)
		           {
		        	   M++;
		        	   S=0;
		           }
		           else S++;
				}
			});
		   timercheck.start(); // ������ 
	   }
	   	   
	   // �����, ������� ������������ ����������� ������� �� ������
	   public void paintComponent(Graphics gr)
	   {
		   
		   
		   // ��������� ��������� ������� ������ ����
		   super.paintComponent(gr);
		   gr.drawImage(fon, 0, 0, null); // ��������� ���� 
		   gr.setColor(Color.YELLOW);
		   gr.setFont(new Font("arial",0,40));
		   gr.drawString("Score:"+score, 50, 550);
		   
		   gr.setColor(Color.YELLOW);
		   gr.setFont(new Font("arial",0,40));
		   gr.drawString("Life:"+life+"/5", 600, 550);
		   
		   gr.setColor(Color.YELLOW);
		   gr.setFont(new Font("arial",0,40));
		   gr.drawString("Time: "+M+":"+S, 0, 40);
		   
		   gr.drawImage(shapka, x, 465, null); // ��������� �����
		   // ����, ������� ���������� ������� �� ������� ���� � ��������� ����������� �������
           for (int i=0;i<15;i++)
           {
        	       gamePodar[i].draw(gr); // ����������� �������
        	      /* if (gamePodar[i].act==true) // ���� ������� �� ������� �������� �������
        	       {
        	    	    if ((gamePodar[i].y+gamePodar[i].img.getHeight(null))>=470) // ���� ������� ������ ������ �������
        		   {
        			    if (Math.abs(gamePodar[i].x - x) > 75) // ���� ������� ��������
        			    {
        			    	life--;
        			    	gamePodar[i].act=false;
        			    	if (life<0){
        			        gr.drawImage(end_game, 300, 300, null); // ����� �������� ��������� ����
        			    	timerDraw.stop(); // ��������� ������� timerDraw 
        			    	timerUpdate.stop(); // ��������� ������� timerUpdate
        			        break; // ���������� �����
        			    	}
        			    }
        			    else {gamePodar[i].act=false; // ������ ������� � �������� ����, ���� �� ������ ������
        			    score++;}
        		   }
        	       }*/
           }
           
	   }
    	// ����� ��� �������� � ���������� �������� �� ������� ����
	   private void updateStart()
	   {
           int kol=0; // ���������� ��� �������� �������� �� ������� ����
           for (int i=0;i<15;i++) // ���� �������� ���� �������� �������
           {
              if (gamePodar[i].act==false) // ���� ������� �� �� ������� ����
              {
                 if (kol<slogn) // ���� ������� ���������� ����� ������ ��������� (�� 1 �� 7)
                 {
                   gamePodar[i].start(); // ����������� ������� �� ������� ����, ����� ��� ������ �������� ����
                   break; // ���������� �����
                 }
              }
              else kol++; // ���� ������� �� ������� ����
           }
	   }	   
}