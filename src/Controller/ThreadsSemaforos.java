package Controller;
import java.util.concurrent.Semaphore;


public class ThreadsSemaforos extends Thread 
{
	private int Id;
	private Semaphore semaforo;

	public ThreadsSemaforos(int threadId, Semaphore semaforo) 
	{
		this.Id = threadId;
		this.semaforo = semaforo;

	}

	public void run()
	{

		if (Id % 3 == 0)
		{
			calculo();
			transacao();
			calculo();
			transacao();
			calculo();
			transacao();
		}

		if (Id % 3 == 1)
		{
			calculo();
			transacao();
			calculo();
			transacao();
		}

		if (Id % 3 == 2)
		{
			calculo();
			transacao();
			calculo();
			transacao();
			calculo();
			transacao();
		}

	}

	public void calculo() 
	{
		int temp = 0;
		if (Id % 3 == 1) 
		{
			temp = (int) ((int) (Math.random() + 0.2) * Math.pow(10, 9));
		}
		else if (Id % 3 == 2) 
		{
			temp = (int) ((int) ((Math.random() * 1.6) + 0.5) * Math.pow(10, 9));
		}
		else if (Id % 3 == 0) 
		{
			temp = (int) ((int) ((Math.random() * 1.1) + 1) * Math.pow(10, 9));
		}
		
		System.out.println("Thread -> #" + Id + " está fazendo o cálculo .\n");

		try 
		{
			Thread.sleep(temp);
		} 
		catch (Exception error1)
		{
			error1.printStackTrace();
		}
	}
	public void transacao()
	{
		int temp = 0;

		if (Id % 3 == 1)
		{
			temp = 1000;
		}
		else if (Id % 3 == 2) 
		{
			temp = 1500;
		}
		
		else if (Id % 3 == 0)
		{
			temp = 1500;
		}

		try 
		{
			semaforo.acquire();
			System.out.println("Thread -> #" + Id + " está fazendo a transação.\n");
			Thread.sleep(temp);
		}
		catch (InterruptedException error) 
		{
			error.printStackTrace();
		}
		finally 
		{
			semaforo.release();
		}
		System.out.println("Thread -> #" + Id + " finalizou a transação.\n");
	}

}


