package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;

import model.Account;
import view.View;

/**
 * ������ ������ ��������� �������� ������, � ����� ���������� ������� �
 * ��������� ����
 *
 */
public class AccountController {
	View view;
	Account account = new Account();
	// ����, �� �������� �������� ��������� ���� ��� ������
	private final File fileForWriting = new File("accounting/purchases.txt");

	public AccountController(View view) {
		this.view = view;
		initButtons();
	}

	/**
	 * ��������� ���������� � �������
	 */
	private void initButtons() {
		view.getAdd10CopButton().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				cashAdding(Account.TEN_COPS);
			}
		});

		view.getAdd20CopButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

				cashAdding(Account.TWENTY_COPS);
			}
		});

		view.getAdd50CopButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cashAdding(Account.FIFTY_COPS);
			}
		});

		view.getAdd1RublButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cashAdding(Account.ONE_RUBLE);
			}
		});

		view.getAdd2RublsButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cashAdding(Account.TWO_RUBLES);
			}
		});

		view.getAdd5RublsButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cashAdding(Account.FIVE_RUBLES);
			}
		});

		view.getAdd10RublsButton().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				cashAdding(Account.TEN_RUBLES);
			}
		});

		view.getAdd20RublsButton().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				cashAdding(Account.TWENTY_RUBLES);
			}
		});

		view.getReturnChangeButton().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				cashTaking();
			}
		});
	}

	/**
	 * @param cash
	 *            ����� ��� ���������� ����� � ��������� �����. ����������
	 *            �������� ������ ���������� �����
	 */
	public void cashAdding(BigDecimal cash) {
		// ������ �������� �����
		account.setValue(account.getValue().add(cash));
		// ���������� �������� ����� ������ ��� ������
		view.showProcess("����� ������", 15);
		// ���������� �������� ����� �� ������ ����� ��� ������������
		view.getCashLabel().setText(account.getValue().toString());
	}

	/**
	 * ����� ��� ��������� ����� � �������� �����. ���������� �������� ������
	 * "�������"
	 */
	public void cashTaking() {
		account.setValue(new BigDecimal("0.00"));
		view.showProcess("������� �����", 15);
		view.getCashLabel().setText(account.getValue().toString());
	}

	/**
	 * @param cash
	 * @return ���� ���������� ������� ��� �������, �������� �� ����� ���������
	 *         ������� ����� ��������� �������� �� ������ ����� ��� ������������
	 */
	public boolean calculatePurchase(BigDecimal cash) {
		int comparing = account.getValue().compareTo(cash);
		if (comparing < 0) {
			view.showNotEnoughMoneyDialog();
			return false;
		} else {
			account.setValue(account.getValue().subtract(cash));
			view.getCashLabel().setText(account.getValue().toString());
			return true;
		}
	}

	/**
	 * @param text
	 *            ����� ���������� ���������� ������ � ��������� ���� �� �������
	 *            �����
	 */
	public void purchaseWriteToFile(String text) {
		try (FileWriter writer = new FileWriter(fileForWriting, true)) {
			writer.write(text + "\r\n");
		} catch (IOException ex) {
			view.writingError();
		}
	}
}
