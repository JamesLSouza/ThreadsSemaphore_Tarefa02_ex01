package View;

import java.util.concurrent.Semaphore;
import Controller.ThreadsSemaforos;
public class Main
{
		public static void main(String[] args) 
		{
			Semaphore sem = new Semaphore(1);

			for (int threadId = 1; threadId <= 21; threadId++) 
			{
				Thread threadssemaforos = new ThreadsSemaforos(threadId, sem);
				threadssemaforos.start();
			}

		}
	}