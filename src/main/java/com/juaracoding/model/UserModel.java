package com.juaracoding.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserModel {
	String nama;
	String gambar;
	String judul;
	String deskripsi;
	String tanggal;
}
