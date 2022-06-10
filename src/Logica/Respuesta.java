package Logica;
/**
 * clase que contiene informacion de las respuestas
 * 
 * @author Jhon gutierrez
 *
 */
public class Respuesta {
	
private String respuesta;
private boolean correcta;

public Respuesta(String respuesta) {
	super();
	this.respuesta = respuesta;
	this.correcta = true;
}
public String getRespuesta() {
	return respuesta;
}
public void setRespuesta(String respuesta) {
	this.respuesta = respuesta;
}
public boolean isCorrecta() {
	return correcta;
}
public void setCorrecta(boolean correcta) {
	this.correcta = correcta;
}
@Override
public String toString() {
	return respuesta;
}


}
