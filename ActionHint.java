package New1;

public enum ActionHint {
    FORWARD("gehen", "w"),
    LEFT("links gehen", "a"),
    RIGHT("rechts gehen", "d"),
    BACK("umdrehen", "s"),
    EXIT("beenden", "x");

    public final String text;
    public final String key;

    ActionHint(String text, String key) {
        this.text = text;
        this.key = key;
    }
}
