package week2.Kiosk.View;

import week2.Kiosk.domain.Category;
import week2.Kiosk.domain.Item;

import java.util.List;
import java.util.Map;

public class OutputView {

    public void printItems(Map<Category, List<Item>> itemMap) {
        for (Category category : itemMap.keySet()) {
            if (itemMap.get(category).isEmpty()) {
                continue;
            }

            System.out.println(category.getCategory());

            int cnt = 1;

            for (Item item : itemMap.get(category)) {
                System.out.println(cnt++ + ". " + item.toString());
            }
            System.out.println();
        }
    }

    public void printCartList(List<Item> items) {
        for (Item item : items) {
            System.out.println(item.toString());
        }
    }

    public void printTotal(int totalPrice) {
        System.out.println("장바구니 총 금액은 " + totalPrice);
    }
}
