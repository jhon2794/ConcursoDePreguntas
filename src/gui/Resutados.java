package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Logica.Jugador;
import Logica.Test;

public class Resutados extends JFrame {

	private Test t;
	private JPanel contentPane;
	private JTable tableParticipantes;
	private JButton btnSalir;
	private JLabel lblTitulo;
	private DefaultTableModel model;
	private JButton btnEliminar;

	/**
	 * Create the frame.
	 */
	public Resutados(Test t) {
		this.t= t;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 432, 309);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		setUndecorated(true);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(35, 44, 342, 187);
		contentPane.add(scrollPane);

		tableParticipantes = new JTable();
		model = new DefaultTableModel();
		tableParticipantes.setModel(model);
		model.addColumn("NOMBRE");
		model.addColumn("PUNTAJE");

		tableParticipantes.getColumnModel().getColumn(1).setPreferredWidth(15);
		scrollPane.setViewportView(tableParticipantes);

		
		
		btnSalir.setBounds(219, 242, 158, 23);
		contentPane.add(btnSalir);

		lblTitulo = new JLabel("HISTORIAL DE PARTICIPANTES");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(35, 11, 342, 22);
		contentPane.add(lblTitulo);
	
		llenarTabla();
	}

	/**
	 * metodo que llema la tabla con los participantes registrados
	 */
	public void llenarTabla() {
		ArrayList<Jugador> jugadores= t.getJugadores();
		model.setRowCount(0);
		model.setColumnCount(2);
		for (Jugador jugador : jugadores) {
			Object[] fila = new Object[2];
			fila[0] = jugador.getNombre();
			model.addRow(fila);
		}
	}
}
