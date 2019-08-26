package vista;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Formulario extends JPanel {

	String tituloCriterios;
	String[] criteriosArray;
	String tituloValores;
	String[] valoresArray;
	boolean[] habilitado;
	JTextField[] textos;
	JButton aceptar;
	JButton borrar;

	public Formulario(String tituloCriterios, String[] criterios, String tituloValores, String[] valores,
			boolean[] habilitado) {

		this.tituloCriterios = tituloCriterios;
		this.criteriosArray = criterios;
		this.tituloValores = tituloValores;
		this.valoresArray = valores;
		this.habilitado = habilitado;
		this.setLayout(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();;
		for (int i = 0; i < criterios.length; i++) {
			
			JLabel jlabel = new JLabel(criteriosArray[i]);
			constraints.gridx = 1; 
			constraints.gridy = i; 
			constraints.gridwidth = 1; 
			constraints.gridheight = 1;
			this.add(jlabel,constraints);
			
			textos = new JTextField[criterios.length];
			textos[i] = new JTextField(valoresArray[i]);
			if (!habilitado[i]) {
				textos[i].setEditable(false);
			}
			constraints.gridx = 0; 
			constraints.gridy = i; 
			constraints.gridwidth = 1; 
			constraints.gridheight = 1;
			this.add(textos[i],constraints);
			
		}
		
		aceptar = new JButton("Aceptar");
		constraints.gridx = 0; 
		constraints.gridy = criterios.length; 
		constraints.gridwidth = 1; 
		constraints.gridheight = 1;
		
		borrar = new JButton("Borrar");
		constraints.gridx = 1; 
		constraints.gridy = criterios.length; 
		constraints.gridwidth = 1; 
		constraints.gridheight = 1;
	}
	
	public void setControlador(ActionListener control) {
		aceptar.addActionListener(control);
		borrar.addActionListener(control);
	}
	
}
