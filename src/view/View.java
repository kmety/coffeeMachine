package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

public class View extends JFrame {

	// ������� ��������� �������� ��� ������
	private static final String BUE = "������";
	private static final String PLUS_10COP = "10 ���";
	private static final String PLUS_20COP = "20 ���";
	private static final String PLUS_50COP = "50 ���";
	private static final String PLUS_1RUBL = "1 ���";
	private static final String PLUS_2RUBLS = "2 ���";
	private static final String PLUS_5RUBLS = "5 ���";
	private static final String PLUS_10RUBLS = "10 ���";
	private static final String PLUS_20RUBLS = "20 ���";
	private static final String RETURN_CHANGE = "�������";

	// ������� ������ ������� ������ � � ����������
	JPanel mainPanel = new JPanel();
	JPanel beveragePanels[] = new JPanel[6];
	JLabel names[] = new JLabel[6];
	JLabel prices[] = new JLabel[6];
	JButton bueButtons[] = new JButton[6];

	// ������� ������ ������ ��������� ����� � � ����������
	JPanel accountPanel = new JPanel();
	JLabel cashLabel = new JLabel("0.00");
	JButton add10CopButton = new JButton(PLUS_10COP);
	JButton add20CopButton = new JButton(PLUS_20COP);
	JButton add50CopButton = new JButton(PLUS_50COP);
	JButton add1RublButton = new JButton(PLUS_1RUBL);
	JButton add2RublsButton = new JButton(PLUS_2RUBLS);
	JButton add5RublsButton = new JButton(PLUS_5RUBLS);
	JButton add10RublsButton = new JButton(PLUS_10RUBLS);
	JButton add20RublsButton = new JButton(PLUS_20RUBLS);
	JButton returnChangeButton = new JButton(RETURN_CHANGE);

	// ������� ������� ����
	JMenuBar menuBar = new JMenuBar();
	JMenu menu = new JMenu("����");
	JMenuItem importBeverage = new JMenuItem("�������� ����");
	JMenuItem removeBeverage = new JMenuItem("������� ����");
	JMenuItem about = new JMenuItem("� ���������");
	JMenuItem exit = new JMenuItem("�����");

	public View() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(1300, 670));
		// ����� �������� ������������� ���� �������
		init();
		pack();
		setLocationRelativeTo(null);
		this.setVisible(true);
	}

	private void init() {
		initMenuBar();
		initMainPanel();
		initAccountPanel();
	}

	/**
	 * �������������� ���� � ��������� �� ������� �����
	 */
	private void initMenuBar() {
		menu.add(importBeverage);
		menu.add(removeBeverage);
		menu.add(about);
		menu.add(exit);
		menuBar.add(menu);
		this.getContentPane().add(menuBar, BorderLayout.NORTH);
	}

	/**
	 * �������������� ������� ������ � ��������� � �� ������� ����� �� �������
	 * ������ ����� ���������� 6 ������� ��� ��������
	 * 
	 */
	/**
	 * 
	 */
	private void initMainPanel() {

		Font BigFont = new Font("Verdana", Font.BOLD, 30);
		mainPanel.setLayout(new GridLayout(2, 3));
		mainPanel.setBackground(new Color(196, 171, 137));

		// ����� ������� �������� � �����
		for (int i = 0; i < 6; i++) {
			bueButtons[i] = new JButton(BUE);
			bueButtons[i].setFont(BigFont);
		}

		// ������ �������� ������� ����� � ����
		for (int i = 0; i < 6; i++) {
			names[i] = new JLabel();
			names[i].setFont(BigFont);
			names[i].setForeground(Color.WHITE);
		}

		// ������ ���� ������� ����� � ����
		for (int i = 0; i < 6; i++) {
			prices[i] = new JLabel();
			prices[i].setFont(BigFont);
			prices[i].setForeground(Color.WHITE);
		}

		// ��� ����, ����� ������ ������ ������ ������� ��� �� �����������,
		// ������ �������
		// ��������� ������������ �� JPanel � ���������������� �������
		// paintComponent()
		for (int i = 0; i < 6; i++) {
			beveragePanels[i] = new JPanel() {
				public void paintComponent(Graphics g) {
					Image im = null;
					try {
						im = ImageIO.read(new File("images/image1.jpg"));
					} catch (IOException e) {
						JOptionPane.showMessageDialog(this, "������ ��� ����������� �����������");
					}
					g.drawImage(im, 0, 0, null);
				}
			};
			// �������� �� ������ ������ ������� ����� ��������� � �������
			// GridBagLayout
			GridBagLayout beveragePanelLayout = new GridBagLayout();
			beveragePanels[i].setLayout(beveragePanelLayout);
			GridBagConstraints c = new GridBagConstraints();
			c.anchor = GridBagConstraints.CENTER;
			c.fill = GridBagConstraints.NONE;
			c.gridheight = 1;
			c.gridwidth = 1;
			c.gridx = 0;
			c.gridy = 0;
			c.insets = new Insets(0, 0, 0, 0);
			c.ipadx = 0;
			c.ipady = 0;
			c.weightx = 0;
			c.weighty = 1;
			beveragePanelLayout.setConstraints(names[i], c);
			// ��������� �������� ������� �� ������ �������
			beveragePanels[i].add(names[i]);

			c.gridy = 1;
			c.insets = new Insets(0, 0, 30, 0);
			beveragePanelLayout.setConstraints(prices[i], c);
			// ��������� ���� ������� �� ������ �������
			beveragePanels[i].add(prices[i]);

			c.gridy = 2;
			c.insets = new Insets(100, 0, 0, 0);
			beveragePanelLayout.setConstraints(bueButtons[i], c);
			// ��������� ������ "������" �� ������ �������
			beveragePanels[i].add(bueButtons[i]);
			// ��������� ������������������ ������ ������� �� ������� ������
			mainPanel.add(beveragePanels[i]);
		}
		// ������ ��� ������ ����������
		hidePanels();
		// ��������� ������� ������ �� ������� �����
		this.getContentPane().add(mainPanel);
	}

	public void hidePanels() {
		for (JPanel temp : beveragePanels) {
			temp.setVisible(false);
		}
	}

	private void initAccountPanel() {
		Font accountButtonsFont = new Font("Verdana", Font.BOLD, 20);
		Font accountCashLabelFont = new Font("Verdana", Font.BOLD, 40);
		Dimension buttonsDimension = new Dimension(120, 40);
		// ��������� ����������� ������ ��������� ����� ������ � �������
		cashLabel.setFont(accountCashLabelFont);
		add10CopButton.setFont(accountButtonsFont);
		add10CopButton.setPreferredSize(buttonsDimension);
		add20CopButton.setFont(accountButtonsFont);
		add20CopButton.setPreferredSize(buttonsDimension);
		add50CopButton.setFont(accountButtonsFont);
		add50CopButton.setPreferredSize(buttonsDimension);
		add1RublButton.setFont(accountButtonsFont);
		add1RublButton.setPreferredSize(buttonsDimension);
		add2RublsButton.setFont(accountButtonsFont);
		add2RublsButton.setPreferredSize(buttonsDimension);
		add5RublsButton.setFont(accountButtonsFont);
		add5RublsButton.setPreferredSize(buttonsDimension);
		add10RublsButton.setFont(accountButtonsFont);
		add10RublsButton.setPreferredSize(buttonsDimension);
		add20RublsButton.setFont(accountButtonsFont);
		add20RublsButton.setPreferredSize(buttonsDimension);
		returnChangeButton.setFont(accountButtonsFont);

		// ��������� ���������� ������ ��������� ����� � ������� GridBagLayout
		GridBagLayout accountPanelLayout = new GridBagLayout();
		accountPanel.setLayout(accountPanelLayout);
		GridBagConstraints c = new GridBagConstraints();
		c.anchor = GridBagConstraints.CENTER;
		c.fill = GridBagConstraints.NONE;
		c.gridheight = 1;
		c.gridwidth = 2;
		c.gridx = 0;
		c.gridy = 0;
		c.insets = new Insets(35, 0, 0, 0);
		c.ipadx = 0;
		c.ipady = 0;
		c.weightx = 1;
		c.weighty = 1;
		accountPanelLayout.setConstraints(cashLabel, c);
		accountPanel.add(cashLabel);

		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 1;
		c.weighty = 0;
		accountPanelLayout.setConstraints(add10CopButton, c);
		accountPanel.add(add10CopButton);

		c.gridx = 1;
		c.gridy = 1;
		c.gridwidth = 1;
		accountPanelLayout.setConstraints(add20CopButton, c);
		accountPanel.add(add20CopButton);

		c.gridx = 0;
		c.gridy = 2;
		c.gridwidth = 1;
		accountPanelLayout.setConstraints(add50CopButton, c);
		accountPanel.add(add50CopButton);

		c.gridx = 1;
		c.gridy = 2;
		c.gridwidth = 1;
		accountPanelLayout.setConstraints(add1RublButton, c);
		accountPanel.add(add1RublButton);

		c.gridx = 0;
		c.gridy = 3;
		c.gridwidth = 1;
		accountPanelLayout.setConstraints(add2RublsButton, c);
		accountPanel.add(add2RublsButton);

		c.gridx = 1;
		c.gridy = 3;
		c.gridwidth = 1;
		accountPanelLayout.setConstraints(add5RublsButton, c);
		accountPanel.add(add5RublsButton);

		c.gridx = 0;
		c.gridy = 4;
		c.gridwidth = 1;
		accountPanelLayout.setConstraints(add10RublsButton, c);
		accountPanel.add(add10RublsButton);

		c.gridx = 1;
		c.gridy = 4;
		c.gridwidth = 1;
		accountPanelLayout.setConstraints(add20RublsButton, c);
		accountPanel.add(add20RublsButton);

		c.gridx = 0;
		c.gridy = 5;
		c.gridwidth = 2;
		c.insets = new Insets(35, 0, 35, 0);
		accountPanelLayout.setConstraints(returnChangeButton, c);
		accountPanel.add(returnChangeButton);
		accountPanel.setBackground(new Color(163, 163, 163));
		// ��������� ������ ��������� ����� �� ������� �����
		this.getContentPane().add(accountPanel, BorderLayout.EAST);
	}

	/**
	 * @param bevAmount
	 * @return ����� �������� ������ c ����������� �������� ��������� ��������
	 *         �� ������, � ���������� ������������ ������� ����� �������,
	 *         ������� �� ����� �������
	 */
	public int askNumberToRemove(String[] bevAmount) {
		Object result = JOptionPane.showInputDialog(this, "����� ���������� ������� :", "����� �������",
				JOptionPane.QUESTION_MESSAGE, null, bevAmount, bevAmount[0]);
		// ���� ������������ ����� ������, ���������� -1
		if (result == null) {
			return -1;
		}
		String positionString = (String) result;
		int position = Integer.parseInt(positionString);
		return position;
	}

	/**
	 * @param title
	 * @param time
	 *            ����� ��������� �������� ��� ������ ����-������
	 */
	public void showProcess(String title, long time) {
		JDialog dlg = new JDialog(this, title, true);
		dlg.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		dlg.setSize(300, 75);
		dlg.setLocationRelativeTo(this);
		Thread t = new Thread(new Runnable() {
			public void run() {
				dlg.setVisible(true);
			}
		});
		t.start();
		for (int i = 0; i <= 100; i++) {
			dlg.setTitle(title + " " + i + "...");
			if (i == 100) {
				dlg.setVisible(false);
			}
			try {
				Thread.sleep(time);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * @param beverageName
	 *            ����� ��������� �������� ��� ������������� �������
	 */
	public void showBeverageMaking(String beverageName) {
		JDialog dlg = new JDialog(this, "������������� �������", true);
		dlg.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		dlg.setSize(450, 75);
		dlg.setLocationRelativeTo(this);
		Thread t = new Thread(new Runnable() {
			public void run() {
				dlg.setVisible(true);
			}
		});
		t.start();
		for (int i = 0; i <= 100; i++) {
			dlg.setTitle(beverageName + "  ��������� " + i + " ...");
			if (i == 100) {
				dlg.setVisible(false);
			}
			try {
				Thread.sleep(25);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		JOptionPane.showMessageDialog(this, beverageName + " �����!");
	}

	/**
	 * @return ����� ��� ������ ������� ��� ���������� �� ������� ������ ��
	 *         ���������������� ����� ��������� JFileChooser
	 */
	public File chooseFile() {
		JFileChooser fileChoozer = new JFileChooser();
		fileChoozer.setCurrentDirectory(new File("coffeeTypes"));
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Beverage files", "cof");
		fileChoozer.setFileFilter(filter);
		int ret = fileChoozer.showDialog(null, "������� ����");
		if (ret == JFileChooser.APPROVE_OPTION) {
			File file = fileChoozer.getSelectedFile();
			return file;
		} else {
			return null;
		}
	}

	// ��������� ��������� ��� ������������
	public void showNotEnoughMoneyDialog() {
		JOptionPane.showMessageDialog(this, "������������ ������� ��� �������");
	}

	public void showNoMoreAddingDialog() {
		JOptionPane.showMessageDialog(this, "������ �������� ������ 6 �������� �� ������");
	}

	public void showAboutDialog() {
		JOptionPane.showMessageDialog(this, "� ���������...");
	}

	public void showReadErrorDialog() {
		JOptionPane.showMessageDialog(this, "������ ������ �����");
	}

	public void showSortRemovedDialog(String text) {
		JOptionPane.showMessageDialog(this, text + " ������");
	}

	public void showListIsEmptyDialog() {
		JOptionPane.showMessageDialog(this, "�� ������ ��� �� ������ ����� �������");
	}

	public void writingError() {
		JOptionPane.showMessageDialog(this, "������ ��� ������ � ��������� ����");
	}

	// ������� � �������
	public JPanel[] getBeveragePanels() {
		return beveragePanels;
	}

	public JLabel[] getNames() {
		return names;
	}

	public JLabel[] getPrices() {
		return prices;
	}

	public JButton[] getBueButtons() {
		return bueButtons;
	}

	public JLabel getCashLabel() {
		return cashLabel;
	}

	public void setCashLabel(JLabel cashLabel) {
		this.cashLabel = cashLabel;
	}

	public JButton getAdd10CopButton() {
		return add10CopButton;
	}

	public JButton getAdd20CopButton() {
		return add20CopButton;
	}

	public JButton getAdd50CopButton() {
		return add50CopButton;
	}

	public JButton getAdd1RublButton() {
		return add1RublButton;
	}

	public JButton getAdd2RublsButton() {
		return add2RublsButton;
	}

	public JButton getAdd5RublsButton() {
		return add5RublsButton;
	}

	public JButton getAdd10RublsButton() {
		return add10RublsButton;
	}

	public JButton getAdd20RublsButton() {
		return add20RublsButton;
	}

	public JButton getReturnChangeButton() {
		return returnChangeButton;
	}

	public JMenuItem getImportBeverage() {
		return importBeverage;
	}

	public JMenuItem getRemoveBeverage() {
		return removeBeverage;
	}

	public JMenuItem getAbout() {
		return about;
	}

	public JMenuItem getExit() {
		return exit;
	}
}
