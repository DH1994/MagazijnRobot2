package algoritme.bpp;

import java.util.ArrayList;

public class Bin {

    protected int size, capacity, ID;

    protected ArrayList<Product> content;

    public Bin(int capacity, int ID) {
        this.capacity = capacity;
        content = new ArrayList<Product>();
        this.ID = ID;
    }

    public boolean addProduct(Product p) {
        if (this.size + p.size > this.capacity) {
            return false;
        } else {
            content.add(p);
            size += p.size;
            return true;
        }
    }
    public void addItem(Product p) {
        content.add(p);
    }
    
    @Override
    public String toString() {
        String output = "";
        for (Product p : content) {
            output += p.name + " ";
        }
        return output + "\n";
    }
}
