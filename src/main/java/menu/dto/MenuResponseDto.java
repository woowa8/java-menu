package menu.dto;

import menu.domain.Category;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MenuResponseDto {
    private final List<String> categoryNames;
    private final Map<String, List<String>> userPicks;

    private MenuResponseDto(List<String> categoryNames, Map<String, List<String>> userPicks) {
        this.categoryNames = categoryNames;
        this.userPicks = userPicks;
    }

    // 정적 팩토리 메서드
    public static MenuResponseDto of(List<Category> categoryNames, Map<String, List<String>> userPicks) {

        List<String> categoryName = categoryNames.stream()
                .map(Category::getDescription)
                .collect(Collectors.toList());

        return new MenuResponseDto(categoryName, userPicks);
    }

    public List<String> getCategoryNames() {
        return categoryNames;
    }

    public Map<String, List<String>> getUserPicks() {
        return userPicks;
    }
}
