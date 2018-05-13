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
import javax.swing.SwingConstants;

public class PanelInicio extends JPanel{
	private JTextField txtElHobbit;
	private JTextField txtCuserstuusuarioalgoalgo;
	private JPanel panelTitulo;
	private JLabel titulo;
	private JPanel panelResultado;
	private JPanel panelImagen;
	
	public PanelInicio() {
		setBackground(Color.BLACK);
		setMaximumSize(new Dimension(700, 500));
		setLayout(null);
		
		panelTitulo = new JPanel();
		panelTitulo.setBounds(0, 0, 700, 33);
		panelTitulo.setForeground(Color.ORANGE);
		panelTitulo.setBackground(Color.BLACK);
		this.add(panelTitulo);
		
		titulo = new JLabel("LECTOR DE LIBROS");
		titulo.setForeground(Color.ORANGE);
		titulo.setFont(new Font("Showcard Gothic", Font.BOLD, 18));
		panelTitulo.add(titulo);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 33, 155, 445);
		panel.setMinimumSize(new Dimension(155, 10));
		panel.setMaximumSize(new Dimension(155, 55300));
		this.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panelBusqueda = new JPanel();
		panelBusqueda.setPreferredSize(new Dimension(155, 70));
		panelBusqueda.setSize(new Dimension(155, 100));
		panelBusqueda.setMinimumSize(new Dimension(155, 10));
		panelBusqueda.setMaximumSize(new Dimension(155, 32767));
		panelBusqueda.setBackground(Color.BLACK);
		panel.add(panelBusqueda, BorderLayout.NORTH);
		panelBusqueda.setLayout(null);
		
		JLabel lblNombreDeLibro = new JLabel("Nombre de libro");
		lblNombreDeLibro.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombreDeLibro.setBounds(0, 0, 155, 16);
		lblNombreDeLibro.setMinimumSize(new Dimension(155, 14));
		lblNombreDeLibro.setMaximumSize(new Dimension(155, 14));
		lblNombreDeLibro.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNombreDeLibro.setOpaque(true);
		lblNombreDeLibro.setForeground(Color.LIGHT_GRAY);
		lblNombreDeLibro.setBackground(Color.BLACK);
		panelBusqueda.add(lblNombreDeLibro);
		
		txtElHobbit = new JTextField();
		txtElHobbit.setBounds(0, 16, 155, 17);
		txtElHobbit.setMinimumSize(new Dimension(155, 20));
		txtElHobbit.setMaximumSize(new Dimension(155, 150));
		txtElHobbit.setMargin(new Insets(0, 0, 0, 2));
		txtElHobbit.setBackground(Color.DARK_GRAY);
		txtElHobbit.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtElHobbit.setForeground(Color.WHITE);
		txtElHobbit.setText("el hobbit");
		panelBusqueda.add(txtElHobbit);
		txtElHobbit.setColumns(10);
		
		JLabel lblRutaDeBusqueda = new JLabel("Ruta de busqueda");
		lblRutaDeBusqueda.setHorizontalAlignment(SwingConstants.CENTER);
		lblRutaDeBusqueda.setBounds(0, 33, 155, 15);
		lblRutaDeBusqueda.setMinimumSize(new Dimension(155, 14));
		lblRutaDeBusqueda.setMaximumSize(new Dimension(155, 14));
		lblRutaDeBusqueda.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblRutaDeBusqueda.setForeground(Color.LIGHT_GRAY);
		panelBusqueda.add(lblRutaDeBusqueda);
		
		txtCuserstuusuarioalgoalgo = new JTextField();
		txtCuserstuusuarioalgoalgo.setBounds(0, 48, 155, 16);
		txtCuserstuusuarioalgoalgo.setMinimumSize(new Dimension(155, 20));
		txtCuserstuusuarioalgoalgo.setMaximumSize(new Dimension(155, 2147483647));
		txtCuserstuusuarioalgoalgo.setMargin(new Insets(0, 0, 0, 0));
		txtCuserstuusuarioalgoalgo.setBackground(Color.DARK_GRAY);
		txtCuserstuusuarioalgoalgo.setCaretColor(Color.DARK_GRAY);
		txtCuserstuusuarioalgoalgo.setForeground(Color.WHITE);
		txtCuserstuusuarioalgoalgo.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtCuserstuusuarioalgoalgo.setText("c:/users/tuUsuario/algo/algo");
		panelBusqueda.add(txtCuserstuusuarioalgoalgo);
		txtCuserstuusuarioalgoalgo.setColumns(10);
		
		panelResultado = new JPanel();
		panelResultado.setPreferredSize(new Dimension(10, 500));
		panelResultado.setMinimumSize(new Dimension(155, 10));
		panelResultado.setMaximumSize(new Dimension(155, 32767));
		panelResultado.setBackground(Color.BLACK);
		panelResultado.setAutoscrolls(true);
		panel.add(panelResultado, BorderLayout.CENTER);
		panelResultado.setLayout(new BoxLayout(panelResultado, BoxLayout.Y_AXIS));
		
		panelImagen = new JPanel();
		panelImagen.setBounds(201, 33, 499, 445);
		panelImagen.setMaximumSize(new Dimension(999, 32767));
		panelImagen.setMinimumSize(new Dimension(480, 400));
		panelImagen.setBackground(Color.BLACK);
		this.add(panelImagen);
		ImageIcon imagen = new ImageIcon("img/fondo.jpg");
		panelImagen.setLayout(new BoxLayout(panelImagen, BoxLayout.X_AXIS));
		JLabel labelImagen = new JLabel(imagen);
		labelImagen.setHorizontalTextPosition(SwingConstants.LEADING);
		labelImagen.setHorizontalAlignment(SwingConstants.LEADING);
		labelImagen.setSize(new Dimension(480, 400));
		labelImagen.setPreferredSize(new Dimension(480, 400));
		labelImagen.setBackground(Color.BLACK);
		labelImagen.setMinimumSize(new Dimension(480, 400));
		labelImagen.setMaximumSize(new Dimension(980, 400));
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
