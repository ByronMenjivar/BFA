package presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Menu extends JFrame {

	private JPanel contentPane;
	private JTextField tfdui;
	private JTextField tfnombre;
	private JTextField tfapellido;
	private JTextField tftelefono;
	private JTextField tfedad;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Menu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 461, 475);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Dui");
		lblNewLabel.setBounds(29, 11, 24, 14);
		panel.add(lblNewLabel);
		
		tfdui = new JTextField();
		tfdui.setBounds(63, 5, 187, 20);
		panel.add(tfdui);
		tfdui.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("nombre");
		lblNewLabel_1.setBounds(22, 40, 46, 14);
		panel.add(lblNewLabel_1);
		
		tfnombre = new JTextField();
		tfnombre.setBounds(63, 36, 187, 20);
		panel.add(tfnombre);
		tfnombre.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("apellido");
		lblNewLabel_2.setBounds(22, 79, 46, 14);
		panel.add(lblNewLabel_2);
		
		tfapellido = new JTextField();
		tfapellido.setBounds(63, 73, 187, 20);
		panel.add(tfapellido);
		tfapellido.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("telefono");
		lblNewLabel_3.setBounds(22, 113, 46, 14);
		panel.add(lblNewLabel_3);
		
		tftelefono = new JTextField();
		tftelefono.setBounds(63, 107, 187, 20);
		panel.add(tftelefono);
		tftelefono.setColumns(10);
		
		tfedad = new JTextField();
		tfedad.setBounds(63, 140, 187, 20);
		panel.add(tfedad);
		tfedad.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("edad");
		lblNewLabel_4.setBounds(22, 146, 46, 14);
		panel.add(lblNewLabel_4);
		
		JButton btnsave = new JButton("guardar");
		btnsave.setBounds(295, 7, 89, 23);
		panel.add(btnsave);
		
		JButton btncancel = new JButton("cancelar");
		btncancel.setBounds(295, 139, 89, 23);
		panel.add(btncancel);
		
		JButton btnedit = new JButton("editar");
		btnedit.setBounds(295, 36, 89, 23);
		panel.add(btnedit);
		
		JButton btnupdate = new JButton("actualizar");
		btnupdate.setBounds(295, 70, 89, 23);
		panel.add(btnupdate);
		
		JButton btneliminar = new JButton("eliminar");
		btneliminar.setBounds(295, 106, 89, 23);
		panel.add(btneliminar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 230, 395, 137);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"id", "dni", "nombre", "apellido", "telefono", "edad"
			}
		));
		scrollPane.setViewportView(table);
	}
}
