package edu.neu.csye7374.item;

import edu.neu.csye7374.api.ItemAPI;

/**
 * class Toothpaste is a subclass of ItemAPI that models Toothpaste specific details
 * 
 * @author pavanrao
 *
 */

public class Toothpaste extends ItemAPI{

	private final static int TOOTHPASTE_ID = 23;
    private final static double TOOTHPASTE_PRICE = 12.08;
    private final static String TOOTHPASTE_NAME = "Colgate";
    private final static String TOOTHPASTE_DESCRIPTION = "Toothpaste with Floride";
    
    {
		this.setId(TOOTHPASTE_ID);
		this.setPrice(TOOTHPASTE_PRICE);
		this.setName(TOOTHPASTE_NAME);
		this.setDescription(TOOTHPASTE_DESCRIPTION);
	}
    
	public Toothpaste() {
		super();
	}
	
	public Toothpaste(int id, double price, String name, String description) {
		super(id, price, name, description);
	}
}
