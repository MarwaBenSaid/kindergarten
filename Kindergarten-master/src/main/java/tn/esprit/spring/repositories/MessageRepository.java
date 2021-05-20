package tn.esprit.spring.repositories;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Message;
@Repository
public interface MessageRepository extends CrudRepository<Message, Integer> {

	@Query("Select m.Description from Message m " + "where (m.Sender.id=:senderId and m.Reciever.id=:recieverId) "
			+ "OR (m.Sender.id=:recieverId and m.Reciever.id=:senderId) " + "ORDER BY creationDate ")
	public List<String> getDiscussion(@Param("senderId") int senderId, @Param("recieverId") int recieverId);

	@Query("SELECT m.Description FROM Message m "
			+ "where (m.Sender.id=:senderId and m.Reciever.id=:recieverId and m.Description LIKE %:string%) "
			+ "OR (m.Sender.id=:recieverId and m.Reciever.id=:senderId and m.Description LIKE %:string%)")
	public Set<String> searchStringInDiscussion(@Param("string") String string, @Param("senderId") int senderId,
			@Param("recieverId") int recieverId);
	
}