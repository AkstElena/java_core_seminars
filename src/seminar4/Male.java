package seminar4;

public enum Male {

    MALE("мальчик"), FEMALE("девочка"); // это экземпляры анонимных классов класса Male. Он сам создает их внутри
    private String russianMaleTitle;

    public String getRussianMaleTitle() {
        return russianMaleTitle;
    }

    Male(String russianMaleTitle) {
        this.russianMaleTitle = russianMaleTitle;
    }
}
