package com.example.mypackage.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;


import com.example.mypackage.entity.Item;
import com.example.mypackage.repository.InventoryRepository;
import com.example.mypackage.services.ItemService;

@Service
public class ItemServiceImpl implements ItemService{
	private InventoryRepository itemRepository;
	
	
	public ItemServiceImpl(InventoryRepository itemRepository) {
		super();
		this.itemRepository = itemRepository;
	}


	@Override
	public List<Item> getAllItems(){
		
		return itemRepository.findAll();
		
	}


	@Override
	public Item saveItem(Item item) {
		
		return itemRepository.save(item);
	}


	@Override
	public Item getItemById(Long id) {
		return itemRepository.findById(id).get();
	}


	@Override
	public Item updateItem(Item item) {
		return itemRepository.save(item);
	}
	
	@Override
	public Item upItem(Item item) {
		return itemRepository.save(item);
	}
	


	@Override
	public void deleteItemById(Long id) {
		itemRepository.deleteById(id);
		
	}

}
