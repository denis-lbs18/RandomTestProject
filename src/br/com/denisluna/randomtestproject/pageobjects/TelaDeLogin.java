package br.com.denisluna.randomtestproject.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TelaDeLogin extends TelaBase {
	private By inputLogin = By.id("txtLogin");
	private By inputSenha = By.id("txtSenha");
	private By botaoEntrar = By.xpath("html/body/div[1]/form/fieldset[1]/button[1]");

	public TelaDeLogin(WebDriver driver) {
		super(driver);
	}

	public void setLogin(String usuario) {
		this.getElemento().elementoWebInsereTexto(this.inputLogin, usuario);
	}

	public void setSenha(String usuario) {
		this.getElemento().elementoWebInsereTexto(this.inputSenha, usuario);
	}

	public void clicaBotaoEntrar() {
		this.getElemento().elementoWebClica(this.botaoEntrar);
	}

	public TelaHome loga() {
		this.navega("http://pft.rsinet.com.br/");
		this.maximizaBrowser();
		this.setLogin("denis.silva");
		this.setSenha("dnsCasados20");
		this.clicaBotaoEntrar();

		return new TelaHome(this.getDriver());
	}
}
