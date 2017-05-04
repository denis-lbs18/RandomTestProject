package br.com.denisluna.randomtestproject.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import br.com.denisluna.randomtestproject.utils.ByUtils;
import br.com.denisluna.randomtestproject.utils.TempoTimeouts;

public class TelaControleDoPonto extends TelaBase {
	private By selectColaborador = ByUtils.encontraBySelect(1);
	private By divDatePicker = ByUtils.encontraByClass(ByUtils.DIV, "datepicker");
	private By botaoCalendario1 = ByUtils.encontraByClass(ByUtils.SPAN, "input-group-addon", 1);
	private By botaoCalendario2 = ByUtils.encontraByClass(ByUtils.SPAN, "input-group-addon", 2);
	private By botaoPesquisar = ByUtils.encontraByValue(ByUtils.INPUT, "Pesquisar");
	private By tableDataDiaAtual = ByUtils.encontraByClass(ByUtils.TD, "Col-Center", 3);
	private By tableTotalHorasDiaAtual = ByUtils.encontraByClass(ByUtils.TD, "Col-Center", 8);
	private By botaoEfetuarLancamento = ByUtils.encontraByClass(ByUtils.INPUT, "btn");

	public TelaControleDoPonto(WebDriver driver) {
		super(driver);
	}

	public void selecionaColaborador(int index) {
		this.sleep(TempoTimeouts.TEMPOCURTO);
		this.getElemento().elementoWebSelecionaListaPorIndex(this.selectColaborador, index);
	}

	public void setDataInicial(String data) {
		this.getElemento().elementoWebClica(this.botaoCalendario1);
		this.sleep(TempoTimeouts.TEMPOCURTO);
		this.getElemento().elementoWebSelecionaDatePicker(this.divDatePicker, data);
	}

	public void setDataFinal(String data) {
		this.getElemento().elementoWebClica(this.botaoCalendario2);
		this.sleep(TempoTimeouts.TEMPOCURTO);
		this.getElemento().elementoWebSelecionaDatePicker(this.divDatePicker, data);
	}

	public void clicaBotaoPesquisar() {
		this.getElemento().elementoWebClica(this.botaoPesquisar);
	}

	public String getDataDiaAtual() {
		return this.getElemento().elementoWebPegaTexto(this.tableDataDiaAtual);
	}

	public String getTotalHorasDiaAtual() {
		return this.getElemento().elementoWebPegaTexto(this.tableTotalHorasDiaAtual);
	}

	public void clicaBotaoEfetuarLancamento() {
		this.getElemento().elementoWebClica(this.botaoEfetuarLancamento);
		this.sleep(TempoTimeouts.TEMPOMEDIO);
	}
}
