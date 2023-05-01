package week2.Kiosk.repository;

import lombok.Getter;
import week2.Kiosk.domain.Category;
import week2.Kiosk.domain.Item;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
public class KioskRepository {
    private final Map<Category, List<Item>> repo = new HashMap<>();
    private final List<Item> cart = new ArrayList<>();

    public KioskRepository() {
        repo.put(Category.CLOTHES, new ArrayList<>());
        repo.put(Category.FOOD, new ArrayList<>());
        repo.put(Category.BEVERAGE, new ArrayList<>());
        repo.put(Category.BAG, new ArrayList<>());
    }

    public void upload(Category category, Item item) {
        List<Item> temp = new ArrayList<>();
        temp.add(item);
        repo.put(category, temp);
    }
}
