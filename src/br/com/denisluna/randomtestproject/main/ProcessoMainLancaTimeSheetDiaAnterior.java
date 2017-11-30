package br.com.denisluna.randomtestproject.main;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import br.com.denisluna.randomtestproject.pageobjects.TelaDeLogin;
import br.com.denisluna.randomtestproject.pageobjects.TelaHome;
import br.com.denisluna.randomtestproject.pageobjects.TelaTimeSheets;
import br.com.denisluna.randomtestproject.utils.JsonUtils;

public class ProcessoMainLancaTimeSheetDiaAnterior {

	public static void main(String[] args) {
		final JsonUtils jsonReader = new JsonUtils();
		WebDriver driver = new FirefoxDriver();

		TelaHome telaHome = new TelaDeLogin(driver).loga();
		telaHome.setDadosIniciais();
		/*
		 * telaHome.clicaMenuPonto(); TelaControleDoPonto telaPonto =
		 * telaHome.clicaMenuLancamentoDePonto();
		 * telaPonto.clicaBotaoEfetuarLancamento();
		 */
		String dataTrabalhada = "14/11/2017";
		String horasTrabalhadas = "08:36";

		System.out.println(dataTrabalhada);
		System.out.println(horasTrabalhadas);

		telaHome.clicaMenuTimeSheet();
		TelaTimeSheets telaTimeSheets = telaHome.clicaMenuLancamentoDeTimeSheets();

		telaTimeSheets.clicaBotaoLancarTimeSheet();

		telaTimeSheets.setInputDataTrabalhada(dataTrabalhada);
		telaTimeSheets.setInputHorasTrabalhadas(horasTrabalhadas);

		telaTimeSheets.setInputDescricao(jsonReader.getDescricao());

		telaTimeSheets.selecionaProjeto(jsonReader.getProjeto());
		telaTimeSheets.selecionaDemanda(jsonReader.getDemanda());
		telaTimeSheets.selecionaTarefa(jsonReader.getTarefa());

		telaTimeSheets.clicaBotaoSalvar();
		if (telaTimeSheets.mensagemTimeSheetLancadoEstaVisivel())
			telaTimeSheets.fecha();
	}
}