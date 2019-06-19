package gestorAplicacion.Centro;
import gestorAplicacion.usuarios.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

import gestorAplicacion.usuarios.Estudiante;

public class Solicitud {

    Scanner entry = new Scanner(System.in);
    static private HashMap<String, ArrayList<Estudiante>> solicitudes = new HashMap();
    private String tipoCurso;
    public Solicitud(String tipo) {
    	tipoCurso=tipo;
    }

    static private Curso disponibilidad(String tip) {
        ArrayList<Curso> lista = Departamento.getCursos();
        Iterator<Curso> I = lista.iterator();

        while (I.hasNext()) {
            Curso x = I.next();
            if (x.getTipo().equals(tip) && x.getCupos() < 50) {
                return x;
            }
        }
        return null;
    }
    
    public void aceptarSolicitud(String tipo) {
        Curso x = Solicitud.disponibilidad(tipo);
        ArrayList<Estudiante> e = solicitudes.get(tipo);
        if (x == null) {
            // solucitudes tiene estudiantes
            while (e.size() != 0) {
            	System.out.println("Ingrese el nombre del nuevo curso: ");
                String nombre = entry.next();
                System.out.print("Ingrese el horario del nuevo curso: ");
                String horario = entry.next();
                ArrayList<Docente> doc = Departamento.getDocentes();
                Curso course = new Curso(nombre, horario, doc.get(0), tipo);
                Departamento.addCurso(course);
                (doc.get(0)).addCurso(course);
                System.out.println("El nuevo curso ha sido creado.");
                int cup= 0;
                // aceptar solicitudes una a una, hasta completar el cupo maximo de 10
                while(cup<=10) {
                	if (e.size() != 0) {
                		Estudiante acep= e.get(0);
                		System.out.println("Si desea aceptar la solucitud de "+ acep.toString()+ " marque 1 de lo contrario marque 0");
                		int op= entry.nextInt();
                		if(op==1) {
                			course.matricular(acep);
                			acep.removeSolicitud(this);
                			e.remove(acep);
                			cup++;
                        }else {
                        	acep.removeSolicitud(this);
                        	e.remove(acep);
                        }
                    } else {
                    	System.out.println("No hay mas solicitudes");
                        break;
                    }
                }   
            }
        }else {
        	while(x.getCuposDisponibles()!=0) {
            	if (e.size() != 0) {
            		Estudiante acep= e.get(0);
            		System.out.println("Si desea aceptar la solucitud de "+ acep.toString()+ " marque 1. Para rechazar marque 0. \nPara ");
            		int op= entry.nextInt();
            		if(op==1) {
            			x.matricular(acep);
            			acep.removeSolicitud(this);
            			e.remove(acep);
                    }else {
                    	acep.removeSolicitud(this);
                    	e.remove(acep);
                    }
                } else {
                	System.out.println("No hay mas solicitudes");
                    break;
                }
            }
        }
    }
    public void solicitar(String tipo, Estudiante e) {
    	if(solicitudes.containsKey(tipo)) {
    		(solicitudes.get(tipo)).add(e);
    		e.adSolicitud(new Solicitud(tipo));
    	}else {
    		solicitudes.put(tipo, null);
    		(solicitudes.get(tipo)).add(e);
    	}
    }

}