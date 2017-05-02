package br.com.denisluna.randomtestproject.pageobjects;

import org.openqa.selenium.WebDriver;

import br.com.denisluna.randomtestproject.utils.ElementoWebUtils;
import br.com.denisluna.randomtestproject.utils.TempoTimeouts;

public class TelaBase {
	protected WebDriver driver;
	protected ElementoWebUtils elemento;

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
		this.getDriver().quit();
		this.sleep(TempoTimeouts.TEMPOMEDIO);
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
