package model;

public class Goods {
    private int id,quantity;
    private float price;
    private String name,category;

    public Goods() {
    }

    public Goods(String name, String category, int quantity, float price) {
        this.quantity = quantity;
        this.price = price;
        this.name = name;
        this.category = category;
    }

    public Goods(int id, String name, String category, int quantity, float price) {
        this.id = id;
        this.quantity = quantity;
        this.price = price;
        this.name = name;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
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
}
