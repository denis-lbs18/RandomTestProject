package br.com.denisluna.randomtestproject.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import br.com.denisluna.randomtestproject.utils.TempoTimeouts;

public class TelaHome extends TelaBase {
	private By menuControleDoPonto = By.xpath(".//*[@id='acao243']/a");
	private By menuTimeSheets = By.xpath(".//*[@id='acao248']/a");
	private By botaoPeriodo = By.id("btSubmit");

	public TelaHome(WebDriver driver) {
		super(driver);
	}

	public void clicaBotaoPeriodo() {
		this.getElemento().elementoWebClica(this.botaoPeriodo);
		this.sleep(TempoTimeouts.TEMPOMEDIO);
	}

	public TelaControleDoPonto clicaMenuControleDoPonto() {
		this.getElemento().elementoWebClica(this.menuControleDoPonto);
		return new TelaControleDoPonto(this.getDriver());
	}

	public TelaTimeSheets clicaMenuTimeSheets() {
		this.getElemento().elementoWebClica(this.menuTimeSheets);
		return new TelaTimeSheets(this.getDriver());
	}
}
