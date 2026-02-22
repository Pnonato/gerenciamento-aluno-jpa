package model;

public enum Situation {
    APPROVED("Aprovado"),
    FAILED("Reprovado"),
    RECOVERY("Recuperação");

    private final String description;

    Situation(String description) {
        this.description = description;
    }
    public String getDescription(){
        return description;
    }

}
