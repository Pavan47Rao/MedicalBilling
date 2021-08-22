package edu.neu.csye7374.item;

import edu.neu.csye7374.api.ItemAPI;

/**
 * class Tylenol is a subclass of ItemAPI that models Tylenol specific details
 * 
 * @author pavanrao Acetaminophen
 *
 */

public class Tylenol extends ItemAPI{

	private final static int TYLENOL_ID = 21;
    private final static double TYLENOL_PRICE = 19.0;
    private final static String TYLENOL_NAME = "Tylenol";
    private final static String TYLENOL_DESCRIPTION = "Tylenol with Acetaminophen";
    
    {
		this.setId(TYLENOL_ID);
		this.setPrice(TYLENOL_PRICE);
		this.setName(TYLENOL_NAME);
		this.setDescription(TYLENOL_DESCRIPTION);
	}
    
	public Tylenol() {
		super();
	}
	
	public Tylenol(int id, double price, String name, String description) {
		super(id, price, name, description);
	}

}