import java.io.*;
import java.util.*;

class MultiThreadedProgram implements Runnable
{
	@Override
	public void run()
	{

		for (int i = 0; i <= 100; i++)
		{
			System.out.println(" Thread name is: " + Thread.currentThread().getName() + " " + i);
		}
	}

}

public class Q1
{
	public static void main(String[] args)
	{
		MultiThreadedProgram t = new MultiThreadedProgram();
		Thread t1 = new Thread(t, "Thread1");
		Thread t2 = new Thread(t, "Thread2");
		Thread t3 = new Thread(t, "Thread3");
		t1.start();
		t2.start();
		t3.start();

	}

}