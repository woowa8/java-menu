package menu.util;

import java.util.Arrays;
import java.util.List;

public class InputParser {
    // ,로 파싱하는 method
    public List<String> parseUser(String input) {
        String[] words = input.split(",");

        if (words.length < 2) {
            throw new IllegalArgumentException("[ERROR] 코치는 최소 2명 이상 입력해야 합니다.");
        }

        if (words.length > 5) {
            throw new IllegalArgumentException("[ERROR] 코치는 다섯명 이하여야 합니다.");
        }

        return Arrays.asList(words);
    }

    public List<String> parseMenu(String input) {
        String[] words = input.split(",");

        if (words.length > 2) {
            throw new IllegalArgumentException("[ERROR] 못 먹는 메뉴는 두 개 이하여야 합니다.");
        }

        return Arrays.asList(words);
    }
}
