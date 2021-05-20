package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Bill;

public interface IBillService {

public String ajout_Bill_To_Parent(int idparent , int idkindergarten ,Bill bill);
public String delete_Bill(int idkinderdergarten,int idBill);
public List<Bill> getAllBill();
public String update_Bill(int idkindergarten , int idBill,Bill bill);
public int getNumberOfChildForParentInKinderJPQL(int idparent , int idkindergarten);
public void calculPrice(Bill b ,int  idBill );
public List<Bill> getAllBillByParent(int idparent);
public List<Bill> getAllBillBykinder(int idkindergarten);
public List<Bill> getAllBillForParentInKinder(int idkindergarten ,int idparent);

}
