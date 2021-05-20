package tn.esprit.spring.services;



import tn.esprit.spring.entities.User;

public interface IUserService {

    public User Authority(String username, String password);

	public User updateUser(User s) ;
	
	public void addUser(User s);
	
    public void mailling(String mail,String message);
    
    public boolean exist(String username,String password);
    
    public void AddCode(String code,User user_idu) ;
    
    public boolean isVerified(String username,String password);
    
    public String VerifyMyaccount(User s,String verifcode);
    
    public void ifNotverifiedVerif(int idu,String verification_code);
    
    public boolean VerifLogin (String username,int idu);
    
    public boolean VerifEmail (String Email,int idu);
    
    public int ResetPassword(String mail);
    
    public void sendsms(String str,int body);
    
    public String UpdateRestPassword(int code,String password,int idu);
    
    public void Delete(int idu);
    
    public User GetUser(int idu);


	
	


}
