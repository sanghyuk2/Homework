package week2.Kiosk.domain;

import lombok.Getter;

@Getter
public class Bag extends Item {
    private int price;

    public Bag(String name, int price) {
        super(name);
        this.price = price;
    }

    @Override
    public String toString() {
        return "상품명 = " + name +
                ", 가격 = " + price + "원";
    }
}
