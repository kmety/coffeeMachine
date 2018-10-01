package model;

import java.util.ArrayList;

/**
 * Класс содержит только коллекцию напитков и метод для получения коллекции
 * напитков
 *
 */
public class Machine {

	private ArrayList<Beverage> beverageList = new ArrayList<>();

	public ArrayList<Beverage> getBeverageList() {
		return beverageList;
	}
}
