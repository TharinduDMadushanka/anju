package DesignPatterns.Composite.wrong;

import java.util.List;

public class Box {

    List<Box> boxes;
    List<Product> products;

    public Box() {
    }

    public Box(List<Box> boxes, List<Product> products) {
        this.boxes = boxes;
        this.products = products;
    }

    public List<Box> getBoxes() {
        return boxes;
    }

    public void setBoxes(List<Box> boxes) {
        this.boxes = boxes;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public double calculateCost(){

        double sum = products.stream().mapToDouble(Product::getCost).sum();

        for(Box b : boxes){
            sum += b.calculateCost();
        }
        return sum;
    }
}
