package com.example.mypackage.services;

import java.util.List;

import com.example.mypackage.entity.Item;


public interface ItemService {
	List<Item> getAllItems();
	Item saveItem(Item item);
	Item getItemById(Long id);
	Item updateItem(Item item);
	Item upItem(Item item);
	void deleteItemById(Long id);
	
	
}
