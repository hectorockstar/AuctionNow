package com.auctionnow.presentacion;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.auctionnow.entidades.*;
import com.auctionnow.model.UsuarioWeb;
import com.auctionnow.negocio.*;

/**
 * Servlet implementation class MenuUsuario
 */
@WebServlet(name = "CargaMenuUsuarioServlet", urlPatterns = {"/cargaMenuUsuario"})
public class CargaMenuUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CargaMenuUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.print("morteza");
		HttpSession sesion = request.getSession(true);
//		Usuario usuario = (Usuario)sesion.getAttribute("usuarioConectado");
		UsuarioWeb usuario = (UsuarioWeb)sesion.getAttribute("usuarioWeb");
		
		if(usuario != null){
			MenuBO menuBo =  new MenuBO();
			List<Menu> listadoMenu = menuBo.cargaMenuPorPerfil(usuario.getUsuario().getTipoUsuario().getId());			
			sesion.setAttribute("listadoMenu", listadoMenu);
			response.sendRedirect("pages/perfil.jsp");
		}else{			
			response.sendRedirect("pages/ingresar.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		
	}

}
