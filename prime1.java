import java.util.*;
import java.lang.*;

class prime1 
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
		int num_of_test = sc.nextInt();
		int[][] testcases = new int[num_of_test][2];
		int upperbound = 0;
		for (int i=0;i<num_of_test;i++) {
		    testcases[i][0] = sc.nextInt();
		    testcases[i][1] = sc.nextInt();
		    if (upperbound < testcases[i][1]) {
			upperbound = testcases[i][1];
		    }
		}

		boolean[] list = sieveofe(upperbound);

		for (int i=0;i<num_of_test;i++) {
			for (int j=testcases[i][0];j<=testcases[i][1];j++) {
				if (!list[j]) {
					System.out.println(j);
				}
			}
			System.out.println();
		}
	}

	public static boolean[] sieveofe(int upper_bound) {
		int max_multiple = (int)Math.sqrt(upper_bound);
		boolean[] list = new boolean[upper_bound + 1];
		for (int i=4;i<=upper_bound;i+=2) {
			list[i] = true;
		}
		list[1] = true;
		
		for (int i=3;i<=max_multiple;i+=2) {
			if (!list[i]) {
				for (int j=i*i;j<=upper_bound;j+=i) {
					list[j] = true;
				}
			}
		}

		return list;
	}
}
