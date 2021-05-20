package tn.esprit.spring.services;



import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Bill;
import tn.esprit.spring.entities.kindergarten;
import tn.esprit.spring.entities.Parent;
import tn.esprit.spring.repositories.BillRepository;
import tn.esprit.spring.repositories.KindergartenRepository;
import tn.esprit.spring.repositories.ParentRepository;



@Service
public class BillServiceImpl implements IBillService {
	@Autowired
	BillRepository bills ;
	@Autowired
	ParentRepository users ;
	@Autowired
	KindergartenRepository kinders ;
	
	//////////////////////////////////////////////////////////////////////////////////////
	
	public String ajout_Bill_To_Parent(int idparent , int idkindergarten ,Bill bill) {
		kindergarten kinder = kinders.findById(idkindergarten).orElse(null);
		Parent p = users.findById(idparent).orElse(null);
		
	        	bill.setKindergarten(kinder);
				bill.setParent(p);
			    bill.setTotalPrice(0);
	           
					 bills.save(bill);
			      return ("   " +bill);
				
		}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public String delete_Bill(int idkindergarten,int idBill) {
	//	Kindergarten kinder = kinders.findById(idkindergarten).orElse(null);
	Bill bill = bills.findById(idBill).orElse(null);
	if(bill == null) {return ("bill n'existe pas");}
		
	else {
		
			bills.deleteById(bill.getIdBill());
			return ("bill est supprimé");	
		}
	}
	//////////////////////////////////////////////////////////////////////////////////////

	public List<Bill> getAllBill() {
	return (List<Bill>) bills.findAll();
	}
	//////////////////////////////////////////////////////////////////////////////////////

	@SuppressWarnings("unused")
	public String update_Bill(int idkindergarten , int idBill,Bill bill) {
		kindergarten kinder = kinders.findById(idkindergarten).orElse(null);
		
			 Bill bill_To_Update =bills.findById(idBill).orElse(null);
			if  ( bill_To_Update == null) {
					return ("bill n'existe pas");}
			else {
				 bill_To_Update.setDateOfBill(bill.getDateOfBill());
				 bill_To_Update.setDescription(bill.getDescription());
	             bills.save(bill_To_Update);
				return ("bill est bien modifiée ");
			 }
}
	
////////////////////////////////////////////////////////////////////////////////////////////
	public List<Bill> getAllBillByParent(int idparent) {
		return bills.getAllBillByParent(idparent);
	}
//////////////////////////////////////////////////////////////////////////////////////////////
	public List<Bill> getAllBillBykinder(int idkindergarten) {
		return bills.getAllBillBykinder(idkindergarten)	;
	}
//////////////////////////////////////////////////////////////////////////////
	public List<Bill> getAllBillForParentInKinder(int idkindergarten, int idparent) {
		return bills.getAllBillForParentInKinder(idkindergarten, idparent);
	}

////////////////////////////////////////////////////////////////////////////////////////
	public void calculPrice(Bill b ,int idBill  ) {
		Bill bill = bills.findById(idBill).get();
		
		int k = bills.findById(idBill).get().getKindergarten().getIdkindergarten();
		int u = bills.findById(idBill).get().getParent().getIdparent();
		int  a = bills.getNumberOfChildForParentInKinderJPQL(u, k);
		float t=bills.findById(idBill).get().getKindergarten().getCost();
		bill.setTotalPrice(a * t);
		bills.save(bill);	
			}
/////////////////////////////////////////////////////////////////////////////////
	
public int getNumberOfChildForParentInKinderJPQL(int idparent , int idkindergarten) {
	return (int) bills.getNumberOfChildForParentInKinderJPQL( idparent , idkindergarten);
}

	
}