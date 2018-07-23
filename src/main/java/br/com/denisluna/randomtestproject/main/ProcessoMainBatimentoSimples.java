package br.com.denisluna.randomtestproject.main;

import java.util.Timer;

import br.com.denisluna.randomtestproject.types.BatimentoPonto;
import br.com.denisluna.randomtestproject.utils.CalendarUtils;

public class ProcessoMainBatimentoSimples {

	public static void main(String[] args) {
		Timer timer = new Timer();

		CalendarUtils calendario = new CalendarUtils();
		calendario.escreveHora();

		timer.schedule(new BatimentoPonto(), calendario.getTime());
	}
}
