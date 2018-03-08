package br.com.denisluna.randomtestproject.utils;

import java.text.DateFormat;
import java.text.ParseException;
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
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);

		if (dayOfWeek == 2) {
			cal.add(Calendar.DATE, -3);
		} else {
			cal.add(Calendar.DATE, -1);
		}

		return cal.getTime();
	}

	private Date hoje() {
		final Calendar cal = Calendar.getInstance();
		return cal.getTime();
	}

	public String getDataOntem() {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		return dateFormat.format(this.ontem());
	}

	public String getDataHoje() {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		return dateFormat.format(this.hoje());
	}

	public int getDia() {
		DateFormat dateFormat = new SimpleDateFormat("dd");
		return Integer.parseInt(dateFormat.format(this.ontem()));
	}

	public String subtraiHoras(String hora1, String hora2) {
		long second = 1000l;
		long minute = 60l * second;
		long hour = 60l * minute;

		SimpleDateFormat formatter = new SimpleDateFormat("hh:mm");

		Date dt1 = null;
		try {
			dt1 = formatter.parse(hora1);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		Date dt2 = null;
		try {
			dt2 = formatter.parse(hora2);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		long diff = dt2.getTime() - dt1.getTime();

		String retorno = String.format("%02d", diff / hour) + ":" + String.format("%02d", (diff % hour) / minute);

		return retorno;
	}
}
