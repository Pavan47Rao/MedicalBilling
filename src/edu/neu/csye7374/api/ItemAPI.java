package edu.neu.csye7374.api;
/**
 * ItemAPI class to model a consumer item that is bought and sold.
 * 
 * @author pavanrao
 *
 */
public class ItemAPI implements Cloneable{
	
	private int id;
	private double price;
	private String name;
	private String description;

	public ItemAPI() {
	    super();
	}
	
	public ItemAPI(int id, double price, String name, String description) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.description = description;
	}

    public int getId() {
    	return this.id;
    };

	public void setId(int id) {
		this.id = id;
	};

	public double getPrice() {
		return this.price;
	};

	public void setPrice(double price) {
		this.price = price;
	};

	public String getName() {
		return this.name;
	};
	
	public void setName(String name) {
		this.name = name;
	};

	public String getDescription() {
		return this.description;
	};

	public void setDescription(String description) {
		this.description = description;
	};
	
	public ItemAPI getMyClone() {
		Object obj = null;
		try {
			obj = this.clone();
		} catch(CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return (ItemAPI) obj;
	}

	/**
     * return a String representation of the object state
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        
        sb.append("# ").append(id);
        sb.append(" $ ").append(price);
        sb.append(" ").append(name);
        sb.append(" '").append(description).append("'");
        
        return sb.toString();
    }      
}
