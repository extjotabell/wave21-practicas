package org.example;

import org.circuitos.Circuito;

public class Inscripcion {
	int id;
	Circuito categoria;
	Participante participante;
	float monto;
	boolean validez;

	public Inscripcion(int id, Circuito categoria, Participante participante) {

		this.monto = categoria.habilita(participante);
		this.validez = this.monto != 0;

		this.id = id;
		this.categoria = categoria;
		this.participante = participante;
	}

	public void invalidarInscripcion() {
		this.validez = false;
	}

	public int getId() {
		return this.id;
	}

	public Participante getParticipante() {
		if(this.esValido())
			return this.participante;
		return null;
	}

	public String getParticipanteInfo() {
		if(this.esValido())
			return this.participante.getApellido()+", "+this.participante.getNombre();
		return "";
	}

	public float getMonto() {
		if(this.esValido())
			return this.monto;
		return 0;
	}

	public Circuito getCategoria() {
		if(this.esValido())
			return this.categoria;
		return null;
	}

	public boolean esValido() {
		return this.validez;
	}
}
