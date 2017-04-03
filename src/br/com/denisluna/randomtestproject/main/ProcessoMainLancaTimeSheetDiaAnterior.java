package br.com.denisluna.randomtestproject.main;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import br.com.denisluna.randomtestproject.pageobjects.TelaControleDoPonto;
import br.com.denisluna.randomtestproject.pageobjects.TelaDeLogin;
import br.com.denisluna.randomtestproject.pageobjects.TelaHome;
import br.com.denisluna.randomtestproject.pageobjects.TelaTimeSheets;

public class ProcessoMainLancaTimeSheetDiaAnterior {

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", "data/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();

		TelaHome telaHome = new TelaDeLogin(driver).loga();
		TelaControleDoPonto telaPonto = telaHome.clicaMenuControleDoPonto();

		String dataTrabalhada = telaPonto.getDataDiaAnterior();
		String horasTrabalhadas = telaPonto.getTotalHorasDiaAnterior();

		System.out.println(dataTrabalhada);
		System.out.println(horasTrabalhadas);

		TelaTimeSheets telaTimeSheets = telaHome.clicaMenuTimeSheets();
		telaTimeSheets.clicaLinkCriarNovoTimeSheet();
		telaTimeSheets.selecionaProjeto(1);
		telaTimeSheets.selecionaDemanda(1);
		telaTimeSheets.selecionaTarefa("Análise e Homologação");
		telaTimeSheets.setInputDataTrabalhada(dataTrabalhada);
		telaTimeSheets.setInputHorasTrabalhadas(horasTrabalhadas);
		telaTimeSheets.setInputDescricao("Automação de Testes novo IBPJ.");
		telaTimeSheets.clicaBotaoSalvar();
		telaTimeSheets.fecha();
	}
}