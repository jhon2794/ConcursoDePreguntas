package aplicacion;

import java.awt.Menu;
import java.awt.event.ActionEvent;
import java.io.IOException;

import Logica.Pregunta;
import Logica.Test;
import gui.MenuPrincipal;
import gui.VentanaTests;
/**
 * clase principal
 * 
 * @author Jhon gutierrez
 *
 */
public class main {

	public static void main(String[] args) {
		Test t = new Test();
		try {
			//cargamos el fichero que contiene las preguntas
			Test.cargarFichero();
			t.RealizarNivelesDificultad();//metodo que crea los niveles de dificultad
			t.llearlistajuego();//metodo que crea las 5 preguntas aleatorias 1 de cada nivel
			MenuPrincipal menuPrincipal = new MenuPrincipal(t); // se crea instancia de la ventana menu
			menuPrincipal.setVisible(true);//se hace visible la ventana
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}
	
	}

}
