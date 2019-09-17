package models.question;

public enum EQuestionType {
    SINGLE,
    TEXT,
    MULTI;

    public static EQuestionType instanceOf(String type) {
        if(type == null) {
            return null;
        }

        for(EQuestionType item : EQuestionType.values()) {
            if(item.name().equals(type.toUpperCase())) {
                return item;
            }
        }

        return null;
    }

}
