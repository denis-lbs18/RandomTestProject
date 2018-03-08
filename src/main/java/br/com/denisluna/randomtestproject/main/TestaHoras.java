package br.com.denisluna.randomtestproject.main;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import br.com.denisluna.randomtestproject.pageobjects.TelaControleDoPonto;
import br.com.denisluna.randomtestproject.pageobjects.TelaDeLogin;
import br.com.denisluna.randomtestproject.pageobjects.TelaHome;
import br.com.denisluna.randomtestproject.utils.CalendarUtils;

public class TestaHoras {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();

		TelaHome telaHome;
		telaHome = new TelaDeLogin(driver).loga();
		telaHome.setDadosIniciais();

		telaHome.clicaMenuPonto();
		TelaControleDoPonto telaPonto = telaHome.clicaMenuLancamentoDePonto();

		System.out.println(telaPonto.getHoraEntrada1());
		System.out.println(telaPonto.getHoraSaida1());
		System.out.println(telaPonto.getHoraEntrada2());

		System.out.println(telaPonto.getHoraSaida2());

		CalendarUtils calendar = new CalendarUtils();
		String dataTrabalhada = calendar.getDataHoje();
		String horaAlmoco = calendar.subtraiHoras(telaPonto.getHoraSaida1(), telaPonto.getHoraEntrada2());
		String horaTrabalho = calendar.subtraiHoras(telaPonto.getHoraEntrada1(), telaPonto.getHoraSaida2());
		String horasTrabalhadas = calendar.subtraiHoras(horaAlmoco, horaTrabalho);

		System.out.println(dataTrabalhada);
		System.out.println(horaAlmoco);
		System.out.println(horaTrabalho);
		System.out.println(horasTrabalhadas);
	}

}
