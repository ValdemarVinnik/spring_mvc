package by.gb;

public class Product {

    static private int id = 0;
    public long cost;
    public String title;

    public Product(String title, long cost) {
        this.id++;
        this.cost = cost;
        this.title = title;
    }

    public Product() {
        this.id++;
    }

    public int getId() {
        return id;
    }

    public long getCost() {
        return cost;
    }

    public String getTitle() {
        return title;
    }

    public void setCost(long cost) {
        this.cost = cost;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", cost=" + cost +
                ", title='" + title + '\'' +
                '}';
    }
}
