package com.example.mypackage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.mypackage.entity.Item;
import com.example.mypackage.services.ItemService;



@Controller
public class InventoryController {
    @Autowired
	private ItemService itemService;
	public InventoryController(ItemService itemService) {
		super();
		this.itemService = itemService;
	}

	@GetMapping("/items")
	public String listItems(Model model) {
		List<Item> lis=itemService.getAllItems();
		model.addAttribute("items" , lis);
		
		return "items";
	}

	@GetMapping("/items/new")
	public String createItemForm(Model model) {
		
		Item item = new Item();
		model.addAttribute("item",item);
		return "item_create";
	}
	

	@PostMapping("/items")
	public String saveItems(@ModelAttribute("item") Item item) {
		itemService.saveItem(item);
		return "redirect:/items";
	}
	

	@GetMapping("/items/edit/{id}")
	public String editItemForm(@PathVariable Long id, Model model) {
		model.addAttribute("item",itemService.getItemById(id));
		return "edit_item";
		
	}
	
	@PostMapping("/items/{id}")
	public String updateItem(@PathVariable Long id,@ModelAttribute("item") Item item, Model model) {
		Item existingItem = itemService.getItemById(id);
		//get student details from database
		existingItem.setId(id);
		existingItem.setItemName(item.getItemName());
		existingItem.setPrice(item.getPrice());
		existingItem.setCurrentStock(item.getCurrentStock());
		itemService.updateItem(existingItem);
		return "redirect:/items";
	}
	@GetMapping("/items/hi/{id}")
	public String edit(@PathVariable Long id, Model mode) {
		mode.addAttribute("item",itemService.getItemById(id));
		return "response";
		
	}
	
	@GetMapping("/hello")
	public String run() {
		return "final";
	}
	
	@PostMapping("/itemss/{id}")
	public String upItem(@PathVariable Long id,@ModelAttribute("item") Item item, Model mode) {
		Item existing = itemService.getItemById(id);
		existing.setId(id);
		existing.setItemName(item.getItemName());
		existing.setPrice(item.getPrice());
		existing.setCurrentStock(item.getCurrentStock()-1);
		itemService.updateItem(existing);
		
		return "redirect:/items";
	}
	
	
}
