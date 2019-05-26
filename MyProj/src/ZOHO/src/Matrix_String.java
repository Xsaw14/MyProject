package ZOHO.src;

import java.util.Scanner;


public class Matrix_String {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = new String();
		System.out.println("Enter the String ");
		Scanner in = new Scanner(System.in);
		str = in.next();
		System.out.println(str);
		int n=str.length();
		String str1[][] = new String[n][n];
		if(n%2==1)
		{
			
			for(int i=0;i<n;i++){
				for(int j=n-1;j>=0;j--){
				str1[i][i]=Character.toString(str.charAt(i));
					if(i+j+1==n)
				str1[j][i]=Character.toString(str.charAt(i));
			}
			
			}
		}
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				if(null!=str1[i][j])
				System.out.print(str1[i][j]);
				else
					System.out.print(" ");
			}
			System.out.println();
		}

	}

}
