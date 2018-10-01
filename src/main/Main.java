package main;

import beverageCreator.BeverageCreator;
import controller.MachineController;
import model.Machine;
import view.View;

/**
 * ��������� ��������� ��������� ��������� �������� ����� ��������� �� �������
 * ������ ��� ������� � ������� ������ ������� ����� ����� �������� �����
 * ������� � ������ {@link BeverageCreator} � ������������� � ����, �������
 * ����� ����� ��������� �� ������ ����� ��������� ���������� � ��������� ����
 * ����, ����� ���� �������, � ����� �������� � ���� �������, ������� ������
 * 
 *
 */
public class Main {

	public static void main(String[] args) {
		// ������ ������ �������� ���� view
		View view = new View();
		// ������� ����� ������
		Machine machine = new Machine();
		// ������� ������ ����������� � �������� ��� ������ � ������� ���
		MachineController mc = new MachineController(view, machine);
		mc.go();

		// 7 �������� ��� ������� � �������� ��� ����������
		// createBeverages();
	}

	private static void createBeverages() {
		BeverageCreator.createAmericano();
		BeverageCreator.createEspresso();
		BeverageCreator.createCapuccino();
		BeverageCreator.createHotChocolate();
		BeverageCreator.createLatte();
		BeverageCreator.createTea();
		BeverageCreator.createIceCoffee();
	}

}
