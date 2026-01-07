package menu.view;

import menu.dto.MenuResponseDto;

import java.util.List;
import java.util.Map;

public class OutputView {
    // 인트로 출력
    public void printIntro() {
        System.out.println("점심 메뉴 추천을 시작합니다.");
        System.out.println();
    }

    // 메뉴 추천 결과 출력
    public void printMenuRecommended(MenuResponseDto dto) {
        System.out.println("메뉴 추천 결과입니다.");
        System.out.println("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]");
        System.out.println(printCategory(dto.getCategoryNames()));
        System.out.print(printUserPicks(dto.getUserPicks()));  // TODO : String으로 만들 경우, 자잘한 실수들을 주의하자.
    }

    // 마지막 말 입력
    public void printOutro() {
        System.out.println("추천을 완료했습니다.");
    }

    private String printCategory(List<String> categoryNames) {
        StringBuilder st = new StringBuilder();
        st.append("[ ");
        st.append("카테고리");

        for (String categoryName : categoryNames) {
            st.append(" | ").append(categoryName);
        }
        st.append(" ]");

        return st.toString();
    }

    private String printUserPicks(Map<String, List<String>> userPicks) {
        StringBuilder st = new StringBuilder();
        for (Map.Entry<String, List<String>> entry : userPicks.entrySet()) {
            st.append("[ ").append(entry.getKey());    // 이름 더하기
            st.append(printUserPickMenu(entry.getValue()));    // 음식들 더하기
            st.append("\n");
        }
        return st.toString();
    }

    private String printUserPickMenu(List<String> menus) {
        StringBuilder st = new StringBuilder();

        for (String menu : menus) {
            st.append(" | ").append(menu);
        }
        st.append(" ]");

        return st.toString();
    }
}
