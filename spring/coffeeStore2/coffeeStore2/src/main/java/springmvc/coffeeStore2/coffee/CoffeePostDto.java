package springmvc.coffeeStore2.coffee;

public class CoffeePostDto {
    String korName;
    String engName;
    int price;

    public CoffeePostDto(String korName, String engName, int price) {
        this.korName = korName;
        this.engName = engName;
        this.price = price;
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

    public String getKorName() {
        return korName;
    }

    public void setKorName(String korName) {
        this.korName = korName;
    }
}
