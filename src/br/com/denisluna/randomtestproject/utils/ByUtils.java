package br.com.denisluna.randomtestproject.utils;

import org.openqa.selenium.By;

public abstract class ByUtils {

	public final static String A_LINK = "a", DIV = "div", SPAN = "span", INPUT = "input", SELECT = "select",
			BUTTON = "button", ALL = "*";

	public static By encontraBy(String elemento, String id, String classe) {
		return By.xpath(String.format("//%1$s[(@id='%2$s') or (@class = '%3$s')]", elemento, id, classe));
	}

	public static By encontraByID(String elemento, String id) {
		return By.xpath(String.format("//%1$s[@id='%2$s']", elemento, id));
	}

	public static By encontraByClass(String elemento, String classe) {
		return By.xpath(String.format("//%1$s[@class='%2$s']", elemento, classe));
	}

	public static By encontraByClass(String elemento, String classe, int index) {
		return By.xpath(String.format("(//%1$s[@class='%2$s'])[%3$d]", elemento, classe, index));
	}

	public static By encontraByTexto(String elemento, String texto) {
		return By.xpath(String.format("//%1$s[text()='%2$s']", elemento, texto));
	}

	public static By encontraByTexto(String elemento, String texto, int index) {
		return By.xpath(String.format("(//%1$s[text()='%2$s'])[%3$d]", elemento, texto, index));
	}
}
