package tn.esprit.spring.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import tn.esprit.spring.entities.User;
import tn.esprit.spring.entities.Verification_Code;


public interface VerificationCodeRepository extends JpaRepository<Verification_Code, Integer>  {
	@Query("SELECT u FROM Verification_Code u WHERE u.code= :code AND u.user_idu= :user_idu")
	Verification_Code CheckVerification(@Param("code") String code,@Param("user_idu") int user_idu);
	@Modifying
	@Transactional
	@Query("DELETE FROM Verification_Code u WHERE u.user_idu= :user_idu")
	public void DeletedVerific(@Param("user_idu") User user_idu);
}
 