package br.com.denisluna.randomtestproject.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import br.com.denisluna.randomtestproject.utils.ByUtils;
import br.com.denisluna.randomtestproject.utils.TempoTimeouts;

public class TelaHome extends TelaBase {
	private By selectFilial = ByUtils.encontraBySelect(1);
	private By selectPlanta = ByUtils.encontraBySelect(2);
	private By menuPonto = ByUtils.encontraByClass(ByUtils.A_LINK, "dropdown-toggle", 2);
	private By menuLancamentoDoPonto = ByUtils.encontraByTextoContains(ByUtils.A_LINK, "Lançamento de Ponto");
	private By menuConsultaDeHistorico = ByUtils.encontraByTextoContains(ByUtils.A_LINK, "Consulta de Histórico");
	private By menuTimeSheets = ByUtils.encontraByClass(ByUtils.A_LINK, "dropdown-toggle", 3);
	private By menuLancamentoDeTimeSheet = ByUtils.encontraByTextoContains(ByUtils.A_LINK, "Lançamento de TimeSheet");

	public TelaHome(WebDriver driver) {
		super(driver);
	}

	public void selecionaFilial(String value) {
		this.sleep(TempoTimeouts.TEMPOCURTO);
		this.getElemento().elementoWebSelecionaListaPorTexto(this.selectFilial, value);
	}

	public void selecionaFilial(int index) {
		this.sleep(TempoTimeouts.TEMPOCURTO);
		this.getElemento().elementoWebSelecionaListaPorIndex(this.selectFilial, index);
	}

	public void selecionaPlanta(String value) {
		this.sleep(TempoTimeouts.TEMPOCURTO);
		this.getElemento().elementoWebSelecionaListaPorTexto(this.selectPlanta, value);
	}

	public void selecionaPlanta(int index) {
		this.sleep(TempoTimeouts.TEMPOCURTO);
		this.getElemento().elementoWebSelecionaListaPorIndex(this.selectPlanta, index);
	}

	public void clicaMenuPonto() {
		this.getElemento().elementoWebClica(this.menuPonto);
	}

	public TelaControleDoPonto clicaMenuLancamentoDePonto() {
		this.sleep(TempoTimeouts.TEMPOCURTO);
		this.getElemento().elementoWebClica(this.menuLancamentoDoPonto);
		return new TelaControleDoPonto(this.getDriver());
	}

	public TelaControleDoPonto clicaMenuConsultaDeHistorico() {
		this.sleep(TempoTimeouts.TEMPOCURTO);
		this.getElemento().elementoWebClica(this.menuConsultaDeHistorico);
		return new TelaControleDoPonto(this.getDriver());
	}

	public void clicaMenuTimeSheet() {
		this.getElemento().elementoWebClica(this.menuTimeSheets);
	}

	public TelaTimeSheets clicaMenuLancamentoDeTimeSheets() {
		this.getElemento().elementoWebClica(this.menuLancamentoDeTimeSheet);
		return new TelaTimeSheets(this.getDriver());
	}

	public void setDadosIniciais() {
		this.selecionaFilial("Osasco");
		this.selecionaPlanta(1);
	}
}
