package br.com.denisluna.randomtestproject.pageobjects;

import org.openqa.selenium.WebDriver;

import Mapa_Objetos_Menus.TelaMenuPrincipal;
import Utils.ElementoWebUtils;

public class TelaBase {
	protected WebDriver driver;
	protected ElementoWebUtils elemento;
	protected TelaMenuPrincipal menuPrincipal;

	public TelaBase(WebDriver driver) {
		this.driver = driver;
		this.elemento = new ElementoWebUtils(this.getDriver());
	}

	public void navega(String url) {
		this.getDriver().navigate().to(url);
	}

	public void sleep(long tempo) {
		try {
			Thread.sleep(tempo);
		} catch (InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
	}

	public void maximizaBrowser() {
		this.getDriver().manage().window().maximize();
	}

	public void fecha() {
		this.getDriver().close();
	}

	public void startURL() {
		this.getDriver().get("pft.rsinet.com.br");
	}

	public WebDriver getDriver() {
		return this.driver;
	}

	public ElementoWebUtils getElemento() {
		return this.elemento;
	}
}
