package Logica;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

import gui.VentanaTests;

/**
 * clase que contiene la logica de juego
 * 
 * @author Jhon gutierrez
 *
 */
public class Test {

	// atributos
	VentanaTests ventana;
	private ArrayList<Pregunta> nivel1;
	private ArrayList<Pregunta> nivel2;
	private ArrayList<Pregunta> nivel3;
	private ArrayList<Pregunta> nivel4;
	private ArrayList<Pregunta> nivel5;
	ArrayList<Jugador> jugadores;
	private static ArrayList<Pregunta> preguntas;
	private static ArrayList<Pregunta> preguntasjuego;
	private int puntosTotales;
	private int preguntaActual;

	public Test() {
		super();
		cargarArchivos();
		preguntas = new ArrayList<>();
		nivel1 = new ArrayList<>();
		nivel2 = new ArrayList<>();
		nivel3 = new ArrayList<>();
		nivel4 = new ArrayList<>();
		nivel5 = new ArrayList<>();
		preguntasjuego = new ArrayList<>();
		puntosTotales = 0;
		preguntaActual = 0;

	}

	public ArrayList<Pregunta> getNivel1() {
		return nivel1;
	}

	public void setNivel1(ArrayList<Pregunta> nivel1) {
		this.nivel1 = nivel1;
	}

	public ArrayList<Pregunta> getNivel2() {
		return nivel2;
	}

	public void setNivel2(ArrayList<Pregunta> nivel2) {
		this.nivel2 = nivel2;
	}

	public ArrayList<Pregunta> getNivel3() {
		return nivel3;
	}

	public void setNivel3(ArrayList<Pregunta> nivel3) {
		this.nivel3 = nivel3;
	}

	public ArrayList<Pregunta> getNivel4() {
		return nivel4;
	}

	public void setNivel4(ArrayList<Pregunta> nivel4) {
		this.nivel4 = nivel4;
	}

	public ArrayList<Pregunta> getNivel5() {
		return nivel5;
	}

	public void setNivel5(ArrayList<Pregunta> nivel5) {
		this.nivel5 = nivel5;
	}

	public static ArrayList<Pregunta> getPreguntasjuego() {
		return preguntasjuego;
	}

	public static void setPreguntasjuego(ArrayList<Pregunta> preguntasjuego) {
		Test.preguntasjuego = preguntasjuego;
	}

	public ArrayList<Pregunta> getPreguntas() {
		return preguntas;
	}

	public void setPreguntas(ArrayList<Pregunta> preguntas) {
		this.preguntas = preguntas;
	}

	public int getPuntosTotales() {
		return puntosTotales;
	}

	public void setPuntosTotales(int puntosTotales) {
		this.puntosTotales = puntosTotales;
	}

	public int getPreguntaActual() {
		return preguntaActual;
	}

	public void setPreguntaActual(int preguntaActual) {
		this.preguntaActual = preguntaActual;
	}

	public ArrayList<Jugador> getJugadores() {
		return jugadores;
	}

	public void setJugadores(ArrayList<Jugador> jugadores) {
		this.jugadores = jugadores;
	}

	public void reiniciarTest() {
		preguntaActual = 0;
		puntosTotales = 0;
	}

	/**
	 * metodo qque permite cargar las preguntas desde el archivo txt y guardarlas en
	 * una lista
	 * 
	 * @author Jhon gutierrez
	 *
	 */

	public static void cargarFichero() throws FileNotFoundException, IOException {
		// Creo el buffer
		BufferedReader br = new BufferedReader(new FileReader("src/resourse/preguntas.txt"));
		// variables necesarias
		Categoria categoria = null;
		String linea;
		Pregunta p = null;
		ArrayList<Respuesta> respuestas = new ArrayList<>();
		String texto_pregunta = "";
		int puntosPregunta = 0, opcioncorrecta = 0;
		boolean pregunta = false, respuesta = false, puntos = false;
		while ((linea = br.readLine()) != null) {

			try {

				// si empieza por ;P; es una pregunta
				if (linea.startsWith(";P;n1;")) {
					categoria = Categoria.nivel1;
					texto_pregunta = linea.substring(6);
					pregunta = true; // marco que ya tengo la pregunta

				} else if (linea.startsWith(";P;n2;")) {

					categoria = Categoria.nivel2;
					texto_pregunta = linea.substring(6);
					pregunta = true; // marco que ya tengo la pregunta

				} else if (linea.startsWith(";P;n3;")) {
					categoria = Categoria.nivel3;
					texto_pregunta = linea.substring(6);
					pregunta = true; // marco que ya tengo la pregunta

				} else if (linea.startsWith(";P;n4;")) {

					categoria = Categoria.nivel4;
					texto_pregunta = linea.substring(6);
					pregunta = true; // marco que ya tengo la pregunta

				} else if (linea.startsWith(";P;n5;")) {

					categoria = Categoria.nivel5;
					texto_pregunta = linea.substring(6);
					pregunta = true; // marco que ya tengo la pregunta

				} else if (pregunta && linea.startsWith(";R;")) {
					opcioncorrecta = Integer.parseInt(linea.substring(3).trim());
					respuesta = true; // marco que ya tengo la respuesta
					// Si la respuesta esta marcada, cojo los puntos
				} else if (respuesta) {
					puntosPregunta = Integer.parseInt(linea.trim());
					puntos = true; // marco los puntos
					// Si tengo la pregunta marcada, cojo la respuesta
					// Lo pongo el ultimo en caso de que no haya nada mas
				} else if (pregunta) {
					respuestas.add(new Respuesta(linea));
				}
				// Si tenemos marcado la pregunta, la respuesta, los puntos
				if (pregunta && respuesta && puntos) {

					// Marcamos la respuesta correcta como la correcta
					respuestas.get(opcioncorrecta - 1).setCorrecta(true);

					// añado la pregunta
					p = new Pregunta(texto_pregunta, respuestas, puntosPregunta, opcioncorrecta, categoria);
					preguntas.add(p);

					// reincio
					pregunta = false;
					respuesta = false;
					puntos = false;
					respuestas = new ArrayList<>();

				}

			} catch (Exception ex) {
				// reincio
				pregunta = false;
				respuesta = false;
				puntos = false;
				respuestas = new ArrayList<>();
			}
		}
		br.close();
	}

	/**
	 * metodo que categoriza las preguntas por niveles
	 * 
	 * @author Jhon gutierrez
	 *
	 */
	public void RealizarNivelesDificultad() {
		int p = preguntas.size();
		for (int i = 0; i < p; i++) {

			if (preguntas.get(i).getCategoria() == Categoria.nivel1) {
				nivel1.add(preguntas.get(i));

			}
			if (preguntas.get(i).getCategoria() == Categoria.nivel2) {
				nivel2.add(preguntas.get(i));

			}
			if (preguntas.get(i).getCategoria() == Categoria.nivel3) {
				nivel3.add(preguntas.get(i));

			}
			if (preguntas.get(i).getCategoria() == Categoria.nivel4) {
				nivel4.add(preguntas.get(i));
			}
			if (preguntas.get(i).getCategoria() == Categoria.nivel5) {
				nivel5.add(preguntas.get(i));
			}
		}

	}

	/**
	 * metodo que returna un numero aleatorio de 0 a 5
	 * 
	 * @author Jhon gutierrez
	 *
	 */
	public int elegirPreguntaAlAzar() {
		int numAleatorio = (int) Math.floor(Math.random() * 5);
		return numAleatorio;
	}

	public void llearlistajuego() {
		if (nivel1 != null) {

			Object[] arr = { nivel1, nivel2, nivel3, nivel4, nivel5 };
			for (int i = 0; i < arr.length; i++) {
				preguntasjuego.add(((ArrayList<Pregunta>) arr[i]).get(elegirPreguntaAlAzar()));

			}

		}
	}

	/**
	 * metodo que realiza la persistencia de los datos de lo jugadores
	 * 
	 * @author Jhon gutierrez
	 *
	 */
	public void guardarDatos() {
		try {
			ObjectOutputStream escribiendoArchivo = new ObjectOutputStream(new FileOutputStream("src/resourse/j.dat"));
			escribiendoArchivo.writeObject(jugadores);
			escribiendoArchivo.close();
		} catch (IOException e) {
			System.err.println("Error al escribir el archivo");
			e.printStackTrace();
		}
	}

	/**
	 * metodo que permite cargar los archivos de los jugadores registrados
	 * 
	 * 
	 * @author Jhon gutierrez
	 *
	 */
	@SuppressWarnings("unchecked")
	public void cargarArchivos() {
		try {
			ObjectInputStream leerArchivo = new ObjectInputStream(new FileInputStream("src/resourse/j.dat"));
			jugadores = (ArrayList<Jugador>) leerArchivo.readObject();
		} catch (IOException e) {
			System.err.println("Error al acceder al archivo");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * metodo que permite buscar un jugador por su nombre
	 * 
	 * @author Jhon gutierrez
	 *
	 */
	public Jugador BuscarJugador(String nombre) {
		for (Jugador jugador : jugadores) {
			if (jugador.getNombre().equals(nombre)) {
				return jugador;
			}
		}
		return null;
	}

}
