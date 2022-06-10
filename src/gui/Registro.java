package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Logica.Jugador;
import Logica.Test;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
/**
 * ventana que permite registrar un jugador
 * 
 * @author Jhon gutierrez
 *
 */
public class Registro extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lblTituloRegistro;
	private JTextField textNombre;
	private Test t;
	private JButton btnguardar;
	VentanaTests ventanaTests;
	private JButton btnsalir;

	public Registro(Test t) {
		this.t = t;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		lblTituloRegistro = new JLabel("REGISTRATE");
		lblTituloRegistro.setForeground(Color.BLUE);
		lblTituloRegistro.setBounds(47, 28, 176, 22);
		contentPane.add(lblTituloRegistro);

		JLabel lblNombre = new JLabel("Nombre: ");
		lblNombre.setBounds(10, 61, 99, 22);
		contentPane.add(lblNombre);

		textNombre = new JTextField();
		textNombre.setBounds(10, 88, 147, 29);
		contentPane.add(textNombre);
		textNombre.setColumns(10);

		btnguardar = new JButton("Guardar");
		btnguardar.addActionListener(this);

		btnsalir = new JButton("Salir");
		btnsalir.addActionListener(this);

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup().addContainerGap()
				.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(btnsalir, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnguardar, GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE))
				.addContainerGap(280, Short.MAX_VALUE)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addGap(155).addComponent(btnguardar).addGap(27)
						.addComponent(btnsalir).addContainerGap(23, Short.MAX_VALUE)));
		contentPane.setLayout(gl_contentPane);
	}
	/**
	 * metodo que permite capturar el evento de los botones y guardar un jugador
	 *
	 * 
	 * @author Jhon gutierrez
	 *
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == btnguardar) {
			if (textNombre.getText().isEmpty()){
				ventanaTests.mostrarMensaje("Por favor complete los campos del formulario");
			} else {
				String nombre = textNombre.getText();
				t.getJugadores().add(new Jugador(nombre));
				
			}

		}
		if (e.getSource() == btnsalir) {
			MenuPrincipal menu = new MenuPrincipal(t);
			t.guardarDatos();
			menu.setVisible(true);
			setVisible(false);

		}

	}
}
