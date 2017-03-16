/*	Java Training Assignment 5
	Date 3/15/2017
	Organizer: Jeshal Mehta
	Participant : Rehnuma Taraannum
	tarannum.rehnuma@gmail.com
*/
public class DemoSynchronization {
	/*	Accessed by t1, t2
	*/
	private static int count=0;
	
	/*	Accessed by t3, t4
	*/
	private static int counter=0;
	
	/*	The Synchronized Method
	 */
	public static synchronized void incount() {
		counter++;
	}
	public static void main(String[] args) {
		/*	Creating Threads t1, t2, t3, t4
		 * 	t1 and t2 will both access the static int count
		 * 	t3 and t4 will access the static int counter
		 * */
		Thread t1 = new Thread(new Runnable() {
			
			public void run() {
				for (int i = 0; i < 10000; i++) {
					count++;
				}
				
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			
			public void run() {
				for (int i = 0; i < 10000; i++) {
					count++;
				}
				
			}
		});
		
		Thread t3 = new Thread(new Runnable() {
			
			public void run() {
				for (int i = 0; i < 10000; i++) {
					incount();
				}
				
			}
		});
		
		Thread t4 = new Thread(new Runnable() {
			
			public void run() {
				for (int i = 0; i < 10000; i++) {
					incount();
				}
				
			}
		});
		
		/*	Starting the threads
		 */
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		/* 	I am only calling the join method on t3,t4 
		 * 	so we can observe the effects of synchronization 
		 * 	on threads.
		 */
		try {
			t3.join();
			t4.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Java Training Assignment 5: Synchronization Demo with multiple Threads\n");
		System.out.println("\tCREATED BY REHNUMA TARANNUM\n");
		/*	Observe with each excecution we will get different values 
		 *	for the first print out since its not synchronized
		 */
		System.out.println("Value of Counter without joining the Threads: "+count);

		/*	Observe with each excecution we will get same value
		 *	for the second print out since it is synchronized
		 */
		System.out.println("Value of Counter after joining the Threads: "+counter);
	}
	
	

}
