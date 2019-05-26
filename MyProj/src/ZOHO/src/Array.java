package ZOHO.src;

import java.util.Scanner;

public class Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String arr[][] = { { "w", "e", "l", "c", "o" },
				{ "m", "e", "t", "o", "z" }, { "o", "h", "o", "c", "o" },
				{ "r", "p", "o", "r", "a" }, { "t", "i", "o", "n", ""} };
		Scanner in = new Scanner(System.in);
		System.out.println("enter the number");

		String a = in.next();
		int n = a.length();
		int i = 0, j = 0;
		String start = Character.toString(a.charAt(0));
		System.out.println(start);
		for (i = 0; i < 5; i++) {
			for (j = 0; j < 5; j++) {
				if ((!arr[i][j].equals(null)) && arr[i][j].equals(start)) {
					StringBuffer bf = new StringBuffer();
					String checkLR = new String();
					String checkTB = new String();
					if ((i + a.length()) < 5) {
						for (int l = 0; l < a.length(); l++) {

							checkTB = bf.append(arr[i + l][j]).toString();
						}
						if (a.equals(checkTB)) {
							System.out.println("starting index is " + i + ","
									+ j);
							System.out.println("ending index is "
									+ (i + a.length()-1) + "," + j);
							
						}
					}
					if ((j + a.length()) < 5) {
						for (int l = 0; l < a.length(); l++) {
							checkLR = bf.append(arr[i][j + l]).toString();
						}
						if (a.equals(checkLR)) {
							System.out.println("starting index is " + i + ","
									+ j);
							System.out.println("starting index is " + i + ","
									+ (j + a.length()-1));
						}
					}

				}
				else
				{
					System.out.println("No such word");
				}
			}
		}

	}

}
