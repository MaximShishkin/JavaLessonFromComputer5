// ”казываем им€ пакета, если необходимо!
// package les6;

import javax.swing.*;
import java.awt.*;
import javax.imageio.*;
import java.io.*;
import java.awt.event.*;


public class prog {	
	public static void main(String[] args) {		
		myFrame okno = new myFrame();
	}
}
class myFrame extends JFrame
{	
    public myFrame()
    {    	
    	myPanel np = new myPanel();
    	Container cont = getContentPane(); 
    	cont.add(np);
    	setBounds(0, 0, 800, 600);
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	setVisible(true);
    }
}
class myPanel extends JPanel
{	
	private int x=0,y=0;
	//private int x1=0,y1=0;
	private int napr = 2;
	private int napr1=1,napr2=1;
	private Image img;	
	private Image img1;	
	private Image img2;
	
	private class myKey implements KeyListener  
	{
	   	    public void keyPressed(KeyEvent e)
	   	    {
	   	    	int key_ = e.getKeyCode();
	   	    	System.out.println(key_);
	   	    	if (key_==37) napr = 0;
	   	    	if (key_==39) napr = 2;
	   	    	if (key_==38) napr = 1;
	   	    	if (key_==40) napr = 3;	
	   	    	if (key_==32) napr = 4;	
	   	    	/*if (key_==97) napr = 11;
	   	    	if (key_==99) napr = 33;
	   	    	if (key_==103) napr = 77;
	   	    	if (key_==105) napr = 99;	
	   	    	if (key_==65) napr1 = 0;
	   	    	if (key_==68) napr1 = 2;
	   	    	if (key_==87) napr1 = 1;
	   	    	if (key_==83) napr1 = 3;   */
	   	    }
	   	    public void keyReleased(KeyEvent e) {}
	   	    public void keyTyped(KeyEvent e) {}
	}            	
	
	
	public myPanel()
	{    	
 	    addKeyListener(new myKey());
    	setFocusable(true);
    	
		try
		{
			img1 = ImageIO.read(new File("./fon.png"));
	    	img = ImageIO.read(new File("./planeta.png"));
	    	//img2 = ImageIO.read(new File("./planeta.png"));
		}
		catch(Exception exp) {}		
		
		Timer nt = new Timer(25,new ActionListener() {
			public void actionPerformed(ActionEvent e) {			   
			   if (napr==0) {x-=5; napr1=napr; napr2=napr;}
	           if (napr==1) {y-=5; napr1=napr; napr2=napr;}
	           if (napr==2) {x+=5; napr1=napr; napr2=napr;}
	           if (napr==3) {y+=5; napr1=napr; napr2=napr;}
	           if (napr==4)
	           {
	        	   System.out.println(""+napr+napr1);
	        	   if (napr1!=4)
	        	   {
	        		   y+=0; 
		        	   x+=0; 
		        	   napr1=napr;  
	        	   }
	        	   else if (napr1==4)
		           {
		        	   if (napr2==0) x-=5;
			           if (napr2==1) y-=5;
			           if (napr2==2) x+=5;
			           if (napr2==3) y+=5;
		           }
	           }
	          
	           
	           if (x>470) napr=0;
	           if (x<0) napr=2;
	           if (y>270) napr=1;
	           if (y<0) napr=3;
	           
	           /*if (napr1==0) x1-=5;
	           if (napr1==1) y1-=5;
	           if (napr1==2) x1+=5;
	           if (napr1==3) y1+=5;
	       
	           if (x1>470) napr1=0;
	           if (x1<0) napr1=2;
	           if (y1>270) napr1=1;
	           if (y1<0) napr1=3;
              	         
	            if (napr==11) {y+=3;x-=3;}
	           if (napr==33) {y+=3;x+=3;}
	           if (napr==77) {y-=3;x-=3;}
	           if (napr==99) {y-=3;x+=3;}*/
	           
	           repaint();
			}
		});	
		nt.start();
	}	
	
	public void paintComponent(Graphics gr)
	{
	  super.paintComponent(gr);
	  gr.drawImage(img1,0,0,null);
	  gr.drawImage(img,x,y,null);
	  //gr.drawImage(img2,x1,y1,null);
	}
}
