package tn.esprit.spring.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.entities.Parent;
@Repository
public interface PagingRepository extends PagingAndSortingRepository <Parent, Integer>{

}
