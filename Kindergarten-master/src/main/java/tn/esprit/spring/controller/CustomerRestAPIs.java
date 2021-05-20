package tn.esprit.spring.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.Driver;
import tn.esprit.spring.repositories.DriverRepository;
import tn.esprit.spring.PDFGenerator.PDFGenerator;



@RestController
@RequestMapping("/api/pdf")
public class CustomerRestAPIs {
	
    @Autowired
    DriverRepository driverRepository;

    @GetMapping(value = "/drivers",
            produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> DriverReport() throws IOException {
        List<Driver>drivers = (List<Driver>) driverRepository.findAll();

        ByteArrayInputStream bis = PDFGenerator.customerPDFReport(drivers);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=customers.pdf");

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));
    }
}