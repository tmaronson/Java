
import java.util.Scanner;

abstract class Cuisine {
    public abstract Cuisine serveFood(String dish);
}

class UnservableCuisineRequestException extends Exception {
    public UnservableCuisineRequestException(String message) {
        super(message);
    }
}

/*
 * Create the FoodFactory class and other required classes here.
 Shows Factory and Singleton patterns.
 */

class FoodFactory {
    
    java.util.Map<String, Cuisine> cuisines =  new java.util.HashMap<String, Cuisine>();
    private static FoodFactory factory = null;  // part of Singleton - one Factory
   
    static FoodFactory getFactory() {  // Singleton pattern-like
        if(factory == null)
            factory = new FoodFactory();
         return factory;
    }
    
    void registerCuisine(String cuisineKey, Cuisine cuisine) {
         cuisines.put(cuisineKey, cuisine.serveFood(cuisineKey));
    }
    
    public Cuisine serveCuisine(String cuisineKey, String dish) throws UnservableCuisineRequestException {
        if (!cuisines.containsKey(cuisineKey)) {
            throw new UnservableCuisineRequestException("Unservable cuisine " + cuisineKey + " for dish " + dish);
        }
        else 
            return cuisines.get(cuisineKey).serveFood(dish);
    }
} 

/* This could be improved because violates DRY principle but limited due to HackerRank locked files!
   The addition of classes for every food type uses Open Closed Principle.
*/
    
   class Chinese extends Cuisine {
        
        private String dish;
        
        public Cuisine serveFood(String dish) {
            this.dish = dish;
            return this;
        }
        
        public String getDish() {
            return dish;
        }
        
    }

class Mexican extends Cuisine {
        
        private String dish;
        
        public Cuisine serveFood(String dish) {
            this.dish = dish;
            return this;
        }
        
        public String getDish() {
            return dish;
        }
        
}

class Italian extends Cuisine {
        
        private String dish;
        
        public Cuisine serveFood(String dish) {
            this.dish = dish;
            return this;
        }
        
        public String getDish() {
            return dish;
        }
        
}

class Japanese extends Cuisine {
        
        private String dish;
        
        public Cuisine serveFood(String dish) {
            this.dish = dish;
            return this;
        }
        
        public String getDish() {
            return dish;
            
        }
        
} 

public class Solution {
    private static final Scanner INPUT_READER = new Scanner(System.in);
    private static final FoodFactory FOOD_FACTORY = FoodFactory.getFactory();
    
    static {
        FoodFactory.getFactory().registerCuisine("Chinese", new Chinese());
        FoodFactory.getFactory().registerCuisine("Italian", new Italian());
        FoodFactory.getFactory().registerCuisine("Japanese", new Japanese());
        FoodFactory.getFactory().registerCuisine("Mexican", new Mexican());
    }
    
    public static void main(String[] args) {
        int totalNumberOfOrders = Integer.parseInt(INPUT_READER.nextLine());
        while (totalNumberOfOrders-- > 0) {
            String[] food = INPUT_READER.nextLine().split(" ");
            String cuisine = food[0];
            String dish = food[1];

            try {
                if (FOOD_FACTORY.equals(FoodFactory.getFactory())) {
                    Cuisine servedFood = FOOD_FACTORY.serveCuisine(cuisine, dish);

                    switch (cuisine) {
                        case "Chinese":
                            Chinese chineseDish = (Chinese) servedFood;
                            System.out.println("Serving " + chineseDish.getDish() + "(Chinese)");
                            break;
                        case "Italian":
                            Italian italianDish = (Italian) servedFood;
                            System.out.println("Serving " + italianDish.getDish() + "(Italian)");
                            break;
                        case "Japanese":
                            Japanese japaneseDish = (Japanese) servedFood;
                            System.out.println("Serving " + japaneseDish.getDish() + "(Japanese)");
                            break;
                        case "Mexican":
                            Mexican mexicanDish = (Mexican) servedFood;
                            System.out.println("Serving " + mexicanDish.getDish() + "(Mexican)");
                            break;
                        default:
                            break;
                    }
                }
            } catch (UnservableCuisineRequestException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}


