package com.auctionnow.negocio;

import java.util.List;

import com.auctionnow.persistencia.MenuDAO;

public class MenuBO {
	private MenuDAO objMenuDao;
	
	public MenuBO(){
		this.objMenuDao = new MenuDAO(); 
	}
	
	public List cargaMenuPorPerfil(String tipoCatalogo){
		return objMenuDao.cargaMenuPorPerfil(tipoCatalogo);
	}
}
