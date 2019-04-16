
package com.auctionnow.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Hashtable;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;


import com.auctionnow.exception.AuctionNowServiceException;


public class AuctionNowCommonGetEJB {

	
	public static Object getEJB (String jndi) throws AuctionNowServiceException{
		InitialContext context = null;
		try {
			
			Hashtable jndiProperties = new Hashtable();
	        jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
	        jndiProperties.put("jboss.naming.client.ejb.context",true);
	        
			context = new InitialContext(jndiProperties);
//			return remoteInterfaceClass.cast(javax.rmi.PortableRemoteObject.narrow(context.lookup("ejb:"+jndi), remoteInterfaceClass));
			return context.lookup("ejb:"+jndi); 
			
		} catch (NamingException e) {
			System.out.println("NamingException: "+e);
			throw new AuctionNowServiceException(e.getMessage(), e);
		} catch (SecurityException e) {
			System.out.println("SecurityException: "+e);
			throw new AuctionNowServiceException(e.getMessage(), e);
		} catch (IllegalArgumentException e) {
			System.out.println("IllegalArgumentException: "+e);
			throw new AuctionNowServiceException(e.getMessage(), e);
		} 
		
	}
	

	public Object callEjb(String jndi,String methodName, Class<?>[] parameterTypes, Object[] params) throws AuctionNowServiceException{
		Properties propiedades = new Properties();
		propiedades.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
		Context ctx;
		try {
			ctx = new InitialContext(propiedades);		
			Object obj = ctx.lookup(jndi);
			Class<?> clazz = obj.getClass();  
		    Method mthd = clazz.getMethod(methodName,parameterTypes);
		    return mthd.invoke(obj, params);
		    
		} catch (NamingException e) {
			System.out.println("NamingException: "+e);
			throw new AuctionNowServiceException(e.getMessage(), e);
		} catch (SecurityException e) {
			System.out.println("SecurityException: "+e);
			throw new AuctionNowServiceException(e.getMessage(), e);
		} catch (NoSuchMethodException e) {
			System.out.println("NoSuchMethodException: "+e);
			throw new AuctionNowServiceException(e.getMessage(), e);
		} catch (IllegalArgumentException e) {
			System.out.println("IllegalArgumentException: "+e);
			throw new AuctionNowServiceException(e.getMessage(), e);
		} catch (IllegalAccessException e) {
			System.out.println("IllegalAccessException: "+e);
			throw new AuctionNowServiceException(e.getMessage(), e);
		} catch (InvocationTargetException e) {
			System.out.println("InvocationTargetException: "+e);
			throw new AuctionNowServiceException(e.getMessage(), e);
		}
	}
	
	public static <T> T getInstanceEJB(Class<T> remoteInterfaceClass, String jndi) throws ClassCastException, NamingException 
	{
		InitialContext context = null;
		Hashtable jndiProperties = new Hashtable();
        jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
        jndiProperties.put("jboss.naming.client.ejb.context",true);
        
		context = new InitialContext(jndiProperties);
		
		
		T ejb = remoteInterfaceClass.cast(javax.rmi.PortableRemoteObject.narrow(context.lookup("ejb:"+jndi), remoteInterfaceClass));
		return ejb;		
	}
	
}

