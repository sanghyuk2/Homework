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
        repo.get(category).add(item);
    }

    public Map<Category, List<Item>> view() {
        return repo;
    }

    public void add(Category category, String name) {
        Item item = repo.get(category).stream()
                .filter(items -> items.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("찾으시는 상품이 존재하지 않습니다."));

        cart.add(item);
    }
}
