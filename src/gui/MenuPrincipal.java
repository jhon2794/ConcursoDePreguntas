package gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Logica.Test;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;

public class MenuPrincipal extends JFrame implements ActionListener {
	private Test t;
	private JButton btnjugar;
	private JButton btnregistrarse;
	private JButton btnHistorial;
	VentanaTests ventanaTests;
	Registro registro;
	private JButton btnSalir;

	public MenuPrincipal(Test t) {
		this.ventanaTests = ventanaTests;
		this.t = t;
		setBounds(500, 50, 500, 500);
		setTitle("ConcursoDePreguntas");
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		btnjugar = new JButton("Jugar");
		btnjugar.addActionListener(this);

		btnHistorial = new JButton("Historial");
		btnHistorial.addActionListener(this);

		btnregistrarse = new JButton("Registrarse");
		btnregistrarse.addActionListener(this);

		btnSalir = new JButton("Salir");
		btnSalir.addActionListener(this);

		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addGap(84)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnSalir, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE)
						.addComponent(btnregistrarse, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 315,
								Short.MAX_VALUE)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(btnHistorial, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
										GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnjugar, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 306,
										Short.MAX_VALUE)))
				.addContainerGap(85, Short.MAX_VALUE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addGap(87).addComponent(btnjugar).addGap(59)
						.addComponent(btnHistorial).addGap(49).addComponent(btnregistrarse).addGap(65)
						.addComponent(btnSalir).addContainerGap(109, Short.MAX_VALUE)));
		getContentPane().setLayout(groupLayout);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnjugar) {
				String name = JOptionPane.showInputDialog("introduzca el nombre");
				if (t.BuscarJugador(name)!=null) {
					VentanaTests ventanaTests = new VentanaTests(t,name);
					ventanaTests.setVisible(true);
					setVisible(false);
				} else {
					JOptionPane.showMessageDialog(null, "no se encuentra registrado");
				}

		}
		if (e.getSource() == btnregistrarse) {
			Registro ventanatest = new Registro(t);
			ventanatest.setVisible(true);
			setVisible(false);
		}
		if (e.getSource() == btnHistorial) {
			Resutados r = new Resutados(t);
			r.setVisible(true);
			setVisible(false);

		}
		if (e.getSource() == btnSalir) {
			setVisible(false);
		}
	}
}
