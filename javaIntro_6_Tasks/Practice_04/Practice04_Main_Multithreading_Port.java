package javaIntro_6_Task_4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Practice04_Main_Multithreading_Port {

	public static void main(String[] args) {

		/*
		 * ������� 4. ���������������. ����. ������� ������� � ���� ��� ���������/��������
		 * �����������. ����� �����������, ����������� � ������� ������ � ����� � �� �������,
		 * ������ ���� ��������������� � ������������� �������� ���������������� ����� �
		 * ����������� �����. � ����� �������� ��������� ��������. � ������ ������� �����
		 * ������ ���� �������. ������� ����� ����������� � ������� ��� ������������.
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
