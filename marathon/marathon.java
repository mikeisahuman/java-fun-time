// Marathon Winner: finding the winner(s) of a race

public class marathon {
	public static int winner (int[] times) {
		// return the index for the winest time in the given array
		int iwin = 0;
		int win = times[iwin];
		//System.out.println("\ninitial win:\t" + win + "\n");
		for (int i=0; i<times.length; i++) {
			if (times[i] < win) {
				iwin = i;
				win = times[i];
				//System.out.println("new win:\t" + win + "\n");
			}
		}
		return iwin;
	}

	public static int second (int[] times) {
		// return the index for the second place
		if (times.length < 2) {
			System.out.println("\n\tError: no second-place available.\n");
			return -1;
		}
		int iwin = winner(times);
		int win = times[iwin];
		int isec = 0;
		int sec = times[isec];
		for (int i=0; i<times.length; i++) {
			if (times[i] < sec && i != iwin) {
				isec = i;
				sec = times[i];
			}
		}
		return isec;
	}

	public static void main (String[] args) {
		String[] names = {"Elena", "Thomas", "Hamilton", "Suzie", "Phil", "Matt", "Alex", "Emma", "John", "James", "Jane", "Emily", "Daniel", "Neda", "Aaron", "Kate"};		
		int[] times = {341, 273, 278, 329, 445, 402, 388, 275, 243, 334, 412, 393, 299, 343, 317, 265};

		int w = winner(times);
		System.out.println("\nWinner: " + names[w] + " with a time of " + times[w] + "\n");

		int s = second(times);
		System.out.println("Second: " + names[s] + " with a time of " + times[s] + "\n");
	}
}