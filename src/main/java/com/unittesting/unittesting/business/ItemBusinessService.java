package com.unittesting.unittesting.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unittesting.unittesting.model.Item;

import data.ItemRepository;

@Service
public class ItemBusinessService {
	
	@Autowired
	private ItemRepository itemRepository;

	public Item retrieveHardcodedItem() {
		return new Item(1, "Ball", 10, 100);
	}
	
	public List<Item> retriveAllItems(){
		List<Item> items = itemRepository.findAll();
		
		return items;
		
	}

}
