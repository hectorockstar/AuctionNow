package com.auctionnow.entidades;

public class Menu {
	private String tipoCatalogo;
	private String destinoMenu;
	private int padreMenu;
	private String nombreMenu;
	private int codigoMenu;
	
	public Menu(){
		
	}

	public String getTipoCatalogo() {
		return tipoCatalogo;
	}

	public void setTipoCatalogo(String tipoCatalogo) {
		this.tipoCatalogo = tipoCatalogo;
	}

	public String getDestinoMenu() {
		return destinoMenu;
	}

	public void setDestinoMenu(String destinoMenu) {
		this.destinoMenu = destinoMenu;
	}

	public int getPadreMenu() {
		return padreMenu;
	}

	public void setPadreMenu(int padreMenu) {
		this.padreMenu = padreMenu;
	}

	public String getNombreMenu() {
		return nombreMenu;
	}

	public void setNombreMenu(String nombreMenu) {
		this.nombreMenu = nombreMenu;
	}

	public int getCodigoMenu() {
		return codigoMenu;
	}

	public void setCodigoMenu(int codigoMenu) {
		this.codigoMenu = codigoMenu;
	}	
}
