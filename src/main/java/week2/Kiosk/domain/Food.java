package week2.Kiosk.domain;

import lombok.Getter;

@Getter
public class Food extends Item {
    private int price;

    public Food(String name, int price) {
        super(name);
        this.price = price;
    }

    @Override
    public String toString() {
        return "상품명 = " + name +
                ", 가격 = " + price + "원";
    }
}
