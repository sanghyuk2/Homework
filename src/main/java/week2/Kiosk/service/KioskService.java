package week2.Kiosk.service;

import week2.Kiosk.Util.Validator;
import week2.Kiosk.domain.*;
import week2.Kiosk.repository.KioskRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static week2.Kiosk.domain.Category.*;

public class KioskService {
    private final KioskRepository kioskRepository;

    public KioskService(KioskRepository kioskRepository) {
        this.kioskRepository = kioskRepository;
    }

    public void uploadProduct(String info) {
        Validator.validateUpload(info);

        String[] infoArr = info.split(",");

        Item item = null;

        switch (Category.from(infoArr[0])) {
            case BAG:
                item = new Bag(infoArr[1], Integer.parseInt(infoArr[2]));
                break;
            case FOOD:
                item = new Food(infoArr[1], Integer.parseInt(infoArr[2]));
                break;
            case CLOTHES:
                item = new Clothes(infoArr[1], Integer.parseInt(infoArr[2]));
                break;
            case BEVERAGE:
                item = new Beverage(infoArr[1], Integer.parseInt(infoArr[2]));
                break;
        }

        kioskRepository.upload(Category.from(infoArr[0]), item);
    }

    public Map<Category, List<Item>> viewItems() {
        return kioskRepository.view();
    }

    public void intoCart(String str) {
        List<String> orderList = separateByCategory(str);

        for (String order : orderList) {
            String[] split = order.split(",");
            kioskRepository.add(Category.from(split[0]), split[1]);
        }
    }

    private List<String> separateByCategory(String str) {
        if (str.contains("|")) {
            String[] split = str.split("\\|");
            return Arrays.stream(split).collect(Collectors.toList());
        }
        return Arrays.asList(str);
    }

    public List<Item> viewCartList() {
        return kioskRepository.getCart();
    }

    public int totalPrice() {
        int totalAmt = 0;

        List<Item> cart = kioskRepository.getCart();

        for (Item item : cart) {
            Category category = getItemCategory(item);
            totalAmt += getItemPrice(category, item);
        }

        return totalAmt;
    }

    private int getItemPrice(Category category, Item item) {
        switch (category) {
            case BAG:
                return ((Bag) item).getPrice();
            case BEVERAGE:
                return ((Beverage) item).getPrice();
            case CLOTHES:
                return ((Clothes) item).getPrice();
            case FOOD:
                return ((Food) item).getPrice();
        }
        return 0;
    }

    private Category getItemCategory(Item item) {
        Map<Category, List<Item>> repo = kioskRepository.getRepo();
        for (Category category : repo.keySet()) {
            if (repo.get(category).contains(item)) {
                return category;
            }
        }
        return null;
    }
}
