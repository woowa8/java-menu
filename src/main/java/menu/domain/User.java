package menu.domain;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class User {
    private final String name;
    private final List<Menu> exceptionMenus;
    private final List<Menu> menus;

    public User(String name) {
        validateName(name);
        this.name = name;
        this.exceptionMenus = new ArrayList<>();
        this.menus = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Menu> getExceptionMenus() {
        return exceptionMenus;
    }

    public List<Menu> getMenus() {
        return menus;
    }

    public void validateName(String name) {
        if (name.length() < 2 || name.length() > 4) {
            throw new IllegalArgumentException("[ERROR] 이름은 두 글자 이상, 네 글자 이하여야 합니다.");
        }
    }

    public void addExceptionMenu(Menu menu) {
        exceptionMenus.add(menu);
    }

    public void addMenu(Menu menu) {
        menus.add(menu);
    }
}
