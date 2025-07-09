package com.example.volatilex;// Java Program to demonstrate the
// use of Volatile Keyword in Java

public class VolatileTest {
	private static  int MY_INT = 0;

	public static void main(String[] args)
	{
		new ChangeMaker().start();
		new ChangeListener().start();

	}

	static class ChangeListener extends Thread {
		@Override public void run()
		{
			int local_value = MY_INT;
			while (local_value < 5) {
				if (local_value != MY_INT) {
					System.out.println(String.format(
						"Got Change for MY_INT : %s",
						MY_INT));
					local_value = MY_INT;
				}
			}
		}
	}

	static class ChangeMaker extends Thread {
		@Override public void run()
		{
			int local_value = MY_INT;
			while (MY_INT < 5) {
				System.out.println(String.format(
						"Incrementing MY_INT to %s",
						local_value + 1));
				MY_INT = ++local_value;
				try {
					Thread.sleep(500);
				}
				catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
