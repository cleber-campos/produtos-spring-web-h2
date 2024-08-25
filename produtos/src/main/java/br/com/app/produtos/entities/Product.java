package br.com.app.produtos.entities;

public class Product {
    private Long id;
    private String name;
    private Double price;
    private Category category;

    public Product() {
    }

    public Product(Long id, String name, Double price, Category category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return  "id: " + id +
                "| name: " + name +
                "| price: " + price +
                "| Category: " + category;
    }
}
