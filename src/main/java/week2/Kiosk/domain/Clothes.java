package week2.Kiosk.domain;

public class Clothes extends Item {
    private int price;

    public Clothes(String name, int price) {
        super(name);
        this.price = price;
    }

    @Override
    public String toString() {
        return "상품명 = " + name +
                ", 가격 = " + price + "원";
    }
}
