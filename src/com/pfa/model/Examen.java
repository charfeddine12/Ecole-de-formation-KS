package com.pfa.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="examen")
public class Examen implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idExam")
	private int idExam;
	
	@Column(name="note")
	private float note;
	
	public Examen(){
		
	}

	public float getNote() {
		return note;
	}

	public void setNote(float note) {
		this.note = note;
	}

	public int getIdExam() {
		return idExam;
	}

	public void setIdExam(int idExam) {
		this.idExam = idExam;
	}

	
}
