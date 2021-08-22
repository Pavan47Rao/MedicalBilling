package edu.neu.csye7374.decorator;

import edu.neu.csye7374.api.ItemAPI;
import edu.neu.csye7374.api.MedicalProcedureAPI;
import edu.neu.csye7374.api.MedicalProcedureDecoratorAPI;
import edu.neu.csye7374.item.ItemRepository;

public class ParameterizedDecorator extends MedicalProcedureDecoratorAPI{
	
	private ItemAPI protoype = null;
	private MedicalProcedureAPI legacyBill;
	private String code = "";
	private String description = "";
	private double cost = 0.0;
	
	public ParameterizedDecorator(String item, MedicalProcedureAPI obj) {
		this.protoype = ItemRepository.getItem(item);
		this.legacyBill = obj;
		this.code = Integer.toString(ItemRepository.getItem(item).getId());
		this.cost = ItemRepository.getItem(item).getPrice();
		this.description = ItemRepository.getItem(item).getDescription();
	}
	
	@Override
	public String getCode() {
		return code;
	}

	@Override
	public String getDesc() {
		return description;
	}

	@Override
	public double getCost() {
		return cost;
	}
	
	@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(legacyBill);
        sb.append("\n#").append(getCode());
        sb.append(" $").append(cost);
        sb.append(" '").append(getDesc()).append("'");
        sb.append(" \nTotal Cost: $").append(this.legacyBill.getCost() + getCost());
        return sb.toString();
    }
	
}
