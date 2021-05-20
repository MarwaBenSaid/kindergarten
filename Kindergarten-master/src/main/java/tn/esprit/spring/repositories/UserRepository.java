package tn.esprit.spring.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer>  {
	
	@Query("SELECT u FROM User u WHERE u.username= :username")
	public User Auth(@Param("username") String username);
	
	@Query("select case when count(u) > 0 then true else false end from User u WHERE u.username= :username AND u.password = :password")
	public boolean existence(@Param("username") String username,@Param("password") String password);
	User findByIdu(int idu);
	@Query("select case when count(u) > 0 then true else false end from User u WHERE u.email= :email OR u.username = :username")
	public boolean Existmail(@Param("email") String email,@Param("username") String username);
	
	@Query("select u from User u join Verification_Code v on u.idu=v.user_idu WHERE u.username= :username")
	User isverified(String username ); 
	
	@Query("SELECT u FROM User u WHERE u.username= :username AND u.idu = :idu")
	User findByLogin(@Param("username") String username,@Param("idu") int idu);
	
	@Query("SELECT u FROM User u WHERE u.email= :email AND u.idu = :idu")
	User findByEmail(@Param("email") String username,@Param("idu") int idu);
	
	@Query("SELECT u FROM User u WHERE u.email= :email")
	User sms(@Param("email") String email);
	


}
