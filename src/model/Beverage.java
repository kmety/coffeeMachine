package model;

import java.io.Serializable;

public abstract class Beverage implements Serializable {

	private final String name;
	private final String price;

	public Beverage(String name, String price) {
		this.name = name;
		this.price = price;
	}

	/**
	 * � ���� ����������� ������ ����� ���������� ���, ����� ���������� ���
	 * ������������� ����� ����� �������
	 */
	public abstract void instructions();

	public String getName() {
		return name;
	}

	public String getPrice() {
		return price;
	}
}
