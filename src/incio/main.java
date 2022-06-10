package incio;

import java.awt.Menu;
import java.awt.event.ActionEvent;
import java.io.IOException;

import Logica.Pregunta;
import Logica.Test;
import gui.MenuPrincipal;
import gui.VentanaTests;

public class main {

	public static void main(String[] args) {
		Test t = new Test();
		try {
			Test.cargarFichero(
					"C:\\Users\\Usuario\\eclipse-workspace\\ConcursoDePreguntas\\src\\\\resourse\\preguntas.txt");
			t.RealizarNivelesDificultad();
			// t.realizarTest();
			t.llearlistajuego();
			MenuPrincipal menuPrincipal = new MenuPrincipal(t);
			menuPrincipal.setVisible(true);
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}
		
	
		
		

	}

}
