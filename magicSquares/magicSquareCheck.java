// checking that a magic square gives rows with equal sums: sum(row a) = sum(row b) for all rows a,b in matrix

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class magicSquareCheck {

	private static boolean checkMagic(readFile file) throws IOException {
		boolean check = false;
		boolean checkrow = false;
		boolean checkcol = false;
		String line = file.line();
		String[] arr;
		int sum = 0;
		int subsum = 0;
		int val = 0;
		ArrayList<Integer> colsum = new ArrayList<Integer>();
		int len = 0;
		boolean isline1 = true;
//		System.out.println("\n" + file.filename() + ":");
		while (line != null) {
			arr = line.split("\t");  
			subsum = 0;
			if (arr.length > 0 && arr[0].length() > 0) {
				if (isline1) {
					len = arr.length;
					colsum = new ArrayList<Integer>(len);
					for (String s: arr) {
						val = Integer.valueOf(s).intValue();
						subsum += val;
						colsum.add(val);
					}
					isline1 = false;
				} else {
					String s;
					for (int i=0; i<len; i++) {
						s = arr[i];
						val = Integer.valueOf(s).intValue();
						subsum += val;
						colsum.set( i, (colsum.get(i) + val) );
//						colsum[i] += Integer.valueOf(s).intValue();
					}
				}
//				for (String s: arr) {
//					subsum += Integer.valueOf(s).intValue();
//				}
//				System.out.println("\n\t subsum:\t" + subsum);
				if (sum == 0) {
					sum = subsum;
//					System.out.println("\n sum:\t" + sum);
				} else {
					checkrow = (subsum == sum);
//					if (!check) {
//						return check;
//					}
				}
			}
//			System.out.println("\n" + line);
//			System.out.println((int) (arr.length/3));
			line = file.line();
		}
//		System.out.println();
		for (int i=0; i<len; i++) {
//			System.out.println("\n\t" + colsum.get(i) + "\n");
			if (i == 0) {
				val = colsum.get(i);
				checkcol = true;
			} else {
				checkcol = checkcol && (colsum.get(i) == val);
			}
		}
		check = (checkrow && checkcol && (sum == val));
		return check;
	}

	private static boolean checkMagicColumns(readFile file) throws IOException {
		boolean check = false;
		String line = file.line();
		String[] arr;
		ArrayList<Integer> colsum = new ArrayList<Integer>();
		int len = 0;
		boolean isline1 = true;
		while (line != null) {
			arr = line.split("\t");
			if (arr.length > 0 && arr[0].length() > 0) {
				if (isline1) {
					len = arr.length;
					colsum = new ArrayList<Integer>(len);
					for (String s: arr) {
						colsum.add(Integer.valueOf(s).intValue());
					}
					isline1 = false;
				} else {
					String s;
					for (int i=0; i<len; i++) {
						s = arr[i];
						colsum.set( i, (colsum.get(i) + Integer.valueOf(s).intValue()) );
//						colsum[i] += Integer.valueOf(s).intValue();
					}
				}
			}
			line = file.line();
		}
		int val = 0;
		for (int i=0; i<len; i++) {
//			System.out.println("\n\t" + colsum.get(i) + "\n");
			if (i == 0) {
				val = colsum.get(i);
				check = true;
			} else {
				check = check && (colsum.get(i) == val);
			}
		}
		return check;
	}

	private static boolean checkMagicDiagonals(readFile file) throws IOException {
		return false;
	}
	
	public static void main(String args[]) throws FileNotFoundException, IOException {
		readFile file1 = new readFile("./files/Luna.txt");
		readFile file2 = new readFile("./files/Mercury.txt");
		
		//	check Luna
		System.out.println("\n\n\t\tLuna row + column magic?\t" + checkMagic(file1));
//		System.out.println("\n\n\t\tLuna column magic?\t" + checkMagicColumns(file1));
		//	check Mercury
		System.out.println("\n\n\t\tMercury row + column magic?\t" + checkMagic(file2) + "\n\n");
//		System.out.println("\n\n\t\tMercury column magic?\t" + checkMagicColumns(file2));

//		System.out.println("\n" + afile.line());
//		System.out.println((afile.line()==null) + "\n");
//		System.out.println(afile.line() + "\n");
	}
}
