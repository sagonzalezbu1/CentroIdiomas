package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

import modelo.excepciones.control.CampoVacio;

public class FieldPanel extends JPanel {

	private String tituloCriterios;
	private String[] criteriosArray;
	private String tituloValores;
	private String[] valoresArray;
	private boolean[] habilitado;
	private JTextField[] textos;
	private JButton aceptar;
	private JButton borrar;
	private JPanel detalle = new JPanel();
	private JPanel formulario = new JPanel();

	public FieldPanel() {

		detalle.setLayout(new BorderLayout(6, 6));
		detalle.setBackground(Color.white);

		formulario.setBackground(Color.white);
		this.formulario("Hola, Bienvenido.");
		Border padding = BorderFactory.createEmptyBorder(10, 10, 10, 10);
		this.setLayout(new BorderLayout(4, 4));
		this.setBackground(Color.white);
		this.setBorder(padding);
		this.add(detalle, BorderLayout.NORTH);
		this.add(formulario, BorderLayout.CENTER);
	}

	public FieldPanel(String tituloCriterios, String[] criterios, String tituloValores, String[] valores,
			boolean[] habilitado) {

		detalle.setLayout(new BorderLayout(6, 6));
		detalle.setBackground(Color.white);

		formulario.setLayout(new GridBagLayout());
		formulario.setBackground(Color.white);

		this.setLayout(new BorderLayout(4, 4));
		this.setBackground(Color.white);
		Border padding = BorderFactory.createEmptyBorder(10, 10, 10, 10);
		this.setBorder(padding);
		this.tituloCriterios = tituloCriterios;
		this.criteriosArray = criterios;
		this.tituloValores = tituloValores;
		this.valoresArray = valores;
		this.habilitado = habilitado;
		textos = new JTextField[criterios.length];

		GridBagConstraints constraints = new GridBagConstraints();

		JLabel jlabel = new JLabel(tituloCriterios);
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		Border borde = BorderFactory.createLineBorder(Color.blue, 1);
		jlabel.setBorder(borde);
		formulario.add(jlabel, constraints);

		jlabel = new JLabel(tituloValores);
		constraints.gridx = 1;
		constraints.gridy = 0;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		borde = BorderFactory.createLineBorder(Color.blue, 1);
		jlabel.setBorder(borde);
		formulario.add(jlabel, constraints);

		for (int i = 0; i < criterios.length; i++) {

			jlabel = new JLabel(criteriosArray[i]);
			jlabel.setHorizontalAlignment(JLabel.CENTER);
			constraints.gridx = 0;
			constraints.gridy = i + 1;
			constraints.gridwidth = 1;
			constraints.gridheight = 1;
			formulario.add(jlabel, constraints);

			textos[i] = new JTextField(valoresArray[i], 20);
			if (!habilitado[i]) {
				textos[i].setEditable(false);
			}
			constraints.gridx = 1;
			constraints.gridy = i + 1;
			constraints.gridwidth = 1;
			constraints.gridheight = 1;
			formulario.add(textos[i], constraints);

		}

		aceptar = new JButton("Aceptar");
		constraints.gridx = 0;
		constraints.gridy = criterios.length + 1;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		formulario.add(aceptar, constraints);

		borrar = new JButton("Borrar");
		constraints.gridx = 1;
		constraints.gridy = criterios.length + 1;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		formulario.add(borrar, constraints);

		this.add(detalle, BorderLayout.NORTH);
		this.add(formulario, BorderLayout.CENTER);
	}

	public void setControlador(ActionListener control) {
		aceptar.addActionListener(control);
		borrar.addActionListener(control);
	}

	public String getValue(String criterio) throws CampoVacio {
		String CamposVacios = "CamposVacios";
		for (int i = 0; i < criteriosArray.length; i++) {
			if (textos[i].getText().equals("")) {
				CamposVacios += "\n" + criteriosArray[i];
			}
		}
		if (!CamposVacios.equals("CamposVacios")) {
			throw new CampoVacio(CamposVacios);
		} else {
			for (int i = 0; i < criteriosArray.length; i++) {

				if (criteriosArray[i].equals(criterio)) {
					if (!textos[i].getText().equals("")) {
						return textos[i].getText();
					}
				}
			}
		}

		return "No se encontr� criterio";

	}

	public void borrar() {
		for (JTextField text : textos) {
			text.setText(null);
		}
	}

	public void nombre(String nombre) {
		JLabel text = new JLabel(nombre);
		text.setHorizontalAlignment(JLabel.CENTER);
		Border borde = BorderFactory.createLineBorder(Color.blue, 1);
		text.setBorder(borde);
		detalle.add(text, BorderLayout.NORTH);
	}

	public void descripcion(String descripcion) {
		JTextArea text = new JTextArea(descripcion, 10, 40);
		text.setEditable(false);
		text.setLineWrap(true);
		JScrollPane scroll = new JScrollPane(text);
		Border borde = BorderFactory.createLineBorder(Color.blue, 1);
		text.setBorder(borde);
		detalle.add(scroll, BorderLayout.SOUTH);
	}

	public void formulario(String text) {
		JTextArea texto = new JTextArea(text, 15, 60);
		texto.setEditable(false);
		texto.setLineWrap(true);
		JScrollPane scroll = new JScrollPane(texto);
		Border borde = BorderFactory.createLineBorder(Color.GRAY, 1);
		texto.setBorder(borde);
		formulario.removeAll();
		formulario.setLayout(new BorderLayout());
		GridBagConstraints cons = new GridBagConstraints();
		cons.weightx = 1.0;
		cons.weighty = 1.0;
		formulario.add(scroll, BorderLayout.CENTER);
	}

	public void borrar2(String noBorrar, int posicion) {
		int cedula = Integer.parseInt(noBorrar);
		for (JTextField text : textos) {
			text.setText(null);
		}
		textos[posicion].setText("" + cedula);
	}
}
