package br.com.denisluna.randomtestproject.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import br.com.denisluna.randomtestproject.utils.ByUtils;
import br.com.denisluna.randomtestproject.utils.TempoTimeouts;

public class TelaTimeSheets extends TelaBase {
	private By botaoLancarTimeSheet = ByUtils.encontraByValue(ByUtils.INPUT, "Lançar TimeSheet");
	private By selectProjeto = ByUtils.encontraBySelect(1);
	private By selectDemanda = ByUtils.encontraBySelect(2);
	private By selectTarefa = ByUtils.encontraBySelect(3);
	private By inputDataTrabalhada = ByUtils.encontraByClass(ByUtils.INPUT, "span2", 1);
	private By inputHorasTrabalhadas = ByUtils.encontraByClass(ByUtils.INPUT, "input-md", 1);
	private By inputDescricao = ByUtils.encontraByClass(ByUtils.TEXTAREA, "input-md");
	private By botaoSalvar = ByUtils.encontraByValue(ByUtils.INPUT, "Salvar");

	public TelaTimeSheets(WebDriver driver) {
		super(driver);
	}

	public void clicaBotaoLancarTimeSheet() {
		this.getElemento().elementoWebClica(this.botaoLancarTimeSheet);
		this.sleep(TempoTimeouts.TEMPOMEDIO);
	}

	public void selecionaProjeto(int index) {
		this.sleep(TempoTimeouts.TEMPOPADRAOTELA);
		this.getElemento().elementoWebSelecionaListaPorIndex(this.selectProjeto, index);
	}

	public void selecionaProjeto(String value) {
		this.sleep(TempoTimeouts.TEMPOPADRAOTELA);
		this.getElemento().elementoWebSelecionaListaPorTexto(this.selectProjeto, value);
	}

	public void selecionaDemanda(int index) {
		this.sleep(TempoTimeouts.TEMPOPADRAOTELA);
		this.getElemento().elementoWebSelecionaListaPorIndex(this.selectDemanda, index);
	}

	public void selecionaDemanda(String value) {
		this.sleep(TempoTimeouts.TEMPOPADRAOTELA);
		this.getElemento().elementoWebSelecionaListaPorTexto(this.selectDemanda, value);
	}

	public void selecionaTarefa(int index) {
		this.sleep(TempoTimeouts.TEMPOPADRAOTELA);
		this.getElemento().elementoWebSelecionaListaPorIndex(this.selectTarefa, index);
	}

	public void selecionaTarefa(String value) {
		this.sleep(TempoTimeouts.TEMPOPADRAOTELA);
		this.getElemento().elementoWebSelecionaListaPorTexto(this.selectTarefa, value);
	}

	public void setInputDescricao(String value) {
		this.getElemento().elementoWebInsereTexto(this.inputDescricao, value);
	}

	public void setInputDataTrabalhada(String value) {
		this.sleep(TempoTimeouts.TEMPOPADRAOTELA);
		this.getElemento().elementoWebInsereTexto(this.inputDataTrabalhada, value);
	}

	public void setInputHorasTrabalhadas(String value) {
		this.sleep(TempoTimeouts.TEMPOPADRAOTELA);
		this.getElemento().elementoWebInsereTexto(this.inputHorasTrabalhadas, value);
	}

	public void clicaBotaoSalvar() {
		this.getElemento().elementoWebClica(this.botaoSalvar);
		this.sleep(TempoTimeouts.TEMPOLONGO);
	}
}
