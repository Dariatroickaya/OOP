import java.io.Serializable;

public class Product implements Serializable {
    String Id;
    String Name;
    String Description;
    Float Price;

    public Product(String Id, String Name, String Description, Float Price) {
        this.Id = Id;
        this.Name = Name;
        this.Description = Description;
        this.Price = Price;
    }

    public String getId() {
        return this.Id;
    }

    public String getName() {
        return this.Name;
    }

    public String getDescription() {
        return this.Description;
    }

    public Float getPrice() {
        return this.Price;
    }

    @Override
    public String toString() {
        return "Product id: " + Id + "; " +
                "name: " + Name + "; " +
                "description: " + Description + "; " +
                "price: " + Price;
    }
}
