package br.com.denisluna.randomtestproject.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import br.com.denisluna.randomtestproject.utils.TempoTimeouts;

public class TelaTimeSheets extends TelaBase {
	private By linkCriarNovoTimeSheet = By.xpath(".//*[@id='acao249']/a");
	private By selectProjeto = By.xpath(".//*[@id='nidProjetoObrY']");
	private By selectDemanda = By.xpath(".//*[@id='nidDemandaObrY']");
	private By selectTarefa = By.xpath(".//*[@id='nidTarefaObrY']");
	private By inputDataTrabalhada = By.xpath(".//*[@id='datTrabalhadaObrY']");
	private By inputHorasTrabalhadas = By.xpath(".//*[@id='txtHorasReaisObrY']");
	private By inputDescricao = By.xpath(".//*[@id='txtObservacaoObrY']");
	private By botaoSalvar = By.xpath("html/body/div[1]/div[2]/div[3]/form/fieldset/div/button[1]");

	public TelaTimeSheets(WebDriver driver) {
		super(driver);
	}

	public void clicaLinkCriarNovoTimeSheet() {
		this.getElemento().elementoWebClica(this.linkCriarNovoTimeSheet);
	}

	public void selecionaProjeto(int index) {
		this.sleep(TempoTimeouts.TEMPOCURTO);
		this.getElemento().elementoWebSelecionaListaPorIndex(this.selectProjeto, index);
	}

	public void selecionaProjeto(String value) {
		this.sleep(TempoTimeouts.TEMPOCURTO);
		this.getElemento().elementoWebSelecionaListaPorTexto(this.selectProjeto, value);
	}

	public void selecionaDemanda(int index) {
		this.sleep(TempoTimeouts.TEMPOCURTO);
		this.getElemento().elementoWebSelecionaListaPorIndex(this.selectDemanda, index);
	}

	public void selecionaDemanda(String value) {
		this.sleep(TempoTimeouts.TEMPOCURTO);
		this.getElemento().elementoWebSelecionaListaPorTexto(this.selectDemanda, value);
	}

	public void selecionaTarefa(int index) {
		this.sleep(TempoTimeouts.TEMPOCURTO);
		this.getElemento().elementoWebSelecionaListaPorIndex(this.selectTarefa, index);
	}

	public void selecionaTarefa(String value) {
		this.sleep(TempoTimeouts.TEMPOCURTO);
		this.getElemento().elementoWebSelecionaListaPorTexto(this.selectTarefa, value);
		this.sleep(TempoTimeouts.TEMPOMEDIO);
	}

	public void setInputDescricao(String value) {
		this.getElemento().elementoWebInsereTexto(this.inputDescricao, value);
	}

	public void setInputDataTrabalhada(String value) {
		this.getElemento().elementoWebInsereTexto(this.inputDataTrabalhada, value);
	}

	public void setInputHorasTrabalhadas(String value) {
		this.getElemento().elementoWebInsereTexto(this.inputHorasTrabalhadas, value);
	}

	public void clicaBotaoSalvar() {
		this.getElemento().elementoWebClica(this.botaoSalvar);
	}
}
