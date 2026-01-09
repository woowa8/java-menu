package menu.domain;

public enum Category {
    NULL("없음"),
    JAPANESE("일식"),
    KOREAN("한식"),
    CHINESE("중식"),
    ASIAN("아시안"),
    WESTERN("양식");

    private final String description;

    Category(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    // 숫자 (인덱스)를 내보내기 위함이다.
    public static Category getOrdinal(int ind) {
        return Category.values()[ind];
    }
}
