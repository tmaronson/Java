package com.hackerrank.orm.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hackerrank.orm.model.Item;
import com.hackerrank.orm.repository.ItemRepository;
import com.hackerrank.orm.service.ItemService;

@RestController
public class ItemController {

	@Autowired
    ItemService itemService;
    @Autowired
	ItemRepository itemRepository;

    //1. insert POST
    @RequestMapping(value = "/app/item", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<Item> saveItem(@RequestBody @Valid Item item) {
		
		
		Boolean existingItem = itemRepository.existsById(item.getItemId());
		if(existingItem)
		{
			return new ResponseEntity<>(item, HttpStatus.BAD_REQUEST);
		}
		else
		{
			item = itemRepository.save(item);
			return new ResponseEntity<>(item, HttpStatus.CREATED);
		}
		
	}


    //2. update PUT
    
    @PutMapping("/app/item/{itemId}")
    public ResponseEntity<Item> updateItem(@RequestBody @Valid Item item, @PathVariable("itemId") int itemid) {
		Boolean existingItem = itemRepository.existsById(itemid);
    	
    	if(existingItem)
    	{
    		
    		Item eitem = itemRepository.findById(itemid).get();
    		eitem.setItemBuyingPrice(item.getItemBuyingPrice());
    		eitem.setItemEnteredByUser(item.getItemEnteredByUser());
    		eitem.setItemEnteredDate(item.getItemEnteredDate());
    	//	eitem.setItemId(item.getItemId());
    		eitem.setItemLastModifiedByUser(item.getItemLastModifiedByUser());
    		eitem.setItemLastModifiedDate(item.getItemLastModifiedDate());
    		eitem.setItemName(item.getItemName());
    		eitem.setItemSellingPrice(item.getItemSellingPrice());
    		eitem.setItemStatus(item.getItemStatus());
    		
    		eitem = itemRepository.save(eitem);
    		return new ResponseEntity<>(eitem, HttpStatus.OK);
    	}
    	else
    	{
    		//return new ResponseEntity<>(item, HttpStatus.BAD_REQUEST);
    		return new ResponseEntity<>(item, HttpStatus.NOT_FOUND);
    	}
    	
    }


    //3. delete by itemId DELETE
    @DeleteMapping("/app/item/{itemId}")
    public ResponseEntity<Item> deleteItem( @PathVariable("itemId") int itemid) {
    	Boolean existingItem = itemRepository.existsById(itemid);
    	Item item = new Item();
    	if(existingItem)
    	{
    		item = itemRepository.findById(itemid).get();
    		itemRepository.deleteById(itemid);
    		
    		return new ResponseEntity<>(item, HttpStatus.OK);
    	}
    	else
    	{
    		
    		return new ResponseEntity<>(item, HttpStatus.BAD_REQUEST);
    	}
    	
    }

    //4. delete all DELETE
    @DeleteMapping("/app/item")
    public ResponseEntity<Item> deleteAllItem() {
    	itemRepository.deleteAll();
		Item item = new Item();
		return new ResponseEntity<>(item, HttpStatus.OK);
    	
    }


    //5. get by itemId GET
    @GetMapping("/app/item/{itemId}")
	public ResponseEntity<Item> getItem(@PathVariable("itemId") int itemid) {
		Item item = null;
		try
		{
			item = itemRepository.findById(itemid).get();
			if(item!=null)
			{
				return new ResponseEntity<>(item, HttpStatus.OK);
			}
			else
			{
				return new ResponseEntity<>(item, HttpStatus.NOT_FOUND);
			}
		}
		catch(NoSuchElementException e)
		{
			return new ResponseEntity<>(item, HttpStatus.NOT_FOUND);
		}
		
	}

    //6. get all GET

    @GetMapping("/app/item")
	public ResponseEntity<List<Item>> getItems(@RequestParam(required = false) String itemStatus, @RequestParam(required = false) String itemEnteredByUser, @RequestParam(required = false) String pageSize, @RequestParam(required = false) String page, @RequestParam(required = false) String sortBy) {
		
		
		if(itemStatus!=null && itemStatus!="" && itemEnteredByUser!=null && itemEnteredByUser!="")
		{
			List<Item> allitems = new ArrayList<Item>();
			
			allitems = itemRepository.findAll();
			
			List<Item> items = new ArrayList<Item>();
			for(Item i:allitems )
			{
				if(i.getItemStatus().name().equalsIgnoreCase(itemStatus) && i.getItemEnteredByUser().equalsIgnoreCase(itemEnteredByUser))
				{
					items.add(i);
				}
			}
			if(items!=null && items.size() > 0)
			{
				return new ResponseEntity<>(items, HttpStatus.OK);
			}
			else
			{
				return new ResponseEntity<>(items, HttpStatus.OK);
			}
			
		}
		else if(pageSize!=null && pageSize!="" && page!=null && page!="" && sortBy!=null && sortBy!="")
		{
		
			
			List<Item> allitems = itemRepository.findAll(Sort.by(Sort.Direction.ASC, sortBy));
			
			List<Item> items = new ArrayList<Item>();
			List<Item> finalitems = new ArrayList<Item>();
			for(Item i:allitems )
			{
				if(items.size() >= Integer.valueOf(pageSize))
				{
					finalitems.add(i);
				}
				items.add(i);
			}
			
			
			if(finalitems!=null && finalitems.size() > 0)
			{
				return new ResponseEntity<>(finalitems, HttpStatus.OK);
			}
			else
			{
				return new ResponseEntity<>(finalitems, HttpStatus.OK);
			}
			
		}
		else
		{
			List<Item> items = itemRepository.findAll();
			items.sort((Item s1, Item s2)->s1.getItemId()-s2.getItemId()); 
			
			if(items!=null && items.size() > 0)
			{
				return new ResponseEntity<>(items, HttpStatus.OK);
			}
			else
			{
				return new ResponseEntity<>(items, HttpStatus.OK);
			}
		}
	}

    //7. filters by fields ?itemStatus={status}&itemEnteredByUser={modifiedBy} GET


    //8. select all with sorting and pagination ?pageSize={pageSize}&page={page}&sortBy={sortBy} GET

}
