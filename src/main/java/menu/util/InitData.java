package menu.util;

import menu.domain.Category;
import menu.domain.Menu;
import menu.repository.MenuRepository;

/*
메뉴 초기화를 위함이다.
 */
public class InitData {
    private final MenuRepository menuRepository;

    public InitData(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
        init();
    }

    private void init() {
        initJapaneseMenuData();
        initKoreanMenuData();
        initChineseMenuData();
        initAsianMenuData();
        initWesternMenuData();
    }

    private void initJapaneseMenuData() {
        Menu m1 = new Menu("규동", Category.JAPANESE);
        Menu m2 = new Menu("우동", Category.JAPANESE);
        Menu m3 = new Menu("미소시루", Category.JAPANESE);
        Menu m4 = new Menu("스시", Category.JAPANESE);
        Menu m5 = new Menu("가츠동", Category.JAPANESE);
        Menu m6 = new Menu("오니기리", Category.JAPANESE);
        Menu m7 = new Menu("하이라이스", Category.JAPANESE);
        Menu m8 = new Menu("라멘", Category.JAPANESE);
        Menu m9 = new Menu("오코노미야끼", Category.JAPANESE);

        menuRepository.addMenu(m1);
        menuRepository.addMenu(m2);
        menuRepository.addMenu(m3);
        menuRepository.addMenu(m4);
        menuRepository.addMenu(m5);
        menuRepository.addMenu(m6);
        menuRepository.addMenu(m7);
        menuRepository.addMenu(m8);
        menuRepository.addMenu(m9);
    }

    private void initKoreanMenuData() {
        Menu m1 = new Menu("김밥", Category.KOREAN);
        Menu m2 = new Menu("김치찌개", Category.KOREAN);
        Menu m3 = new Menu("쌈밥", Category.KOREAN);
        Menu m4 = new Menu("된장찌개", Category.KOREAN);
        Menu m5 = new Menu("비빔밥", Category.KOREAN);
        Menu m6 = new Menu("칼국수", Category.KOREAN);
        Menu m7 = new Menu("불고기", Category.KOREAN);
        Menu m8 = new Menu("떡볶이", Category.KOREAN);
        Menu m9 = new Menu("제육볶음", Category.KOREAN);

        menuRepository.addMenu(m1);
        menuRepository.addMenu(m2);
        menuRepository.addMenu(m3);
        menuRepository.addMenu(m4);
        menuRepository.addMenu(m5);
        menuRepository.addMenu(m6);
        menuRepository.addMenu(m7);
        menuRepository.addMenu(m8);
        menuRepository.addMenu(m9);
    }

    private void initChineseMenuData() {
        Menu m1 = new Menu("깐풍기", Category.CHINESE);
        Menu m2 = new Menu("볶음면", Category.CHINESE);
        Menu m3 = new Menu("동파육", Category.CHINESE);
        Menu m4 = new Menu("짜장면", Category.CHINESE);
        Menu m5 = new Menu("짬뽕", Category.CHINESE);
        Menu m6 = new Menu("마파두부", Category.CHINESE);
        Menu m7 = new Menu("탕수육", Category.CHINESE);
        Menu m8 = new Menu("토마토 달걀볶음", Category.CHINESE);
        Menu m9 = new Menu("고추잡채", Category.CHINESE);

        menuRepository.addMenu(m1);
        menuRepository.addMenu(m2);
        menuRepository.addMenu(m3);
        menuRepository.addMenu(m4);
        menuRepository.addMenu(m5);
        menuRepository.addMenu(m6);
        menuRepository.addMenu(m7);
        menuRepository.addMenu(m8);
        menuRepository.addMenu(m9);
    }

    private void initAsianMenuData() {
        Menu m1 = new Menu("팟타이", Category.ASIAN);
        Menu m2 = new Menu("카오 팟", Category.ASIAN);
        Menu m3 = new Menu("나시고렝", Category.ASIAN);
        Menu m4 = new Menu("파인애플 볶음밥", Category.ASIAN);
        Menu m5 = new Menu("쌀국수", Category.ASIAN);
        Menu m6 = new Menu("똠얌꿍", Category.ASIAN);
        Menu m7 = new Menu("반미", Category.ASIAN);
        Menu m8 = new Menu("월남쌈", Category.ASIAN);
        Menu m9 = new Menu("분짜", Category.ASIAN);

        menuRepository.addMenu(m1);
        menuRepository.addMenu(m2);
        menuRepository.addMenu(m3);
        menuRepository.addMenu(m4);
        menuRepository.addMenu(m5);
        menuRepository.addMenu(m6);
        menuRepository.addMenu(m7);
        menuRepository.addMenu(m8);
        menuRepository.addMenu(m9);
    }

    private void initWesternMenuData() {
        Menu m1 = new Menu("라자냐", Category.WESTERN);
        Menu m2 = new Menu("그라탱", Category.WESTERN);
        Menu m3 = new Menu("뇨끼", Category.WESTERN);
        Menu m4 = new Menu("끼슈", Category.WESTERN);
        Menu m5 = new Menu("프렌치 토스트", Category.WESTERN);
        Menu m6 = new Menu("바게트", Category.WESTERN);
        Menu m7 = new Menu("스파게티", Category.WESTERN);
        Menu m8 = new Menu("피자", Category.WESTERN);
        Menu m9 = new Menu("파니니", Category.WESTERN);

        menuRepository.addMenu(m1);
        menuRepository.addMenu(m2);
        menuRepository.addMenu(m3);
        menuRepository.addMenu(m4);
        menuRepository.addMenu(m5);
        menuRepository.addMenu(m6);
        menuRepository.addMenu(m7);
        menuRepository.addMenu(m8);
        menuRepository.addMenu(m9);
    }
}
