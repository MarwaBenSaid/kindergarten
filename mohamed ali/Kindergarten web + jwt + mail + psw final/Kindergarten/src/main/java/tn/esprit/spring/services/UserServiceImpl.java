package tn.esprit.spring.services;


import java.util.Properties;
import java.util.Random;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.twilio.Twilio;
import com.twilio.type.PhoneNumber;

import tn.esprit.spring.entities.User;
import tn.esprit.spring.entities.Verification_Code;
import tn.esprit.spring.repositories.UserRepository;
import tn.esprit.spring.repositories.VerificationCodeRepository;






@Service
public class UserServiceImpl implements IUserService {
	
	private static final Logger L=LogManager.getLogger(UserServiceImpl.class);

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	@Autowired
	UserRepository userrepository;
	@Autowired
	VerificationCodeRepository vcRepo;
	public static int  coderest=0;
	public static int  idverif=0;
	
	
	@Override
	public User updateUser(User s) {
		if(userrepository.findById(s.getIdu())!=null) {
			String encodedPassword = bCryptPasswordEncoder.encode(s.getPassword());
		// TODO Auto-generated method stub
			s.setPassword(encodedPassword);
		userrepository.save(s);
		return s;
		}
		return null;
		
	}

	@Override
	public void addUser(User s) {
		L.info(s);
		if(userrepository.Existmail(s.getEmail(),s.getUsername())==false) {
		String encodedPassword = bCryptPasswordEncoder.encode(s.getPassword());
		String verifCode = bCryptPasswordEncoder.encode(s.getUsername());
		s.setPassword(encodedPassword);
		userrepository.save(s);
		mailling(s.getEmail(),"Your verification code is : " +verifCode);
	
		}
	
	}

	@Override
	public User Authority(String username, String password) {
		User logged= userrepository.Auth(username);
		if(bCryptPasswordEncoder.matches(password,logged.getPassword())){
			return logged;
	}
	
	
	return null;
	 	

	}

	@Override
	public void mailling(String mail, String message) {
		 final String username = "kindergarten.societty@gmail.com";
		    final String password = "Kinder123456";
		    String fromEmail = "kindergarten.societty@gmail.com";
		    Properties properties = new Properties();
		    properties.put("mail.smtp.auth", "true");
		    properties.put("mail.smtp.starttls.enable", "true");
		    properties.put("mail.smtp.host", "smtp.gmail.com");
		    properties.put("mail.smtp.port", "587");
		    Session session = Session.getInstance(properties,new Authenticator() {
		        @Override
		        protected PasswordAuthentication getPasswordAuthentication() {
		            return new PasswordAuthentication(username,password);
		        }
		    });
		    MimeMessage msg = new MimeMessage(session);
		    try {
		        msg.setFrom(new InternetAddress(fromEmail));
		        msg.addRecipient(Message.RecipientType.TO, new InternetAddress(mail));
		        msg.setSubject("User Verification");
		        Multipart emailContent = new MimeMultipart();
		        MimeBodyPart textBodyPart = new MimeBodyPart();
		        textBodyPart.setText(message);
		        emailContent.addBodyPart(textBodyPart);
		        msg.setContent(emailContent);
		        Transport.send(msg);
		        System.out.println("Sent message");
		    } catch (MessagingException e) {
		        e.printStackTrace();
		    }
		
	}

	@Override
	public boolean exist(String username, String password) {
		if(userrepository.existence(username, password))
			return true;
		
		return false;  
	}

	@Override
	public void AddCode(String code, User user_idu) {
	
		Verification_Code Vc=new Verification_Code();
		Vc.setCode(code);
		Vc.setUser_id(user_idu);
		
		vcRepo.save(Vc);
		
	}

	@Override
	public boolean isVerified(String username, String password) {
		 if(userrepository.isverified(username)==null)
				{return false;
				
				}
			return true;
	}

	@Override
	public String VerifyMyaccount(User s, String verifcode) {

		if(isVerified(s.getUsername(),s.getPassword()))
			return "you are already verified";

		else if(bCryptPasswordEncoder.matches(userrepository.Auth(s.getUsername()).getUsername(),verifcode) && (userrepository.Auth(s.getUsername())!=null ))
		{
		AddCode(verifcode, userrepository.Auth(s.getUsername()));
		return "you have been verified";

		}
		return "Something went wrong";
	}

	@Override
	public void ifNotverifiedVerif(int idu, String verification_code) {
		if(vcRepo.CheckVerification(verification_code,idu)==null) {
			
			AddCode(verification_code,userrepository.findByIdu(idu) );
		}
		
	}

	@Override
	public boolean VerifLogin(String username, int idu) {

		if(userrepository.findByLogin(username,idu)!=null) 
			return true;
		
		return false;
	}

	@Override
	public boolean VerifEmail(String Email, int idu) {
		if(userrepository.findByEmail(Email,idu)!=null) 
			return true;
		
		return false;
	}

	@Override
	public int ResetPassword(String email) {
		// TODO Auto-generated method stub
		if(userrepository.sms(email)==null) {
			return 0;
		}
		int ran = new Random().nextInt((90000-10000)+1)+10000;
		int tel=userrepository.sms(email).getTelephone();
		UserServiceImpl.coderest=ran;
		sendsms(String.valueOf(tel),ran);
		return ran;
	}

	@Override
	public void sendsms(String str, int body) {
	    Twilio.init("AC6e6974d8f43ba08b9329a8b16a815ec6", "a0ae4fb619049752c52b13a5fbef3353");
	    try {
	     com.twilio.rest.api.v2010.account.Message message = com.twilio.rest.api.v2010.account.Message.creator(
	     		new PhoneNumber("+216"+str), // To number
	             new PhoneNumber("+14076413596"), // From number
	             "Verification code to reset password is :"+body
	     ).create();
	    }catch (Exception e) {
	 	// TODO: handle exception
	 }
		
	}

	@Override
	public String UpdateRestPassword(int code, String password, int idu) {

		User t=userrepository.findByIdu(idu);
		if(t==null) {
			return "User not found";
		}
		if(UserServiceImpl.coderest==code) {
			t.setPassword(bCryptPasswordEncoder.encode(password));
			userrepository.save(t);
			return "Password updated successfully !";
		}
			
		return "wrong code";
	}

	@Override
	public void Delete(int idu) {
		User x=userrepository.findByIdu(idu);
	if(x!=null) {
		vcRepo.DeletedVerific(x);


		
		userrepository.deleteById(idu);
	}
	}

	@Override
	public User GetUser(int idu) {
		
		return  userrepository.findByIdu(idu);
	}
	
	
	
	
	
	
}



