package com.juaracoding.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.juaracoding.model.UserModel;

public interface UserRepository extends JpaRepository<UserModel, Long>{
	
	@Query(value="SELECT * FROM `user` WHERE nama Like %?1%",nativeQuery = true)
	List<UserModel> getUserByName(String user);
	
	List<UserModel> findByNamaContaining(String nama);
	
	List<UserModel> findByTanggalContainingAndNamaContaining(String tanggal,String nama);
}
