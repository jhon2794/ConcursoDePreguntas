package gui;

import java.awt.BorderLayout;
import java.awt.Desktop.Action;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.JTextComponent;

import Logica.Jugador;
import Logica.Pregunta;
import Logica.Respuesta;
import Logica.Test;

import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JDesktopPane;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.awt.event.ActionEvent;
/**
 * ventana que carga las preguntas y respuesta.
 * 
 * @author Jhon gutierrez
 *
 */
public class VentanaTests extends JFrame implements ActionListener {
	private Test t;
	private Jugador jugador;
	ArrayList<Pregunta> preguntas;
	private JLabel lblPregunta;
	private JButton btnRespuesta1;
	private JButton btnRespuesta2;
	private JButton btnRespuesta3;
	private JButton btnRespuesta4;
	private JButton btnretirada;
	private int numeroPregunta;
	int puntosacumulados;
	private JLabel puntaje;

	public VentanaTests(Test t, String s) {
		this.jugador = t.BuscarJugador(s);
		this.t = t;
		getContentPane().setLayout(null);
		lblPregunta = new JLabel("");
		lblPregunta.setBounds(32, 23, 442, 143);
		getContentPane().add(lblPregunta);
		
		puntaje = new JLabel("");
		puntaje.setBounds(6, 11, 253, 14);
		getContentPane().add(puntaje);
		

		btnretirada = new JButton("RETIRADA");
		btnretirada.setBounds(357, 427, 89, 23);
		getContentPane().add(btnretirada);
		btnretirada.addActionListener(this);

		btnRespuesta1 = new JButton("");
		btnRespuesta1.setBounds(54, 210, 381, 23);
		getContentPane().add(btnRespuesta1);
		btnRespuesta1.addActionListener(this);
		getContentPane().add(btnRespuesta1);

		btnRespuesta2 = new JButton("");
		btnRespuesta2.setBounds(54, 264, 381, 23);
		getContentPane().add(btnRespuesta2);
		btnRespuesta2.addActionListener(this);
		getContentPane().add(btnRespuesta2);

		btnRespuesta3 = new JButton("");
		btnRespuesta3.setBounds(54, 317, 381, 23);
		getContentPane().add(btnRespuesta3);
		btnRespuesta3.addActionListener(this);
		getContentPane().add(btnRespuesta3);

		btnRespuesta4 = new JButton("");
		btnRespuesta4.setBounds(54, 374, 381, 23);
		getContentPane().add(btnRespuesta4);
		btnRespuesta4.addActionListener(this);
		getContentPane().add(btnRespuesta4);
		setBounds(500, 50, 500, 500);
		setTitle("ConcursoDePreguntas");
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		preguntas = t.getPreguntasjuego();
		numeroPregunta = 0;
		puntosacumulados = 0;
		cargarpreguntas(preguntas.get(numeroPregunta));
	}
	/**
	 *metodo que carga las preguntas y respuestas en la ventana
	 * 
	 * @author Jhon gutierrez
	 *
	 */
	public void cargarpreguntas(Pregunta p) {
		puntaje.setText(jugador.getNombre() + " tu puntaje es: " + jugador.getPuntaje());
		lblPregunta.setText(p.getPregunta());
		btnRespuesta1.setText(p.getRespuestas().get(0).getRespuesta());
		btnRespuesta2.setText(p.getRespuestas().get(1).getRespuesta());
		btnRespuesta3.setText(p.getRespuestas().get(2).getRespuesta());
		btnRespuesta4.setText(p.getRespuestas().get(3).getRespuesta());
	}
	/**
	 * metodo que captura los eventos de los botones que contiene las respuestas
	 * y envia la pregunta para verificar si es correcta o no
	 * 
	 * @author Jhon gutierrez
	 *
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnRespuesta1) {
			if (respuestacorrecta(1, numeroPregunta)) {
				cargarpreguntas(preguntas.get(numeroPregunta));
			}
		}
		if (e.getSource() == btnRespuesta2) {
			if (respuestacorrecta(2, numeroPregunta)) {

				cargarpreguntas(preguntas.get(numeroPregunta));
			}
		}
		if (e.getSource() == btnRespuesta3) {
			if (respuestacorrecta(3, numeroPregunta)) {
				cargarpreguntas(preguntas.get(numeroPregunta));
			}
		}
		if (e.getSource() == btnRespuesta4) {
			if (respuestacorrecta(4, numeroPregunta)) {
				cargarpreguntas(preguntas.get(numeroPregunta));
			}
		}
		if (e.getSource() == btnretirada) {
			mostrarMensaje(jugador.getNombre() + " Su puntaje fue: " + puntosacumulados);
			jugador.setPuntaje(puntosacumulados);
			setVisible(false);

		}

	}
	/**
	 * metodo que verifica si la respuesta es correcta, acumula los puntos, y permite cambiar la pregunta 
	 * si la respuesta es correcta
	 * 
	 * @author Jhon gutierrez
	 *
	 */

	public boolean respuestacorrecta(int i, int j) {
		if (i == preguntas.get(j).getRespuestacorrecta()) {
			numeroPregunta++;
			if (numeroPregunta == 5) {
				mostrarMensaje(jugador.getNombre() + "ganaste" + "\n" + puntosacumulados);
				setVisible(false);
				jugador.setPuntaje(puntosacumulados);
				return false;
			}
			puntosacumulados += preguntas.get(numeroPregunta).getPuntos();
			jugador.setPuntaje(puntosacumulados);
			return true;
		}
		numeroPregunta = 0;
		puntosacumulados = 0;
		jugador.setPuntaje(puntosacumulados);
		mostrarMensaje(jugador.getNombre()   + " perdiste" + " Su puntaje fue: " + puntosacumulados);
		MenuPrincipal menuPrincipal = new MenuPrincipal(t);
		menuPrincipal.setVisible(true);
		cargarpreguntas(preguntas.get(numeroPregunta));
		setVisible(false);
		return false;
	}
	/**
	 * meotodo que sirve para mostrar mensajes al usuario
	 * 
	 * @author Jhon gutierrez
	 *
	 */
	public void mostrarMensaje(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje);
	}
}
