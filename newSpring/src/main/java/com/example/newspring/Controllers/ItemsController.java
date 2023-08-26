package com.example.newspring.Controllers;

import com.example.newspring.Exceptions.ResponseNotFoundException;
import com.example.newspring.Models.Items;
import com.example.newspring.Repositories.ItemsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@CrossOrigin("*")
@RestController

@RequestMapping("/api/items")
public class ItemsController {

    @Autowired
    public ItemsRepository itemsRepository;

    //Get all the items
    @GetMapping
    public List<Items> getAllItems() {
        return itemsRepository.findAll();
    }

    //Post new item in DB
    @PostMapping
    public Items saveNewITem(@RequestBody Items item) {
        return itemsRepository.save(item);
    }

    //Update existing item in DB
    @PutMapping("{id}")
    public ResponseEntity<Items> updateItem(@PathVariable Long id, @RequestBody Items itemDetails){
        Items updatedItem = itemsRepository.findById(id).orElseThrow(()-> new ResponseNotFoundException("Item with such 'id' can not be found : " + id));

        updatedItem.setPlant(itemDetails.getPlant());
        updatedItem.setInvNumber(itemDetails.getInvNumber());
        updatedItem.setAccNumber(itemDetails.getAccNumber());
        updatedItem.setSerialnumber(itemDetails.getSerialnumber());
        updatedItem.setItem_name(itemDetails.getItem_name());
        updatedItem.setItem_brand(itemDetails.getItem_brand());
        updatedItem.setItem_model(itemDetails.getItem_model());
        updatedItem.setLocation(itemDetails.getLocation());
        updatedItem.setIp_address(itemDetails.getIp_address());
        updatedItem.setHostname(itemDetails.getHostname());
        updatedItem.setIsDamaged(itemDetails.getIsDamaged());
        updatedItem.setUser_name(itemDetails.getUser_name());
        updatedItem.setDepartment(itemDetails.getDepartment());
        updatedItem.setOperator_number(itemDetails.getOperator_number());
        updatedItem.setUser_added_item("default User");

        itemsRepository.save(updatedItem);
        return ResponseEntity.ok(updatedItem);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Items> deleteItem(@PathVariable Long id){
        itemsRepository.deleteById(id);
        return new ResponseEntity<Items>(HttpStatus.OK);
    }

//    @DeleteMapping
//    public void deleteAllPassingEntities(List<Items> items){
//        itemsRepository.deleteAll(items);
//    }

    @DeleteMapping
    public void deleteAll(){
        itemsRepository.deleteAll();
    }


}
