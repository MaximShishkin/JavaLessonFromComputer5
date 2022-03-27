package ru.shishkin.javaLessonFromComputer12.javaLesson1;

public class JavaLesson1 {
    // ����� �����
	public static void main(String[] args) {
		// ���� �� ��� ��������, �� ���� ������� � ���!
		int a; // int = integer = ����� ����� (-1, 10, 15, 0)
        a=-10; // �������������
       // System.out.print(a+" ������ ");   
        a=10;
        
        int b;
        b=158;
       // System.out.print(b); 
        
        double c; // ������� ��� ������������ ( 3.14)
        c = 3.14; // �������������
        System.out.println("�������� ���������� � = "+ c);  
        
       // System.out.print(a+b+c);
        // System.out.println("��������� �� ����� ������");
        
        boolean bol = true; // ������ � ����
        // ������ (��) = true
        System.out.println("bol");
        System.out.println(bol);
        
        boolean bol1 = false; 
        // ��� (����) = false
        System.out.println(bol1);
        
        // ������
        String str = "Java";
        System.out.println(str);
        String str1 = "������";
        System.out.println(str1);
        System.out.println(str+" �� ������ ���� "+str1); // ���������� �����
	}
}