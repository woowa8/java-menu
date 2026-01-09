package menu.service;

import camp.nextstep.edu.missionutils.Randoms;
import menu.domain.Category;
import menu.domain.Menu;
import menu.domain.User;
import menu.dto.MenuResponseDto;
import menu.repository.MenuRepository;
import menu.repository.UserRepository;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static menu.domain.Category.getOrdinal;

public class MenuService {
    private UserRepository userRepository;
    private MenuRepository menuRepository;

    public MenuService(UserRepository userRepository, MenuRepository menuRepository) {
        this.userRepository = userRepository;
        this.menuRepository = menuRepository;
    }

    // 1. user 저장하는 기능
    public void saveUser(String userName) {
        userRepository.addUser(new User(userName));
    }

    // 2. 카테고리 정하는 기능
    public Category chooseCategory() {
        while (true) {
            int random = Randoms.pickNumberInRange(1, 5);
            Category category = getOrdinal(random);
            int count = userRepository.isCategoryChoose(category);

            if (count < 2) {
                return category;
            }
        }
    }

    // 3. 코치별로 메뉴 고르는 기능
    public Menu chooseMenu(Category category, User user) {
        List<Menu> menus = menuRepository.findMenuByCategory(category);

        while (true) {
            // TODO : map 쓰는 것 조심하자 제발..
            List<String> menusToStr = menus.stream().map(Menu::getName).collect(Collectors.toList());
            String menuStr = Randoms.shuffle(menusToStr).get(0);    // TODO : 설명을 잘 보자. String으로 넣어야 한다.

            Menu menu = menuRepository.findByMenuName(menuStr);

            if (!userRepository.containsUserMenu(menu, user)
                    && !userRepository.containsUserExceptionMenu(menu, user)
            ) {
                return menu;
            }
        }
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public void saveExceptionMenu(String userName, List<String> userExceptionMenus) {
        User user = userRepository.findByUsername(userName);
        for (String menu : userExceptionMenus) {
            Menu exceptionMenu = menuRepository.findByMenuName(menu);
            user.addExceptionMenu(exceptionMenu);
        }
    }

    // 5. 마지막 조립하는 기능
    public MenuResponseDto result(List<Category> categoryNames, List<User> users) {
        Map<String, List<String>> userPicks = new HashMap<>();

        for (User user : users) {
            List<String> menus = user.getMenus().stream()
                    .map(Menu::getName)
                    .collect(Collectors.toList());

            userPicks.put(user.getName(), menus);
        }

        return MenuResponseDto.of(categoryNames, userPicks);
    }
}
