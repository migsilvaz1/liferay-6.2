package com.near.notificaciones.util;

public class RedireccionesRetriever {
	public static String[] getRedireccionURL(Integer motivo){
		//redireccion[0] es la url relativa a la que se redirigir
		//redireccion[1] es el nombre de la página comprensible por el usuario
		String[] redireccion = null;
		switch (motivo) {
			//catálogo
			case 1:{
				redireccion = new String[2];
				redireccion[0] = "gestion-catalogo";
				redireccion[1] = "Catálogo";
				break;
			}
			//pedidos
			case 2:{
				redireccion = new String[2];
				redireccion[0] = "gestion-de-pedidos";
				redireccion[1] = "Mis pedidos";
				break;
			}
			//carga masiva
			case 3:{
				redireccion = new String[2];
				redireccion[0] = "carga-masiva1";
				redireccion[1] = "Carga masiva";
				break;
			}
		}	
		return redireccion;
	}
}
