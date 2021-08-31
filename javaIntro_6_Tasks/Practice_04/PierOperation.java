package javaIntro_6_Task_4;

public class PierOperation implements Runnable {
	
	private Port port;
	
	public PierOperation(Port port) {
		this.port = port;
	}
	
	@Override
	public void run() {
		
		while (true) {
			
			try {
				Thread.currentThread().setName("ShipLoadUnload");

				Thread.sleep(500);
				Ship ship = port.getShip();
				
				int operation = (int) (Math.random()*2);
				
				if (ship != null ) {
					if (operation == 0) {
						while (!ship.isEmpty()) {
							Thread.sleep(100);
							ship.unloadShip(1);
							System.out.println(ship.getCount() + " containers left to unload. Thread: " + Thread.currentThread().getName());
						}
					}
					else if (operation == 1) {
						while (!ship.isLoaded()) {
		                    Thread.sleep(100);
		                    ship.loadShip(1);
		                    System.out.println(ship.getCount() + " containers loaded. Thread: " + Thread.currentThread().getName());
						}
					}
				}
			} catch (InterruptedException e) {
                e.printStackTrace();
            }
		}
	}

}
