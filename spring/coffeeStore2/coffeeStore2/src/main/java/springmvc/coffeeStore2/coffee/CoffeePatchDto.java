package springmvc.coffeeStore2.coffee;

public class CoffeePatchDto {
    long coffeeId;
    String korName;
    String engName;
    int price;

    public long getCoffeeId() {
        return coffeeId;
    }

    public String getKorName() {
        return korName;
    }

    public void setKorName(String korName) {
        this.korName = korName;
    }

    public String getEngName() {
        return engName;
    }

    public void setEngName(String engName) {
        this.engName = engName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
