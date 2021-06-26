package Assignments;

public class MyRunnableThread implements Runnable {
	
	public static int myCount=0;
	public MyRunnableThread(){
		
	}
	public void run(){
		while(MyRunnableThread.myCount<=10){
			try{
				  Thread.sleep(100);
				  }
			catch (InterruptedException iex) {
		System.out.println("Exception in thread:"+iex.getMessage());
		}
	}
	}
	public static void main(String[] args) {
		System.out.println("Starting Main Thread....");
		MyRunnableThread mrt = new MyRunnableThread();
		Thread t = new Thread(mrt);
		t.start();
		while(MyRunnableThread.myCount<=10){
			try{
				System.out.println("My Thread:"+(++MyRunnableThread.myCount));
				Thread.sleep(100);
			}
			catch(InterruptedException iex){
				System.out.println("Exception in main thread:");
			}
				
		}
		

	}

}