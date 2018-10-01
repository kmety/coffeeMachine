package main;

import beverageCreator.BeverageCreator;
import controller.MachineController;
import model.Machine;
import view.View;

/**
 * программа имитирует интерфейс кофейного автомата можно добавлять на главную
 * панель или убирать с главной панели напитки новые сорта напитков можно
 * создать в классе {@link BeverageCreator} и сериализовать в файл, который
 * затем можно добавлять на панель также программа записывает в текстовый файл
 * дату, время всех покупок, а также название и цену напитка, который купили
 * 
 *
 */
public class Main {

	public static void main(String[] args) {
		// создаём объект внешнего вида view
		View view = new View();
		// создаем объет модели
		Machine machine = new Machine();
		// создаем объект контроллера и передаем ему модель и внешний вид
		MachineController mc = new MachineController(view, machine);
		mc.go();

		// 7 напитков уже созданы и доступны для добавления
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
