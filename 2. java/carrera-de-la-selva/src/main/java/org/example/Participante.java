package org.example;

public class Participante {
	int id;
	int dni;
	String nombre;
	String apellido;
	int edad;
	String celular;
	String nEmergencia;
	String grupoSanguineo;

	public Participante(int id, int dni, String nombre, String apellido, int edad, String celular, String nEmergencia, String grupoSanguineo) {
		this.id = id;
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.celular = celular;
		this.nEmergencia = nEmergencia;
		this.grupoSanguineo = grupoSanguineo;
	}

	public boolean esMenor() {
		return this.edad < 18;
	}

	public boolean esMayor() {
		return !this.esMenor();
	}

	public String getNombre() {
		return this.nombre;
	}
	public String getApellido() {
		return this.apellido;
	}

	public int getId() {
		return this.id;
	}
	public String getGrupoSanguineo() {
		return this.grupoSanguineo;
	}
}
