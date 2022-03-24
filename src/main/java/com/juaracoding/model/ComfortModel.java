package com.juaracoding.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="comfort")
public class ComfortModel {
	@Id
	@Column(length = 25)
	private String title;
	private String deskripsi;
}
