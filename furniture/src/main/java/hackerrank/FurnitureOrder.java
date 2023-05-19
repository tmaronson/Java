package hackerrank;

import java.util.HashMap;
import java.util.Map;

public class FurnitureOrder implements FurnitureOrderInterface {
    /**
     * TODO: Create a map of Furniture items to order quantities
     */
	HashMap<Furniture, Integer> order;

    /**
     * Initialize a new mapping of Furniture types to order quantities.
     */
    FurnitureOrder() {
        // TODO: Complete the constructor
    	order = new HashMap<Furniture, Integer>();
    }

    public void addToOrder(final Furniture type, final int furnitureCount) {
        
    	order.put(type, furnitureCount);
    }

    public HashMap<Furniture, Integer> getOrderedFurniture() {
        // TODO: Complete the method
        return order;
    }

    public float getTotalOrderCost() {
        // TODO: Complete the method
    	float total = 0f;
       for(Map.Entry<Furniture, Integer> entry : order.entrySet()) {
    	   total += entry.getKey().cost()*entry.getValue();
       }
       return total;
    }

    public int getTypeCount(Furniture type) {
        // TODO: Complete the method
    	if(order.containsKey(type)) {
    		return order.get(type);
    	}
    	return 0;
    }

    public float getTypeCost(Furniture type) {
        // TODO: Complete the method
    	if(order.containsKey(type)) {
    		return type.cost()*order.get(type);
    	} else {
    		return 0f;
    	}
    		
        
    }

    public int getTotalOrderQuantity() {
        // like this one line solution for sum but see other way also
        //return order.values().stream().reduce(0, Integer::sum);
    	int totQuan = 0;
    	for(Integer q : order.values()) {
    		totQuan += q;
    	}
    	return totQuan;
    }
}