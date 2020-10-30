import java.util.*;
class RandomSum implements Runnable
{
	private int sum;
	public RandomSum(int sum)
	{
		this.sum = sum;
	}
	public int getSum()
	{
		return sum;
	}
	@Override
	public void run()
	{
		getSum(sum);
	}

	public int getSum(int sum)
	{

		Random r = new Random();
		int value = r.nextInt(10)+1;
		System.out.println("random number: " + value);
		synchronized (this)
		{
			this.sum += value;
		}
		return this.sum;
	}

}
public class Q2
{

	public static void main(String[] args)
	{

		int baseSum = 0;
		RandomSum randomSum = new RandomSum(baseSum);
		Thread t1 = new Thread(randomSum);
		Thread t2 = new Thread(randomSum);
		Thread t3 = new Thread(randomSum);
		Thread t4 = new Thread(randomSum);
		Thread t5 = new Thread(randomSum);
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();

		try
		{
			t1.join();
			t2.join();
			t3.join();
			t4.join();
			t5.join();
		}
		catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Final sum: " + randomSum.getSum());
		System.out.println("main ends....!");
	}
}