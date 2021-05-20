package tn.esprit.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.User;
import tn.esprit.spring.services.IUserService;
import tn.esprit.spring.services.UserServiceImpl;





@RestController
@RequestMapping({ "/Users" })
public class RestControllerUser  {
	
	@Autowired
	IUserService iuserservice;
	
	
	@PostMapping("/addUser")
	@ResponseBody
	public User addUser(@RequestBody User user)
	{
		iuserservice.addUser(user);
		return user;
	}

	@PutMapping("/modify-user")
	@ResponseBody
	public User updateUser(@RequestBody User user) {
		iuserservice.updateUser(user);
	return user ;
	}
	
	
	@GetMapping("/VerifyAccount")
    @ResponseBody
	public String verify( @RequestBody User s,@RequestParam String Code )
	{
		return iuserservice.VerifyMyaccount(s, Code);
	} 
	
	
    @GetMapping("/isVerified")
    @ResponseBody
	public boolean isverify( @RequestBody User s) {
		return iuserservice.isVerified(s.getUsername(),s.getPassword());
	} 
    

    @PostMapping("/login")
    @ResponseBody
	  public User Login( @RequestBody User s) {
   
	  return iuserservice.Authority(s.getUsername(), s.getPassword());
	  }
	
    @GetMapping("/resetPassword")
    @ResponseBody
	public int Reset(@RequestParam String email) {
		int x=iuserservice.ResetPassword(email);
		return UserServiceImpl.coderest;
	}
    @GetMapping("/ChangePassword")
    @ResponseBody
	public String Change(@RequestParam int code,@RequestParam String password,@RequestParam int idu)
    {
		String x=iuserservice.UpdateRestPassword(code,password,idu);
		return x;
	}
    
    @DeleteMapping("/suppression/{idu}")
    @ResponseBody   
    public String SupprimerUser( @PathVariable("idu") int idu) {
    	iuserservice.Delete(idu);
	return "User Deleted successfully !";  
    }
    

    @GetMapping("/informationUser/{idu}")
    @ResponseBody   
    public User userInfo( @PathVariable("idu") int idu) {
    	return iuserservice.GetUser(idu);
	  
 }
   
    @RequestMapping("/hello")
    public String hello() {
    	return "helloworld";
    	 
    }
}
