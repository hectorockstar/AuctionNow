package com.auctionnow.persistencia;

import java.util.List;

public interface ICrud {
	public boolean addElemento(Object objetoInsert);

    public List readElementos();

    public boolean updateElemento(Object objetoUpdate);

    public boolean deleteElemento(int codigo);
    
    public int ultimoID();
}
