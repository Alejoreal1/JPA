package gui;

import java.awt.EventQueue;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import dao.MascotaDao;
import entidades.Mascota;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JTextPane;


public class VentanaMascota extends JFrame implements ActionListener  {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtId, txtNombre, txtRaza, txtSexo;
	private JButton btnConsultar, btnRegistrar, btnActualizar, btnEliminar, btnConsultarLista, btnLimpiar, btnConsultarListaSexo ;
	private JScrollPane scrollPane;
	private JTextArea textArea;
	private JTextField txtColor;

	public VentanaMascota() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Agregar Mascota");
		setResizable(false);
		setBounds(100, 100, 749, 592);
		setLocationRelativeTo(null);
		iniciarComponentes();
		
	}

	private void iniciarComponentes() {
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitulo = new JLabel("MASCOTAS ALEJO");
		lblTitulo.setFont(new Font("Arial", Font.BOLD, 16));
		lblTitulo.setBounds(150, 11, 174, 19);
		contentPane.add(lblTitulo);
		
		txtId = 	new JTextField();
		txtId.setBounds(102, 57, 147, 20);
		contentPane.add(txtId);
		txtId.setColumns(10);
		
		JLabel lblId = new JLabel("Id Mascota:");
		lblId.setFont(new Font("Arial", Font.PLAIN, 12));
		lblId.setBounds(20, 60, 72, 14);
		contentPane.add(lblId);
		
		JLabel lblRaza = new JLabel("Raza:");
		lblRaza.setBackground(new Color(0, 0, 0));
		lblRaza.setForeground(new Color(0, 0, 0));
		lblRaza.setFont(new Font("Arial", Font.PLAIN, 12));
		lblRaza.setBounds(265, 91, 39, 14);
		contentPane.add(lblRaza);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(102, 88, 147, 20);
		contentPane.add(txtNombre);
		
		txtRaza = new JTextField();
		txtRaza.setColumns(10);
		txtRaza.setBounds(300, 88, 86, 20);
		contentPane.add(txtRaza);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNombre.setBounds(20, 91, 59, 14);
		contentPane.add(lblNombre);
		
		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setBackground(new Color(0, 0, 0));
		lblSexo.setForeground(new Color(0, 0, 0));
		lblSexo.setFont(new Font("Arial", Font.PLAIN, 12));
		lblSexo.setBounds(265, 60, 39, 14);
		contentPane.add(lblSexo);
		
		txtSexo = new JTextField();
		txtSexo.setColumns(10);
		txtSexo.setBounds(300, 57, 86, 20);
		contentPane.add(txtSexo);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(20, 156, 355, 2);
		contentPane.add(separator);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.setFont(new Font("Arial", Font.BOLD, 12));
		btnConsultar.setBounds(20, 169, 174, 23);
		btnConsultar.addActionListener(this);
		contentPane.add(btnConsultar);
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.setFont(new Font("Arial", Font.BOLD, 12));
		btnRegistrar.setBounds(201, 169, 174, 23);
		btnRegistrar.addActionListener(this);
		contentPane.add(btnRegistrar);
		
		btnActualizar = new JButton("Actualizar");
		btnActualizar.setFont(new Font("Arial", Font.BOLD, 12));
		btnActualizar.setBounds(20, 203, 174, 23);
		btnActualizar.addActionListener(this);
		contentPane.add(btnActualizar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setFont(new Font("Arial", Font.BOLD, 12));
		btnEliminar.setBounds(20, 237, 174, 23);
		btnEliminar.addActionListener(this);
		contentPane.add(btnEliminar);
		
		btnConsultarLista = new JButton("Consultar Lista");
		btnConsultarLista.setFont(new Font("Arial", Font.BOLD, 12));
		btnConsultarLista.setBounds(201, 203, 174, 23);
		btnConsultarLista.addActionListener(this);
		contentPane.add(btnConsultarLista);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 314, 355, 213);
		contentPane.add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setFont(new Font("Arial", Font.BOLD, 12));
		btnLimpiar.setBounds(20, 271, 355, 23);
		btnLimpiar.addActionListener(this);
		contentPane.add(btnLimpiar);
		
		btnConsultarListaSexo = new JButton("Consultar Lista Sexo");
		btnConsultarListaSexo.setFont(new Font("Arial", Font.BOLD, 12));
		btnConsultarListaSexo.setBounds(201, 237, 174, 23);
		btnConsultarListaSexo.addActionListener(this);
		contentPane.add(btnConsultarListaSexo);
		
		JLabel lblColor = new JLabel("Color:");
		lblColor.setFont(new Font("Arial", Font.PLAIN, 12));
		lblColor.setBounds(102, 119, 59, 14);
		contentPane.add(lblColor);
		 
		txtColor = new JTextField();
		txtColor.setColumns(10);
		txtColor.setBounds(171, 116, 147, 20);
		contentPane.add(txtColor);
		
		ImageIcon imagenOriginal = new ImageIcon(VentanaMascota.class.getResource("/img/mascotas.jpg"));
		Image img = imagenOriginal.getImage(); // Obtener la imagen

		// Escalar la imagen al tamaño deseado (ej. 200x150)
		Image imagenEscalada = img.getScaledInstance(753, 553, Image.SCALE_SMOOTH);

		JLabel fondoP = new JLabel("");
		fondoP.setIcon(new ImageIcon(imagenEscalada));
		// Ahora puedes añadir fondoP a un contenedor con un Layout Manager o setBounds
		contentPane.add(fondoP);
		 fondoP.setBounds(0, 0, 733, 553); // Si usas setBounds
	}
	
	private MascotaDao mascotaDao = new MascotaDao();

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnRegistrar) {
			registrarMascota();
		} else if (e.getSource() == btnConsultar) {
			consultarMascota();
		} else if (e.getSource() == btnActualizar) {
			actualizarMascota();
		} else if (e.getSource() == btnEliminar) {
			eliminarMascota();
		} else if (e.getSource() == btnConsultarLista) {
			consultarLista();
		} else if (e.getSource() == btnLimpiar) {
			limpiarCampos();
		}else if (e.getSource() == btnConsultarListaSexo) {
			consultarListaPorSexo();
		}
	}
	
	
	private void registrarMascota() {
		Mascota mascota = new Mascota();
		mascota.setId(Long.parseLong(txtId.getText()));
		mascota.setNombre(txtNombre.getText());
		mascota.setRaza(txtRaza.getText());
		mascota.setColorMascota(txtColor.getText());
		mascota.setSexo(txtSexo.getText());

		String resultado = mascotaDao.registrarMascota(mascota);
		textArea.setText("Resultado del registro: " + resultado);
	}

	private void consultarMascota() {
		Long id = Long.parseLong(txtId.getText());
		Mascota mascota = mascotaDao.consultarMascota(id);
		if (mascota != null) {
			textArea.setText(mascota.toString());
			txtNombre.setText(mascota.getNombre());
			txtRaza.setText(mascota.getRaza());
			txtColor.setText(mascota.getColorMascota());
			txtSexo.setText(mascota.getSexo());
		} else {
			textArea.setText("No se encontró la mascota");
		}
	}

	private void actualizarMascota() {
		Long id = Long.parseLong(txtId.getText());
		Mascota mascota = mascotaDao.consultarMascota(id);
		if (mascota != null) {
			mascota.setNombre(txtNombre.getText());
			mascota.setRaza(txtRaza.getText());
			mascota.setColorMascota(txtColor.getText());
			mascota.setSexo(txtSexo.getText());

			String resultado = mascotaDao.actualizarMascota(mascota);
			textArea.setText("Resultado de la actualización: " + resultado);
		} else {
			textArea.setText("No se encontró la mascota");
		}
	}
	
	private void eliminarMascota() {
		Long id = Long.parseLong(txtId.getText());
		Mascota mascota = mascotaDao.consultarMascota(id);
		if (mascota != null) {
			String resultado = mascotaDao.eliminarMascota(mascota);
			textArea.setText("Resultado de eliminación: " + resultado);
			limpiarCampos();
		} else {
			textArea.setText("No se encontró la mascota");
		}
		
	}

	private void consultarLista() {
		List<Mascota> lista = mascotaDao.consultarListaMascotas();
		StringBuilder sb = new StringBuilder("Lista de Mascotas:\n");
		for (Mascota m : lista) {
			sb.append(m).append("\n");
		}
		textArea.setText(sb.toString());
	}
	
	private void consultarListaPorSexo() {
		String sexo = txtSexo.getText();
		List<Mascota> lista = mascotaDao.consultarListaMascotasPorSexo(sexo);
		StringBuilder sb = new StringBuilder("Mascotas de sexo " + sexo + ":\n");
		for (Mascota m : lista) {
			sb.append(m).append("\n");
		}
		textArea.setText(sb.toString());
	}

	private void limpiarCampos() {
		txtId.setText("");
		txtNombre.setText("");
		txtRaza.setText("");
		txtSexo.setText("");
		txtColor.setText("");
		textArea.setText("");
	}
}
