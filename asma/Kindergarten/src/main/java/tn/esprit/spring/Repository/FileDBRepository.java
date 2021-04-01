package tn.esprit.spring.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.FileDB;

@Repository
public interface FileDBRepository extends JpaRepository<FileDB, String> {

}