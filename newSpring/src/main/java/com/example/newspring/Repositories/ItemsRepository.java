package com.example.newspring.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.newspring.Models.Items;
public interface ItemsRepository extends JpaRepository<Items, Long> {

}
