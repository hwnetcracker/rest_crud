package com.netcracker.crud.controller;


import com.netcracker.crud.exception.ResourceNotFoundException;
import com.netcracker.crud.model.Buyer;
import com.netcracker.crud.service.BuyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest")
public class BuyerController {
    @Autowired
    BuyerService buyerService;

    @GetMapping("/buyer")
    public List<Buyer> getAllBuyers() {
        return  buyerService.getBuyers();
    }

    @GetMapping("/buyer/{id}")
    public ResponseEntity<Buyer> getBuyerById(@PathVariable(value="id") Integer id) throws ResourceNotFoundException {
        return buyerService.getBuyerById(id);
    }

    @PostMapping("/buyer")
    public ResponseEntity<Buyer> addBuyer(@RequestBody Buyer Buyer) {
        return buyerService.addBuyer(Buyer);
    }

    @DeleteMapping("/buyer/{id}")
    public ResponseEntity<String> deleteBuyerById(@PathVariable(value = "id") Integer id) throws ResourceNotFoundException {
        return buyerService.deleteBuyerById(id);
    }

    @DeleteMapping("/buyer")
    public ResponseEntity<String> deleteAllBuyers() {
        return buyerService.deleteAllBuyers();
    }


}
