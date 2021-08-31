package javaIntro_6_Task_4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Practice04_Main_Multithreading_Port {

	public static void main(String[] args) {

		/*
		 * Задание 4. Многопоточность. Порт. Корабли заходят в порт для разгрузки/загрузки
		 * контейнеров. Число контейнеров, находящихся в текущий момент в порту и на корабле,
		 * должно быть неотрицательным и непревышающим заданную грузоподъемность судна и
		 * вместимость порта. В порту работает несколько причалов. У одного причала может
		 * стоять один корабль. Корабль может загружаться у причала или разгружаться.
		 */

        Port port = new Port(4);

        ShipGenerator shipGenerator = new ShipGenerator(port, 16);

        PierOperation pier1 = new PierOperation(port);
        PierOperation pier2 = new PierOperation(port);
        PierOperation pier3 = new PierOperation(port);
        PierOperation pier4 = new PierOperation(port);

        ExecutorService service = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        service.execute(shipGenerator);
        service.execute(pier1);
        service.execute(pier2);
        service.execute(pier3);
        service.execute(pier4);

        service.shutdown();
	}

}
