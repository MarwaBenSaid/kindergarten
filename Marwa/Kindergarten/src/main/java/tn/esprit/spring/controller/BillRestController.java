package tn.esprit.spring.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sun.el.parser.ParseException;

import tn.esprit.spring.entities.Bill;
import tn.esprit.spring.repositories.BillRepository;
import tn.esprit.spring.services.IBillService;



@RestController
public class BillRestController {
	@Autowired 
	IBillService bills ;
	@Autowired
	BillRepository repository ;
	
	
//<--------------------------------------------------------------------------------------------------->
	
	@PostMapping("/ajout_Bill_To_Parent/{idparent}/{idkindergarten}")
	public String ajout_Bill_To_Parent(@PathVariable("idparent") int idparent,@PathVariable("idkindergarten") int idkindergarten,@RequestBody Bill bill) throws ParseException {
		
		return bills.ajout_Bill_To_Parent(idparent,idkindergarten,bill);
	}
	
//<--------------------------------------------------------------------------------------------------->
	
	@DeleteMapping("/delete_Bill/{id_kinder}/{id_bill}")
	public String delete_Bill(@PathVariable("id_kinder") int id_kinder,@PathVariable("id_bill") int id_bill)  {
		
		return bills.delete_Bill(id_kinder,id_bill);
	
	}
	//<--------------------------------------------------------------------------------------------------->

	@GetMapping(value="/listofbill")
	@ResponseBody
	public List<Bill> getAllBill() {
		return bills.getAllBill();
	}
	//<--------------------------------------------------------------------------------------------------->
	@PutMapping("/update_Bill/{kinder_id}/{bill_id}")
	public String update_Bill(@PathVariable("kinder_id") int kinder_id, @PathVariable ("bill_id") int bill_id,@RequestBody Bill  bill) {

		
		return bills.update_Bill( kinder_id  ,bill_id, bill);
	}

	//<--------------------------------------------------------------------------------------------------->
	@PutMapping("/calculp/{idBill}")
  	@ResponseBody
  	public ResponseEntity<String> calculPrice(
	  		@RequestBody Bill bill,@PathVariable("idBill")int idBill) {
		bills.calculPrice(bill,idBill );
		
	  	    return new ResponseEntity<String>("Bill is calculated",HttpStatus.OK);
	  		
	}
	  //<--------------------------------------------------------------------------------------------------->

    @GetMapping("/NbreChild/{idparent}/{idkindergarten}")
	 @ResponseBody
	public int getNumberOfChildForParentInKinderJPQL(@PathVariable("idparent")int idparent, @PathVariable("idkindergarten")int  idkindergarten) {
		
		return bills.getNumberOfChildForParentInKinderJPQL(idparent , idkindergarten);
	}
	
	//<--------------------------------------------------------------------------------------------------->
	    @GetMapping("/getAllBillByParent/{idparent}")
	    @ResponseBody
		public List<Bill> getAllBillByParent(@PathVariable("idparent") int idparent) {

			return bills.getAllBillByParent(idparent);
		}
	  //<--------------------------------------------------------------------------------------------------->
	    @GetMapping("/getAllBillBykinder/{idkindergarten}")
	    @ResponseBody
		public List<Bill> getAllBillBykinder(@PathVariable("idkindergarten") int idkindergarten) {

			return bills.getAllBillBykinder(idkindergarten);
		}
	  //<--------------------------------------------------------------------------------------------------->
	    @GetMapping("/getAllBillForParentInKinder/{idkindergarten}/{idparent}")
	    @ResponseBody
		public List<Bill> getAllBillForParentInKinder(@PathVariable("idkindergarten") int idkindergarten ,@PathVariable("idparent") int idparent) {

			return bills.getAllBillForParentInKinder(idkindergarten,idparent );
		}
	
	    
	 
}