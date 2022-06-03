package ru.shishkin.javaLessonFromComputer12.newYearsRain;


import javax.swing.*;


public class ApplicationNYR {


	public static void main(String[] args) {
		

		   String rez = JOptionPane.showInputDialog(null,"������� ��������� ���� �� 1 �� 15:","��������� ����",1);
		   

		   int slogn = Integer.parseInt(rez);

		   if ((slogn>=1)&&(slogn<=15))
		   {

		      FrameNYR window = new FrameNYR(slogn);
		   }
	}

}
