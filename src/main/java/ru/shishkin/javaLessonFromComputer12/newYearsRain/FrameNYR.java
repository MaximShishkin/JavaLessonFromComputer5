package ru.shishkin.javaLessonFromComputer12.newYearsRain;



import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


class FrameNYR extends JFrame
{	
    private PanelNYR gameP;
    private int slogn;

	private class myKey implements KeyListener  
	{
	   	    public void keyPressed(KeyEvent e)
	   	    {

	   	    	int key_ = e.getKeyCode();

	   	    	if (key_==27) System.exit(0);	   	    		   	    	
	   	    	else if (key_==37)
	   	    	{
	   	    		if (gameP.x-30>-48) gameP.x-=30;
	   	    		else gameP.x=752;
	   	    	}	   	    	
	   	    	else if (key_==39)
	   	    	{

	   	    		if (gameP.x+30<752) gameP.x+=30;
	   	    		else gameP.x=-48;
	   	    	}
	   	    	
	   	    }
	   	    public void keyReleased(KeyEvent e) {}
	   	    public void keyTyped(KeyEvent e) {}
	   }            	

    public FrameNYR(int slogn)
    {

    	this.slogn = slogn;

 	    addKeyListener(new myKey());

    	setFocusable(true);
    	

        setBounds(0,0,800,600);

        setTitle("����: ���������� �����");

        setResizable(false);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        

        gameP = new PanelNYR(slogn);

        Container con = getContentPane();
        con.add(gameP);

    	setVisible(true);
    }
}

