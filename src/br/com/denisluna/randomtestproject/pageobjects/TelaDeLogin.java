package br.com.denisluna.randomtestproject.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import br.com.denisluna.randomtestproject.utils.ByUtils;

public class TelaDeLogin extends TelaBase {
	private By inputLogin = ByUtils.encontraByID(ByUtils.INPUT, "txtLogin");
	private By inputSenha = ByUtils.encontraByID(ByUtils.INPUT, "txtSenha");
	private By labelChave = ByUtils.encontraByID(ByUtils.LABEL, "caption");
	private By inputChave = ByUtils.encontraByID(ByUtils.INPUT, "txtcaption");
	private By botaoEntrar = ByUtils.encontraByClass(ByUtils.INPUT, "btn", 1);

	public TelaDeLogin(WebDriver driver) {
		super(driver);
	}

	public void setLogin(String usuario) {
		this.getElemento().elementoWebInsereTexto(this.inputLogin, usuario);
	}

	public void setSenha(String usuario) {
		this.getElemento().elementoWebInsereTexto(this.inputSenha, usuario);
	}

	public String getChave() {
		return this.getElemento().elementoWebPegaTexto(this.labelChave);
	}

	public void setChave(String chave) {
		this.getElemento().elementoWebInsereTexto(this.inputChave, chave);
	}

	public void clicaBotaoEntrar() {
		this.getElemento().elementoWebClica(this.botaoEntrar);
	}

	public TelaHome loga() {
		this.navega("http://sco.rsinet.com.br/");
		this.maximizaBrowser();
		this.setChave(this.getChave());
		this.setLogin("denis.silva");
		this.setSenha("dnsCasados20");
		this.clicaBotaoEntrar();

		return new TelaHome(this.getDriver());
	}
}
