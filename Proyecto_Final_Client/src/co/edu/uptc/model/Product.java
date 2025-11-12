package co.edu.uptc.model;

public class Product {

    private String name;
    private String category;
    private double price;
    private int quantity;
    private String note;

    public Product(String name, String category, double price, int quantity, String note) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
        this.note = note;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
