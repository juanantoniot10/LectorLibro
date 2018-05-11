package vita;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Insets;

public class PanelInicio extends JPanel{
	private JTextField txtElHobbit;
	private JTextField txtCuserstuusuarioalgoalgo;
	private JPanel panelTitulo;
	private JLabel titulo;
	private JPanel panelResultado;
	private JPanel panelImagen;
	
	public PanelInicio() {
		this.setLayout(new BorderLayout(0, 0));
		
		panelTitulo = new JPanel();
		panelTitulo.setForeground(Color.ORANGE);
		panelTitulo.setBackground(Color.BLACK);
		this.add(panelTitulo, BorderLayout.NORTH);
		
		titulo = new JLabel("LECTOR DE LIBROS");
		titulo.setForeground(Color.ORANGE);
		titulo.setFont(new Font("Showcard Gothic", Font.BOLD, 18));
		panelTitulo.add(titulo);
		
		JPanel panel = new JPanel();
		this.add(panel, BorderLayout.WEST);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panelBusqueda = new JPanel();
		panelBusqueda.setBackground(Color.BLACK);
		panel.add(panelBusqueda, BorderLayout.NORTH);
		panelBusqueda.setLayout(new BoxLayout(panelBusqueda, BoxLayout.Y_AXIS));
		
		JLabel lblNombreDeLibro = new JLabel("Nombre de libro");
		lblNombreDeLibro.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNombreDeLibro.setOpaque(true);
		lblNombreDeLibro.setForeground(Color.LIGHT_GRAY);
		lblNombreDeLibro.setBackground(Color.BLACK);
		panelBusqueda.add(lblNombreDeLibro);
		
		txtElHobbit = new JTextField();
		txtElHobbit.setMargin(new Insets(0, 0, 0, 2));
		txtElHobbit.setBackground(Color.DARK_GRAY);
		txtElHobbit.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtElHobbit.setForeground(Color.WHITE);
		txtElHobbit.setText("el hobbit");
		panelBusqueda.add(txtElHobbit);
		txtElHobbit.setColumns(10);
		
		JLabel lblRutaDeBusqueda = new JLabel("Ruta de busqueda");
		lblRutaDeBusqueda.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblRutaDeBusqueda.setForeground(Color.LIGHT_GRAY);
		panelBusqueda.add(lblRutaDeBusqueda);
		
		txtCuserstuusuarioalgoalgo = new JTextField();
		txtCuserstuusuarioalgoalgo.setMargin(new Insets(0, 0, 0, 0));
		txtCuserstuusuarioalgoalgo.setBackground(Color.DARK_GRAY);
		txtCuserstuusuarioalgoalgo.setCaretColor(Color.DARK_GRAY);
		txtCuserstuusuarioalgoalgo.setForeground(Color.WHITE);
		txtCuserstuusuarioalgoalgo.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtCuserstuusuarioalgoalgo.setText("c:/users/tuUsuario/algo/algo");
		panelBusqueda.add(txtCuserstuusuarioalgoalgo);
		txtCuserstuusuarioalgoalgo.setColumns(10);
		
		panelResultado = new JPanel();
		panelResultado.setBackground(Color.BLACK);
		panelResultado.setAutoscrolls(true);
		panel.add(panelResultado, BorderLayout.CENTER);
		panelResultado.setLayout(new BoxLayout(panelResultado, BoxLayout.Y_AXIS));
		
		panelImagen = new JPanel();
		panelImagen.setBackground(Color.BLACK);
		this.add(panelImagen, BorderLayout.CENTER);
		panelImagen.setLayout(new BoxLayout(panelImagen, BoxLayout.X_AXIS));
		ImageIcon imagen = new ImageIcon("img/fondo.jpg");
		JLabel labelImagen = new JLabel(imagen);
		labelImagen.setBackground(Color.BLACK);
		labelImagen.setMinimumSize(new Dimension(200, 200));
		labelImagen.setMaximumSize(new Dimension(1000, 700));
		panelImagen.add(labelImagen);
	}

	public JTextField getTxtElHobbit() {
		return txtElHobbit;
	}

	public void setTxtElHobbit(JTextField txtElHobbit) {
		this.txtElHobbit = txtElHobbit;
	}

	public JTextField getTxtCuserstuusuarioalgoalgo() {
		return txtCuserstuusuarioalgoalgo;
	}

	public void setTxtCuserstuusuarioalgoalgo(JTextField txtCuserstuusuarioalgoalgo) {
		this.txtCuserstuusuarioalgoalgo = txtCuserstuusuarioalgoalgo;
	}

	public JPanel getPanelTitulo() {
		return panelTitulo;
	}

	public void setPanelTitulo(JPanel panelTitulo) {
		this.panelTitulo = panelTitulo;
	}

	public JLabel getTitulo() {
		return titulo;
	}

	public void setTitulo(JLabel titulo) {
		this.titulo = titulo;
	}

	public JPanel getPanelResultado() {
		return panelResultado;
	}

	public void setPanelResultado(JPanel panelResultado) {
		this.panelResultado = panelResultado;
	}

	public JPanel getPanelImagen() {
		return panelImagen;
	}

	public void setPanelImagen(JPanel panelImagen) {
		this.panelImagen = panelImagen;
	}
	
}
