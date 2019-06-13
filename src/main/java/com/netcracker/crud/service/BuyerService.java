package com.netcracker.crud.service;

import com.netcracker.crud.exception.ResourceNotFoundException;
import com.netcracker.crud.model.Buyer;
import com.netcracker.crud.repository.BuyerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


@Service()
public class BuyerService {
    
    @Autowired
    BuyerRepository buyerRepository;


    public List<Buyer> getBuyers() {
        return (List<Buyer>) buyerRepository.findAll();
    }


    public ResponseEntity<Buyer> getBuyerById(Integer id) throws ResourceNotFoundException {
        Buyer buyer = buyerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Contact not found! id=" + id));
        return ResponseEntity.status(HttpStatus.OK).body(buyer);
    }


    public ResponseEntity<Buyer> addBuyer(Buyer Buyer) {
        return ResponseEntity.status(HttpStatus.OK).body(buyerRepository.save(Buyer));
    }


    public ResponseEntity<String> deleteBuyerById(Integer id) throws ResourceNotFoundException {
        Buyer buyer = getBuyerById(id).getBody();
        buyerRepository.delete(buyer);
        return ResponseEntity.status(HttpStatus.OK).body("Delete with id: " + id);
    }


    public ResponseEntity<String> deleteAllBuyers() {
        buyerRepository.deleteAll();
        return ResponseEntity.status(HttpStatus.OK).body("Delete all Buyers");
    }

}
