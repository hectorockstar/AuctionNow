package com.auctionnow.interceptor;

import java.util.Map;

import com.auctionnow.model.UsuarioWeb;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class LoginInterceptor implements Interceptor{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String intercept(ActionInvocation actionInvocation) throws Exception {
		Map<String, Object> sessionAttributes = actionInvocation.getInvocationContext().getSession();
		
		UsuarioWeb usuarioWeb = (UsuarioWeb) sessionAttributes.get("usuarioWeb");
		
		if(usuarioWeb == null){
			return Action.LOGIN;
		}else{
//			
			System.out.println(actionInvocation.invoke());
			
			return actionInvocation.invoke();
		}
	}

}
