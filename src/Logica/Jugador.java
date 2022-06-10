package Logica;

import java.io.Serializable;
/**
 * clase que contiene informacion de los jugadores
 * 
 * @author Jhon gutierrez
 *
 */
public class Jugador  implements Serializable{
	private  String nombre;
	private int puntaje;
	private int contrasena;
	
	
	public Jugador(String nombre) {
		super();
		this.nombre = nombre;
		
		
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getNombre() {
		return nombre;
	}
	public int getPuntaje() {
		return puntaje;
	}
	public void setPuntaje(int puntaje) {
		this.puntaje = puntaje;
	}
	public int getContrasena() {
		return contrasena;
	}
	public void setContrasena(int contrasena) {
		this.contrasena = contrasena;
	}

}
