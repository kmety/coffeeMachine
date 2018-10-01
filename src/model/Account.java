package model;

import java.math.BigDecimal;

/**
 * ����� �������� ���� value ��� �������� �������� ���������� ������� �� ����� �
 * ���������, ������� ������� ������������� �������
 *
 */
public class Account {

	private BigDecimal value = new BigDecimal(0);

	public static final BigDecimal TEN_COPS = new BigDecimal("0.10");
	public static final BigDecimal TWENTY_COPS = new BigDecimal("0.20");
	public static final BigDecimal FIFTY_COPS = new BigDecimal("0.50");
	public static final BigDecimal ONE_RUBLE = new BigDecimal("1.00");
	public static final BigDecimal TWO_RUBLES = new BigDecimal("2.00");
	public static final BigDecimal FIVE_RUBLES = new BigDecimal("5.00");
	public static final BigDecimal TEN_RUBLES = new BigDecimal("10.00");
	public static final BigDecimal TWENTY_RUBLES = new BigDecimal("20.00");

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}
}
