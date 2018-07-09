package tn.enig.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.enig.model.User;

public interface IGstionUser extends JpaRepository<User, Integer>{

}
