package Logica;

import java.util.ArrayList;
/**
 *clase que contiene informacion de las preguntas
 * 
 * @author Jhon gutierrez
 *
 */
public class Pregunta {

	private String pregunta;
	private ArrayList<Respuesta> respuestas;
	private int puntos, respuestacorrecta;
	private Categoria categoria;

	public Pregunta(String pregunta, ArrayList<Respuesta> respuestas, int puntos, int respuestacorrecta,
			Categoria categoria) {
		super();
		this.pregunta = pregunta;
		this.respuestas = respuestas;
		this.puntos = puntos;
		this.respuestacorrecta = respuestacorrecta;
		this.categoria = categoria;
	}

	public String getPregunta() {
		return pregunta;
	}

	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}

	public ArrayList<Respuesta> getRespuestas() {
		return respuestas;
	}

	public void setRespuestas(ArrayList<Respuesta> respuestas) {
		this.respuestas = respuestas;
	}

	public int getPuntos() {
		return puntos;
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}

	public int getRespuestacorrecta() {
		return respuestacorrecta;
	}

	public void setRespuestacorrecta(int respuestacorrecta) {
		this.respuestacorrecta = respuestacorrecta;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

}
