package ZOHO.src;

import java.util.LinkedList;
import java.util.Scanner;


public class PrimeNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PrimeNumber obj = new PrimeNumber();
		System.out.println("ENter number of prime number needed");
		Scanner in = new Scanner(System.in);
		LinkedList<Integer> l = new LinkedList<Integer>();
		l.add(2);
		int n = in.nextInt();
		for(int i=3;l.size()<=n;i++)
		if(obj.checkPrime(i))
		{
			l.add(i);
		}
		System.out.println(l);

	}
	
	public boolean checkPrime(int n)
	{
		int c=0;
		for(int i=2;i<=n/2;i++)
		{
			if(n%i==0)
			{
				c++;
			}
		}
		if(c>0)
			return false;
		else 
			return true;
	}

}
