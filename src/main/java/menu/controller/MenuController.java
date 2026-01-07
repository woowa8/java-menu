package menu.controller;

import menu.domain.Category;
import menu.domain.Menu;
import menu.domain.User;
import menu.dto.MenuResponseDto;
import menu.repository.MenuRepository;
import menu.repository.UserRepository;
import menu.service.MenuService;
import menu.util.InitData;
import menu.util.InputParser;
import menu.view.InputView;
import menu.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class MenuController {
    private final InputView inputView;
    private final MenuService menuService;
    private final OutputView outputView;

    public MenuController() {
        InputParser parser = new InputParser();
        inputView = new InputView(parser);

        MenuRepository menuRepository = new MenuRepository();
        UserRepository userRepository = new UserRepository();

        InitData initData = new InitData(menuRepository);

        menuService = new MenuService(userRepository, menuRepository);
        outputView = new OutputView();
    }

    public void run() {
        List<Category> categories = new ArrayList<>();
        outputView.printIntro();

        List<String> userNames = inputView.inputUsers();
        for (String name : userNames) {
            saveExceptionMenus(name);
        }

        // 5일 동안 (월,화,수,목,금) 반복해서 카테고리를 정한다.
        for (int i = 0; i < 5; i++) {
            Category category = menuService.chooseCategory();
            categories.add(category);
            saveMenusByUser(category);
        }

        // outputView에 내보낸다.
        MenuResponseDto response = menuService.result(categories, menuService.getUsers());
        outputView.printMenuRecommended(response);
        outputView.printOutro();
    }

    private void saveExceptionMenus(String name) {
        menuService.saveUser(name);
        List<String> userExceptionMenus = inputView.inputExceptionMenu(name);
        menuService.saveExceptionMenu(name, userExceptionMenus);
    }

    private void saveMenusByUser(Category category) {
        for (User user : menuService.getUsers()) {
            Menu menu = menuService.chooseMenu(category, user);

            user.addMenu(menu);
        }
    }
}
