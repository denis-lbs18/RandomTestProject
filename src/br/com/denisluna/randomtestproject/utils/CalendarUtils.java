package br.com.denisluna.randomtestproject.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class CalendarUtils {
	private Calendar calendario;

	public void setHora() {
		Date date = new Date();
		this.calendario = GregorianCalendar.getInstance();

		this.calendario.setTime(date);
		this.calendario.get(Calendar.HOUR_OF_DAY);
		this.calendario.get(Calendar.HOUR);
		this.calendario.get(Calendar.MONTH);
	}

	public void adicionaHora(int horas) {
		this.calendario.set(Calendar.HOUR, this.getHora() + 1);
	}

	private int getHora() {
		return this.calendario.get(Calendar.HOUR);
	}

	public void escreveHora() {
		System.out.println(this.calendario.getTime());
	}

	public Date getTime() {
		return this.calendario.getTime();
	}

	private Date ontem() {
		final Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -1);
		return cal.getTime();
	}

	public String getDataOntem() {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		return dateFormat.format(this.ontem());
	}

	public int getDia() {
		DateFormat dateFormat = new SimpleDateFormat("dd");
		return Integer.parseInt(dateFormat.format(this.ontem()));
	}
}
