package com.example.mypackage.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.mypackage.entity.Item;


public interface InventoryRepository extends JpaRepository<Item,Long>{

}
