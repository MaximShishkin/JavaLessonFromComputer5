package ru.shishkin.lesson1;

import java.util.Scanner;

public class Lesson1 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		int t1 = scan.nextInt();
		int n = 1;
		boolean k = false;
		int test=0;
		
		if ((t1%3 == 0)||(t1%5 == 0))
		{
			System.out.println("YES");
		}
		else 
		{
			while (k == false)
			{
				test = t1 - 3*n;
				if (test%5 == 0)
				{
					k = true;
				}
				else
				{
					n = n+1;
					if (n*3 > t1)
					{
						k = true;
					}
				}
			}
			if (test%5 == 0)
			{
				System.out.println("YES");
			}	
			else
			{
				System.out.println("NO");
			}
		}
		
	}
}
