package edu.neu.csye7374.item;

import java.util.HashMap;
import java.util.Map;

import edu.neu.csye7374.api.ItemAPI;

public class ItemRepository {
	private static Map<String, ItemAPI> itemMap  = new HashMap<>();

	   public static ItemAPI getItem(String itemId) {
		  ItemAPI cachedShape = itemMap.get(itemId);
	      return (ItemAPI) cachedShape.getMyClone();
	   }
	   
	   public static void loadItems() {
		  Toothpaste toothPaste = new Toothpaste();
		  itemMap.put("ToothPaste",toothPaste);

		  Tylenol tylenol = new Tylenol();
	      itemMap.put("Tylenol",tylenol);
	   }
}
