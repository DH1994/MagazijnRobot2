package algoritme.bpp;

import java.util.ArrayList;

public class BPPAlgoritme {
    // protected int numberOffBins;

    protected int capacity;
    private ArrayList<Bin> bins;
    private ArrayList<Product> input;
    private ArrayList<Bin> result;


    public BPPAlgoritme(int c, ArrayList i) {
        // this.numberOffBins = b;
        this.capacity = c;
        input = new ArrayList<Product>();
        input = i;
        result = new ArrayList<>();
    }

    public void pack() {
        for (Product p : input) {
            int ID = checkLowestBin(p.size);
            for (Bin b : bins) {
                if (ID == b.ID) {
                    b.addItem(p);
                    b.size = b.size - p.size;
                }
            }
        }
        for (Bin b : bins) {
            result.add(b);
        }
    }

    public ArrayList getResult() {
        return result;
    }

    public int checkLowestBin(int size) {
        int BinID = 0;
        int lowestSize = Integer.MAX_VALUE;
        boolean filled = false;
        if (bins.isEmpty() && bins == null) {
            filled = false;
        }
        for (Bin b : bins) {
            if (b.size >= size && b.size < lowestSize) {
                lowestSize = b.size;
                b.ID = BinID;
                filled = true;
            } else {
                filled = false;
            }
        }
        if (filled == false) {
            int ID = bins.size() + 1;
            Bin newbin = new Bin(capacity, ID);
            bins.add(newbin);
            BinID = ID;
        }
        return BinID;
    }

    public String toString() {
        String t = "";
        for (Bin b : result) {
            t += super.toString();
        }
        return t;
    }
}


