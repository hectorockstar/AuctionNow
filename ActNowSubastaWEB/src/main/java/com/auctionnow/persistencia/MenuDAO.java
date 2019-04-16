package com.auctionnow.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.auctionnow.entidades.Menu;

public class MenuDAO implements ICrud{

	@Override
	public boolean addElemento(Object objetoInsert) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List readElementos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateElemento(Object objetoUpdate) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteElemento(int codigo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int ultimoID() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public List cargaMenuPorPerfil(String tipoCatalogo){
		List listadoMenu = new LinkedList();
		try {
			Connection con = Conexion.getConexion();
			String query = " SELECT c_codigo, t_nombre_menu, c_padre_menu, t_destino_menu, c_tipcatal"
						 + " FROM an_menu"
						 + " WHERE c_tipcatal = ?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, tipoCatalogo);
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Menu objMenu = new Menu();
				objMenu.setCodigoMenu(rs.getInt(1));
				objMenu.setNombreMenu(rs.getString(2));
				objMenu.setPadreMenu(rs.getInt(3));
				objMenu.setDestinoMenu(rs.getString(4));
				objMenu.setTipoCatalogo(rs.getString(5));
				listadoMenu.add(objMenu);
			}
			ps.close();
			rs.close();
			con.close();
		} catch (SQLException se) {
			se.getCause();			
		}catch (Exception e) {
			e.getCause();			
		}
		return listadoMenu;
	}
	
}
