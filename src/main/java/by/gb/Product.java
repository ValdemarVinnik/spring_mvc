package by.gb;

public class Product {

    static private int count = 0;
    private int id;
    private long price;
    private String title;

    public Product(String title, long price) {
        this.count++;
        this.id = count;
        this.price = price;
        this.title = title;
    }

    public Product() {
        this.id++;
    }

    public int getId() {
        return id;
    }

    public long getPrice() {
        return price;
    }

    public String getTitle() {
        return title;
    }

    public void setCost(long price) {
        this.price = price;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", price=" + price +
                ", title='" + title + '\'' +
                '}';
    }
}
