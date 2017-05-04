package br.com.denisluna.randomtestproject.types;

import java.util.TimerTask;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import br.com.denisluna.randomtestproject.pageobjects.TelaDeLogin;
import br.com.denisluna.randomtestproject.pageobjects.TelaHome;

public class BatimentoPonto extends TimerTask {
	private TelaHome telaHome;

	@Override
	public void run() {
		System.setProperty("webdriver.gecko.driver", "data/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		this.telaHome = new TelaDeLogin(driver).loga();
		this.telaHome.setDadosIniciais();

		this.telaHome.clicaMenuPonto();
		this.telaHome.clicaMenuLancamentoDePonto().clicaBotaoEfetuarLancamento();
		this.telaHome.fecha();
	}
}
