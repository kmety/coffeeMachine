package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import model.Account;
import model.Beverage;
import model.Machine;
import view.View;

/**
 * ������� ����� ��� ���������� �������� ���������
 */
public class MachineController {
	View view;
	Account account = new Account();
	AccountController accController;
	Machine machine;

	public MachineController(View view, Machine machine) {
		this.view = view;
		this.machine = machine;
	}

	public void go() {
		accController = new AccountController(view);
		// �������������� ������ "������" �� ������� �������
		bueButtonsInit();
		// �������������� ���� ���
		menuBarInit();
	}

	/**
	 * ��������� ���������� � ������� "������" ������ ��������� ���������,
	 * ���������� �� ������� ��� �������, ����� �������� ����� make()
	 */
	private void bueButtonsInit() {
		view.getBueButtons()[0].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (accController.calculatePurchase(new BigDecimal(machine.getBeverageList().get(0).getPrice()))) {
					make(machine.getBeverageList().get(0));
				}
			}
		});

		view.getBueButtons()[1].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (accController.calculatePurchase(new BigDecimal(machine.getBeverageList().get(1).getPrice()))) {
					make(machine.getBeverageList().get(1));
				}
			}
		});

		view.getBueButtons()[2].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (accController.calculatePurchase(new BigDecimal(machine.getBeverageList().get(2).getPrice()))) {
					make(machine.getBeverageList().get(2));
				}
			}
		});

		view.getBueButtons()[3].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (accController.calculatePurchase(new BigDecimal(machine.getBeverageList().get(3).getPrice()))) {
					make(machine.getBeverageList().get(3));
				}
			}
		});

		view.getBueButtons()[4].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (accController.calculatePurchase(new BigDecimal(machine.getBeverageList().get(4).getPrice()))) {
					make(machine.getBeverageList().get(4));
				}
			}
		});

		view.getBueButtons()[5].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (accController.calculatePurchase(new BigDecimal(machine.getBeverageList().get(5).getPrice()))) {
					make(machine.getBeverageList().get(5));
				}
			}
		});
	}

	/**
	 * ��������� ���������� � ��������� ����
	 */
	private void menuBarInit() {
		importBeverageInit();
		removeBeverageInit();
		aboutInit();
		exitInit();
	}

	private void importBeverageInit() {
		view.getImportBeverage().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				addBeverage();
			}
		});
	}

	private void removeBeverageInit() {

		view.getRemoveBeverage().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				removeBeverage();
			}
		});
	}

	private void aboutInit() {
		view.getAbout().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				view.showAboutDialog();
			}
		});

	}

	private void exitInit() {
		view.getExit().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}

	/**
	 * @param beverage
	 *            ����� ��������� �������������� ���������� �� ������� �������,
	 *            ����� ������� �������� �������������, ����� �������� ����� ���
	 *            ������ ������ � ��������� ����
	 */
	public void make(Beverage beverage) {
		beverage.instructions();
		view.showBeverageMaking(beverage.getName());
		accController.purchaseWriteToFile(new StringBuilder(getCurrentTime()).append(" ������ ")
				.append(beverage.getName()).append(" ").append(beverage.getPrice()).toString());
	}

	/**
	 * @return ����� ���������� ������ � ������� ����� � ��������
	 */
	public String getCurrentTime() {
		Date dateNow = new Date();
		SimpleDateFormat formatForDateNow = new SimpleDateFormat("E dd.MM.yyyy '�' HH:mm:ss");
		return formatForDateNow.format(dateNow);
	}

	/**
	 * ���� �� ������� ������ ��� ���� �����, ��������� ����� ��� ������� ��
	 * ������
	 */
	public void addBeverage() {
		if (machine.getBeverageList().size() == 6) {
			view.showNoMoreAddingDialog();
			return;
		}
		Beverage beverage;
		File file = view.chooseFile();
		if (file != null) {
			try (FileInputStream fis = new FileInputStream(file); ObjectInputStream oin = new ObjectInputStream(fis);) {
				beverage = (Beverage) oin.readObject();
				if (beverage == null) {
					return;
				}
				machine.getBeverageList().add(beverage);
				updatePanels();
			} catch (ClassNotFoundException | IOException e) {
				view.showReadErrorDialog();
			}
		}
	}

	/**
	 * @param filePath
	 *            ������������� �����, ����������� �������� ������� �� �������
	 *            ������ �� ���������� ������, ��� ������������� JFileChooser
	 */
	public void addBeverage(String filePath) {
		if (machine.getBeverageList().size() > 6) {
			view.showNoMoreAddingDialog();
			return;
		}
		Beverage beverage = null;
		try (FileInputStream fis = new FileInputStream(filePath); ObjectInputStream oin = new ObjectInputStream(fis);) {
			beverage = (Beverage) oin.readObject();
			machine.getBeverageList().add(beverage);
			updatePanels();
		} catch (IOException | ClassNotFoundException e) {
			view.showReadErrorDialog();
		}
	}

	/**
	 * ���� �� ������� ������ ���� ���� ���� �������, ������� ������� ��
	 * ����������� ������, ������� ������� ������������
	 */
	public void removeBeverage() {
		if (machine.getBeverageList().size() == 0) {
			view.showListIsEmptyDialog();
			return;
		}
		// ������� ������ ��������� ���������� ������� ��� �������� ��
		// ������������ ��� ������
		String[] bevAmount = new String[machine.getBeverageList().size()];
		for (int i = 0; i < machine.getBeverageList().size(); i++) {
			bevAmount[i] = new Integer(i + 1).toString();
		}
		// ������ ������������ ������� ����� ���������� �������
		int position = view.askNumberToRemove(bevAmount) - 1;
		// ���������� ��������, ���� ������������ ������ �� ������ � �����
		// ������
		if (position < 0) {
			return;
		}
		// ������� ��������� ���� � ��������� ������
		String removedSortName = machine.getBeverageList().get(position).getName();
		machine.getBeverageList().remove(position);
		view.showSortRemovedDialog(removedSortName);
		updatePanels();
	}

	/**
	 * �����, � ����������� �� ����, ������� ������� ������� ����� �������
	 * ������������, ������������� ��� �������� ������� setVisible(true)
	 */
	public void updatePanels() {
		view.hidePanels();
		for (int i = 0; i < machine.getBeverageList().size(); i++) {
			view.getNames()[i].setText(machine.getBeverageList().get(i).getName());
			view.getPrices()[i].setText(machine.getBeverageList().get(i).getPrice());
			view.getBeveragePanels()[i].setVisible(true);
		}
	}
}
