package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import Logica.Pregunta;
import Logica.Test;

/**
 * ventana que muestra historial de los jugadores
 * 
 * @author Jhon gutierrez
 *
 */
public class Resutados extends JFrame implements ActionListener {

	private Test t;
	private JPanel contentPane;
	private JTable tableParticipantes;
	private JLabel lblTitulo;
	private DefaultTableModel model;
	ArrayList<Jugador> jugadores;
	private JScrollPane scrollPane;
	private JButton btnsalir;

	/**
	 * Create the frame.
	 */
	public Resutados(Test t) {
		jugadores = t.getJugadores();
		this.t = t;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 432, 309);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		setUndecorated(true);
		contentPane.setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(35, 44, 342, 187);
		contentPane.add(scrollPane);

		tableParticipantes = new JTable();
		model = new DefaultTableModel();
		tableParticipantes.setModel(model);
		model.addColumn("NOMBRE");
		model.addColumn("PUNTAJE");

		tableParticipantes.getColumnModel().getColumn(1).setPreferredWidth(15);
		scrollPane.setViewportView(tableParticipantes);

		lblTitulo = new JLabel("HISTORIAL DE PARTICIPANTES");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(35, 11, 342, 22);
		contentPane.add(lblTitulo);

		btnsalir = new JButton("Salir");
		btnsalir.setBounds(155, 258, 113, 23);
		btnsalir.addActionListener(this);
		contentPane.add(btnsalir);
		llenarTabla();
	}

	/**
	 * metodo que llema la tabla con los participantes registrados
	 */
	public void llenarTabla() {
		model.setRowCount(0);
		model.setColumnCount(2);
		Object[] fila = new Object[2];
		fila[0] = jugadores.get(0).getNombre();
		fila[0] = jugadores.get(0).getPuntaje();
		model.addRow(fila);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnsalir) {
			MenuPrincipal menuPrincipal = new MenuPrincipal(t);
			menuPrincipal.setVisible(true);
			setVisible(false);

		}

	}
}
