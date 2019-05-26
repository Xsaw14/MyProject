package ZOHO.src;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;


public class Weightage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeMap<Integer, Integer> tm= new TreeMap<Integer, Integer>();
		Scanner in = new Scanner(System.in);
		int arr[]={10,36,54,25,89,12};
		for(int i=0;i<arr.length;i++)
		{
			int x = arr[i];
			tm.put(x, 0);
			boolean flag = false,flag2 = false,flag3 = false;
			for(int j=0;j<=x/2;j++)
			{
				if(j*j==x){
					flag = true;
				}
			}
			if(x%4==0&&x%6==0){
				flag2=true;
			}
			if(x%2==0){
				flag3=true;
			}
			if(flag){
				int a = tm.get(x);
				tm.put(x, a+5);
			}
			if(flag2){
				int a = tm.get(x);
				tm.put(x, a+4);
			}
			if(flag3){
				int a = tm.get(x);
				tm.put(x, a+3);
			}
			
		}
		
		System.out.println(tm);

	}

}
