// Foo Corp -- find total pay from hours worked and pay rate

public class FooCorp {
	public static double totalPay (double b, double h) {
		// initialize preset variables
		double basemin = 8.00;
		double hourmax = 60;
		double hourover = 40;
		double overfactor = 1.5;

		// initialize error messages
		String errPay = "\nError: pay rate must be at least " + basemin + ". (Given: " + b + ")\n";
		String errHours = "\nError: hours worked must be no more than " + hourmax + ". (Given: " + h + ")\n";

		// print intitial message
		String msg1 = "\n\tPay Rate:\t" + b;
		String msg2 = "\n\tHours Worked:\t" + h;
	
		System.out.println(msg1 + msg2);

		// test base, hours, then calculate total
		double res = -1;
		if (b < basemin) {
			System.out.println(errPay);
		} else if (h > hourmax) {
			System.out.println(errHours);
		} else {
			if (h <= hourover) {
				res = b * h;
			} else {
				double over = h - hourover;
				res = b * hourover;
				res += overfactor * b * over;
			}
		}

		// print resultant total (if no error occured)
		if (res >= 0) {
			String msgout = "\n\n\tTotal Pay:\t" + res;	
			System.out.println(msgout + "\n");
		}

		// return total pay (in case it's desired)
		return res;
	}

	public static void main(String[] args) {
		// test the function with a few values

		//totalPay(6.50, 55);
		//totalPay(8.25, 62);
		totalPay(7.80, 65);
		//totalPay(8.15, 60);
		totalPay(10.50, 38);
	}
}
