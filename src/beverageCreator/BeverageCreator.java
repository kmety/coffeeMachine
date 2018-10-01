package beverageCreator;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import model.Beverage;

/**
 * ����� ��� �������� ����� ������ �������� ����� ������������ �� ������������
 * ������ {@link Beverage} ���������� ������������ ����� ��������� ��������
 *
 */
public class BeverageCreator {

	public static void createEspresso() {
		try (FileOutputStream fos = new FileOutputStream("coffeeTypes/espresso.cof");
				ObjectOutputStream oos = new ObjectOutputStream(fos);) {
			Beverage espresso = new Beverage("��������", "1.50") {

				private static final long serialVersionUID = -5124203286878369874L;

				@Override
				public void instructions() {
					// ���������� �� ������������� ��������
				}
			};
			oos.writeObject(espresso);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void createAmericano() {
		try (FileOutputStream fos = new FileOutputStream("coffeeTypes/americano.cof");
				ObjectOutputStream oos = new ObjectOutputStream(fos);) {
			Beverage americano = new Beverage("���������", "1.80") {
				private static final long serialVersionUID = 8277308077840458658L;

				@Override
				public void instructions() {
					// ���������� �� ������������� ���������
				}
			};
			oos.writeObject(americano);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void createCapuccino() {
		try (FileOutputStream fos = new FileOutputStream("coffeeTypes/capuccino.cof");
				ObjectOutputStream oos = new ObjectOutputStream(fos);) {
			Beverage capuccino = new Beverage("��������", "1.90") {
				private static final long serialVersionUID = -5474021130172934190L;

				@Override
				public void instructions() {
					// ���������� �� ������������� ���������
				}
			};
			oos.writeObject(capuccino);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void createHotChocolate() {
		try (FileOutputStream fos = new FileOutputStream("coffeeTypes/hotChocolate.cof");
				ObjectOutputStream oos = new ObjectOutputStream(fos);) {
			Beverage hotChocolate = new Beverage("������� �������", "2.00") {
				private static final long serialVersionUID = -1786058071923149978L;

				@Override
				public void instructions() {
					// ���������� �� ������������� ���������
				}
			};
			oos.writeObject(hotChocolate);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void createLatte() {
		try (FileOutputStream fos = new FileOutputStream("coffeeTypes/latte.cof");
				ObjectOutputStream oos = new ObjectOutputStream(fos);) {
			Beverage latte = new Beverage("�����", "1.60") {
				private static final long serialVersionUID = 6768578462017014245L;

				@Override
				public void instructions() {
					// ���������� �� ������������� ���������
				}
			};
			oos.writeObject(latte);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void createTea() {
		try (FileOutputStream fos = new FileOutputStream("coffeeTypes/tea.cof");
				ObjectOutputStream oos = new ObjectOutputStream(fos);) {
			Beverage tea = new Beverage("���", "1.20") {
				private static final long serialVersionUID = 5238267018480427323L;

				@Override
				public void instructions() {
					// ���������� �� ������������� ���������
				}
			};
			oos.writeObject(tea);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void createIceCoffee() {
		try (FileOutputStream fos = new FileOutputStream("coffeeTypes/iceCoffee.cof");
				ObjectOutputStream oos = new ObjectOutputStream(fos);) {
			Beverage iceCoffee = new Beverage("Ice-����", "2.10") {
				private static final long serialVersionUID = 3994187105408575936L;

				@Override
				public void instructions() {
					// ���������� �� ������������� ���������
				}
			};
			oos.writeObject(iceCoffee);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
