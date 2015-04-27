package launchers;

public class ThreadTimer extends Thread {

	private int delay;
	private Runnable action;
	private int actions;
	private boolean forever = false;
	private boolean running = false;
	public static int FOREVER = -1;
	
	public ThreadTimer(int interval, Runnable run, int times){
		delay = interval;
		action = run;
		actions = times;
		forever = (times == FOREVER);
		running = true;
		this.start();
	}
	
	public void run(){
		while (actions > 0 || forever){
			try{
				Thread.sleep(delay);
			}
			catch (Exception e) {
				running = false;
				return;
			}
			action.run();
			if (!forever){
				actions--;
			}
		}
		running = false;
		return;
	}
	
	public void Stop(){
		running = false;
		actions = -1;
		this.interrupt();
	}
	
	public boolean isRunning(){
		return running;
	}
	
}