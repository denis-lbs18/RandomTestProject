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
	private By botaoEfetuarLancamento = ByUtils.encontraByID(ByUtils.INPUT,
			"ctl00_ContentConteudo_ConfirmarFechamento");
	private By botaoConfirmaLancamento = ByUtils.encontraByID(ByUtils.INPUT, "ctl00_ContentConteudo_btnSalvar");

	private By tableHoraEntrada1 = ByUtils.encontraByTableData("ctl00_ContentConteudo_GridView1", 2, 3);
	private By tableHoraSaida1 = ByUtils.encontraByTableData("ctl00_ContentConteudo_GridView1", 3, 3);
	private By tableHoraEntrada2 = ByUtils.encontraByTableData("ctl00_ContentConteudo_GridView1", 4, 3);
	private By tableHoraSaida2 = ByUtils.encontraByTableData("ctl00_ContentConteudo_GridView1", 5, 3);

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

	public String getHoraEntrada1() {
		return this.getElemento().elementoWebPegaTexto(this.tableHoraEntrada1).trim();
	}

	public String getHoraEntrada2() {
		return this.getElemento().elementoWebPegaTexto(this.tableHoraEntrada2).trim();
	}

	public String getHoraSaida1() {
		return this.getElemento().elementoWebPegaTexto(this.tableHoraSaida1).trim();
	}

	public String getHoraSaida2() {
		return this.getElemento().elementoWebPegaTexto(this.tableHoraSaida2).trim();
	}

	public void trataConfirmaLancamento() {
		if (this.getElemento().elementoWebEstaVisivelWait(botaoConfirmaLancamento))
			this.getElemento().elementoWebClica(this.botaoConfirmaLancamento);
		;
	}
}
