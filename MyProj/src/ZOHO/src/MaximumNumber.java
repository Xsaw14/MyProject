package ZOHO.src;

import java.util.Scanner;


public class MaximumNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		System.out.println("enter the number");
		MaximumNumber obj = new MaximumNumber();
		int n = in.nextInt();
		int k1=n;
		for(int i=1;i<=n;i++)
		{
			for(int j=k1;j>=0;j--)
			{
				System.out.print(" ");
			}
			for(int k=1;k<=i;k++){
				int x = obj.pow(11, i-1);
//				System.out.println(x);
				System.out.print(Integer.toString(x).charAt(k-1));
				System.out.print(" ");
			}
			System.out.println();
			k1--;
		}

	}
	public int pow(int x,int y){
		int n=1;
		for(int i=0;i<y;i++)
		{
			n=n*x;
		}
		return n;
	}

}
