package br.com.denisluna.randomtestproject.types;

import java.util.TimerTask;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import br.com.denisluna.randomtestproject.pageobjects.TelaControleDoPonto;
import br.com.denisluna.randomtestproject.pageobjects.TelaDeLogin;
import br.com.denisluna.randomtestproject.pageobjects.TelaHome;

public class BatimentoPonto extends TimerTask {
	private TelaHome telaHome;
	private TelaControleDoPonto telaPonto;

	@Override
	public void run() {
		WebDriver driver = new ChromeDriver();
		this.telaHome = new TelaDeLogin(driver).loga();
		this.telaHome.setDadosIniciais();

		this.telaHome.clicaMenuPonto();
		this.telaPonto = this.telaHome.clicaMenuLancamentoDePonto();
		this.telaPonto.clicaBotaoEfetuarLancamento();
		// this.telaPonto.trataConfirmaLancamento();

		this.telaHome.fecha();
	}
}
