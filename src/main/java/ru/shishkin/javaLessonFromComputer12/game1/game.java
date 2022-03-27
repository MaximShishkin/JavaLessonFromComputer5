package ru.shishkin.javaLessonFromComputer12.game1;// ��������� ��� ������, ���� ����������!
// package game4;


// ����������� ����������� ���������
import javax.swing.*;

// ������� ����� ����
public class game {

	// ������� �����, ������� ��������� ����
	public static void main(String[] args) {
		
		   // ����� ����������� ���� ��� ����� ��������� ����
		   String rez = JOptionPane.showInputDialog(null,"������� ��������� ���� �� 1 �� 15:","��������� ����",1);
		   
		   // ��������� ���������� ������ � ���������� ������ ����
		   //int slogn = rez.charAt(0)-'0';
		   int slogn = Integer.parseInt(rez);
		   // ��������, ��� ������� ����� �� 1 �� 7
		   if ((slogn>=1)&&(slogn<=15))
		   {
    	      // �������� ����, � ������� ��������� ������� ����
		      okno window = new okno(slogn);
		   }
	}

}
