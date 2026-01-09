package menu.repository;

import menu.domain.Category;
import menu.domain.Menu;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MenuRepository {
    private final List<Menu> menus;

    public MenuRepository() {
        menus = new ArrayList<>();
    }

    public void addMenu(Menu menu) {
        menus.add(menu);
    }

    public Menu findByMenuName(String menuName) {
        return menus.stream()
                .filter(menu -> menu.getName().equals(menuName))
                .findFirst().orElse(null);
    }

    public List<Menu> findMenuByCategory(Category category) {
        return menus.stream()
                .filter(menu -> menu.getCategory().equals(category))
                .collect(Collectors.toList());
    }
}
