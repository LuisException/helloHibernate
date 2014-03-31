package me.luisortiz.hellohibernate;

import java.io.File;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Videoclub {
	private SessionFactory sessionFactory;
	
	private void imprimirReservar() {
		try {

			sessionFactory = new Configuration().configure(new File("src\\hibernate.cfg.xml")).buildSessionFactory();
			
			Session s = sessionFactory.openSession();
	        s.beginTransaction();
	        
	        List<Reservas> reservas = s.createQuery("from Reservas").list();
			
			for (Reservas reserva : reservas) {
	            System.out.println(">>>>> El usuario: "+reserva.getUsuario().getNombre() +
	            		" ha reservado la pelicula: "+reserva.getPelicula().getPelicula() );
	        
	        }
	        
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	public static void main(String[] args){
		Videoclub videoclub = new Videoclub();
		videoclub.imprimirReservar();
	}

}
