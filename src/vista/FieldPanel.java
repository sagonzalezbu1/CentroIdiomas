package vista;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FieldPanel extends JPanel {

	private String tituloCriterios;
	private String[] criteriosArray;
	private String tituloValores;
	private String[] valoresArray;
	private boolean[] habilitado;
	private JTextField[] textos;
	private JButton aceptar;
	private JButton borrar;
	private JPanel nombreProceso = new JPanel();
	private JPanel detalleProceso = new JPanel();
	private JPanel detalle = new JPanel();
	
	private JPanel formulario = new JPanel();
	

	public FieldPanel() {
		
	}
	
	public FieldPanel(String tituloCriterios, String[] criterios, String tituloValores, String[] valores,
			boolean[] habilitado) {
		this.setLayout(new BorderLayout());
		detalle.setLayout(new BorderLayout());
		this.tituloCriterios = tituloCriterios;
		this.criteriosArray = criterios;
		this.tituloValores = tituloValores;
		this.valoresArray = valores;
		this.habilitado = habilitado;
		formulario.setLayout(new GridBagLayout());
		textos = new JTextField[criterios.length];
		GridBagConstraints constraints = new GridBagConstraints();
		;

		JLabel jlabel = new JLabel(tituloCriterios);
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		formulario.add(jlabel, constraints);
		
		jlabel = new JLabel(tituloValores);
		constraints.gridx = 1;
		constraints.gridy = 0;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		formulario.add(jlabel, constraints);
		
		for (int i = 0; i < criterios.length; i++) {

			jlabel = new JLabel(criteriosArray[i]);
			constraints.gridx = 0;
			constraints.gridy = i + 1;
			constraints.gridwidth = 1;
			constraints.gridheight = 1;
			formulario.add(jlabel, constraints);

			textos[i] = new JTextField(valoresArray[i],10);
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
		formulario.add(aceptar,constraints);

		borrar = new JButton("Borrar");
		constraints.gridx = 1;
		constraints.gridy = criterios.length + 1;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		formulario.add(borrar,constraints);
		
		this.add(detalle,BorderLayout.NORTH);
		this.add(formulario,BorderLayout.CENTER);
		this.setSize(500, 500);
	}

	public void setControlador(ActionListener control) {
		aceptar.addActionListener(control);
		borrar.addActionListener(control);
	}

	public String getValue(String criterio) {
		for (int i = 0; i < criteriosArray.length; i++) {
			if (criteriosArray[i].equals(criterio)) {
				return textos[i].getText();
			}
		}
		return "No se encontró criterio";
		
	}
	
	public void nombre(String nombre) {
		detalle.add(new JLabel(nombre),BorderLayout.NORTH);
	}
	
	public void descripcion(String descripcion) {
		detalle.add(new JLabel(descripcion),BorderLayout.SOUTH);
	}

}
