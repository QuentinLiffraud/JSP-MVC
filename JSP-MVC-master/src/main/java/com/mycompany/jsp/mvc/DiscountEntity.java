/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jsp.mvc;

/**
 *
 * @author Matthias
 */
public class DiscountEntity {
	// TODO : ajouter les autres propriétés
	private String Code;
	private float Taux;

	public DiscountEntity(String Code,float Taux) {
		this.Code = Code;
		this.Taux = Taux;
	}

	/**
	 * Get the value of customerId
	 *
	 * @return the value of customerId
	 */
	public String getCode() {
		return Code;
	}

	/**
	 * Get the value of name
	 *
	 * @return the value of name
	 */
	public Float getTaux() {
		return Taux;
	}
}
