package menu.repository;

import menu.domain.Category;
import menu.domain.Menu;
import menu.domain.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserRepository {
    private final List<User> users;

    public UserRepository() {
        this.users = new ArrayList<>();
    }

    public List<User> findAll() {
        return users;
    }

    public User findByUsername(String username) {
        return users.stream()
                .filter(user -> user.getName().equals(username))
                .findFirst().orElse(null);
    }

    // TODO : anyMatch stream 쓰는법 알아 둬야 한다.
    public int isCategoryChoose(Category category) {
        return (int) users.stream()
                .filter(user -> user.getMenus().stream()
                        .anyMatch(menu -> menu.getCategory().equals(category)))
                .count();
    }

    public void addUser(User user) {
        users.add(user);
    }

    //  해당하는 메뉴가 유저가 뽑은 메뉴 안에 있는지 검사
    public boolean containsUserMenu(Menu inputMenu, User user) {
        return user.getMenus().stream()
                .anyMatch(menu -> menu.getName().equals(inputMenu.getName()));
    }

    //  해당하는 메뉴가 유저가 싫어하는 메뉴 안에 있는지 검사
    public boolean containsUserExceptionMenu(Menu inputMenu, User user) {
        return user.getExceptionMenus().stream()
                .anyMatch(menu -> menu.getName().equals(inputMenu.getName()));
    }
}
