package presentacion;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import entidades.Persona;
import negocio.PersonaControl;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Menu extends JFrame {

	private JPanel contentPane;
	private JTextField tfdui;
	private JTextField tfnombre;
	private JTextField tfapellido;
	private JTextField tftelefono;
	private JTextField tfedad;
	private JTable table;
	private Persona persona;
	private PersonaControl personasControl;
	private JButton btnsave;
	private JButton btnupdate;
	
	private int filac;
	private JTextField tfid;

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
		personasControl = new PersonaControl();
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
		
		btnsave = new JButton("guardar");
		btnsave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String resp = personasControl.insertar(tfdui.getText(), tfnombre.getText(), tfapellido.getText(), tftelefono.getText(), Integer.parseInt(tfedad.getText()));
				if(resp.equalsIgnoreCase("ok")){
		            mostrarMensajeOK("Se registro correctamente");
		            mostrarRegistros();
		            limpiar();
		        }else{
		            mostrarMensajeError(resp);
		        }
				
			}
		});
		btnsave.setBounds(295, 7, 89, 23);
		panel.add(btnsave);
		
		JButton btncancel = new JButton("cancelar");
		btncancel.setBounds(295, 139, 89, 23);
		panel.add(btncancel);
		
		JButton btnedit = new JButton("editar");
		btnedit.setBounds(295, 36, 89, 23);
		panel.add(btnedit);
		
		btnupdate = new JButton("actualizar");
		btnupdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String resp = personasControl.actualizar(new Persona(Integer.parseInt(tfid.getText()),tfdui.getText(), tfnombre.getText(), tfapellido.getText(), tftelefono.getText(), Integer.parseInt(tfedad.getText())));
				if(resp.equalsIgnoreCase("ok")){
		            mostrarMensajeOK("Se registro correctamente");
		            mostrarRegistros();
		            limpiar();
		        }else{
		            mostrarMensajeError(resp);
		        }
			}
		});
		btnupdate.setBounds(295, 70, 89, 23);
		panel.add(btnupdate);
		
		JButton btneliminar = new JButton("eliminar");
		btneliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tfid.getText().isEmpty()) {
					mostrarMensajeError("no se puede con datos vacios");
		        }else{
		            if (personasControl.buscar(Integer.parseInt(tfid.getText())) == null) {
		            	mostrarMensajeError("No existe la persona con el dni: " + tfid.getText());
		            }else{
		                String resp = personasControl.eliminar(Integer.parseInt(tfid.getText()));
		                if (resp.equalsIgnoreCase("ok")) {
		                    mostrarMensajeOK("Se elimino correctamente");
		                    mostrarRegistros();
		                    limpiar();
		                }else{
		                    mostrarMensajeError(resp);
		                }
		            }
		        }
			}
		});
		btneliminar.setBounds(295, 106, 89, 23);
		panel.add(btneliminar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 230, 395, 137);
		panel.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (arg0.getClickCount() == 2) {
					filac = table.getSelectedRow();
			           if (filac != -1)
			           {
			        	   Persona p = personasControl.buscar(Integer.parseInt(String.valueOf(table.getValueAt(filac, 0))));
			        	   tfid.setText(String.valueOf(p.getIdPersona()));
			        	   tfdui.setText(p.getDni());
			               tfnombre.setText(p.getNombre());
			               tfapellido.setText(p.getApellido());
			               tftelefono.setText(p.getTelefono());
			               tfedad.setText(String.valueOf(p.getEdad()));
				}
			}
		}
		});
		mostrarRegistros();
		scrollPane.setViewportView(table);
		
		tfid = new JTextField();
		tfid.setEnabled(false);
		tfid.setEditable(false);
		tfid.setVisible(false);
		tfid.setBounds(170, 171, 86, 20);
		panel.add(tfid);
		tfid.setColumns(10);
		setLocationRelativeTo(null);
	}
	
	public void mostrarRegistros() {
		table.setModel(personasControl.mostrar());
	}
	
	private void mostrarMensajeOK(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Mensaje", JOptionPane.INFORMATION_MESSAGE);
    }
	
	private void mostrarMensajeError(String mensaje) {
		JOptionPane.showMessageDialog(this, mensaje, "Mensaje", JOptionPane.ERROR_MESSAGE);
	}
	
	private void limpiar(){
		tfid.setText("");
		tfdui.setText("");
        tfnombre.setText("");
        tfapellido.setText("");
        tftelefono.setText("");
        tfedad.setText("");
        tfdui.requestFocus();
    }
	
	private void deshabilitarBoton(){
		btnsave.setEnabled(false);
    }
    
    private void habilitarBoton(){
    	btnupdate.setEnabled(true);
    }
}

