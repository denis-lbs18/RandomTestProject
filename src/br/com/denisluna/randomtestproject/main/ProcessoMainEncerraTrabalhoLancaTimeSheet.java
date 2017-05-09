package br.com.denisluna.randomtestproject.main;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import br.com.denisluna.randomtestproject.pageobjects.TelaControleDoPonto;
import br.com.denisluna.randomtestproject.pageobjects.TelaDeLogin;
import br.com.denisluna.randomtestproject.pageobjects.TelaHome;
import br.com.denisluna.randomtestproject.pageobjects.TelaTimeSheets;
import br.com.denisluna.randomtestproject.utils.CalendarUtils;

public class ProcessoMainEncerraTrabalhoLancaTimeSheet {

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", "data/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();

		TelaHome telaHome = new TelaDeLogin(driver).loga();

		telaHome.setDadosIniciais();

		telaHome.clicaMenuPonto();
		TelaControleDoPonto telaPonto = telaHome.clicaMenuLancamentoDePonto();
		telaPonto.clicaBotaoEfetuarLancamento();

		CalendarUtils calendar = new CalendarUtils();

		String dataTrabalhada = calendar.getDataHoje();
		String horaAlmoco = calendar.subtraiHoras(telaPonto.getHoraSaida1(), telaPonto.getHoraEntrada2());
		String horaTrabalho = calendar.subtraiHoras(telaPonto.getHoraEntrada1(), telaPonto.getHoraSaida2());
		String horasTrabalhadas = calendar.subtraiHoras(horaAlmoco, horaTrabalho);

		System.out.println(dataTrabalhada);
		System.out.println(horaAlmoco);
		System.out.println(horaTrabalho);
		System.out.println(horasTrabalhadas);

		telaHome.clicaMenuTimeSheet();
		TelaTimeSheets telaTimeSheets = telaHome.clicaMenuLancamentoDeTimeSheets();

		telaTimeSheets.clicaBotaoLancarTimeSheet();
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