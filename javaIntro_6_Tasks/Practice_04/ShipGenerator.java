package javaIntro_6_Task_4;

public class ShipGenerator implements Runnable{
	
	private Port port;
	private int maxCount;
	
	public ShipGenerator(Port port, int maxCount) {
		this.port = port;
		this.maxCount = maxCount;
	}
	
	@Override
	public void run() {
		int shipCount = 0;
		while (shipCount < maxCount) {
			Thread.currentThread().setName("NewShipGenerator");
			shipCount++;
			
			int capacity = (int) (Math.random()*90 + 10);
			int count = (int) (Math.random()*(capacity+1));

			port.newShip(new Ship(capacity, count));

			try {
				Thread.sleep(2000);
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
