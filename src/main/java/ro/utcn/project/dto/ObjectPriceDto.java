package ro.utcn.project.dto;

public class ObjectPriceDto {
    private double price;

    public ObjectPriceDto() {
    }

    public double getPrice() {
        return price;
    }

    public ObjectPriceDto(double price) {
        this.price = price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
