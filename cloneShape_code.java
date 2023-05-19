/*
 * Create the Shape class here
 */
class Shape implements Cloneable {
    
    private String type;
    private String color;
    
    Shape(String type, String color) {
        this.type = type;
        this.color = color;
    }
    
    public void setType(String type) {
        this.type = type;
    }
    
    public void setColor(String color) {
        this.color = color;
    }
    
    String getType() {
        return type;
    }
    
    String getColor() {
        return color;
    }
    
    Shape cloneShape()  {
        Shape s = null;
        try {
            s = (Shape)super.clone();
        } catch(CloneNotSupportedException ex) {
            ex.printStackTrace();
        }
        return s;
     }

}