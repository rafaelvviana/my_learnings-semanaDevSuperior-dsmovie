package br.com.rvv.dsmovie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.rvv.dsmovie.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmail(String email);
	
}
