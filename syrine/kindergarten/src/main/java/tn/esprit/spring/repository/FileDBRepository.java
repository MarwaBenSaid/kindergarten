package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.esprit.spring.entity.FileDB;


public interface FileDBRepository extends JpaRepository<FileDB, String> {

}
