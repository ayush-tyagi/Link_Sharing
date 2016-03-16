package enums


enum Active {
    ACTIVE(true), IN_ACTIVE(false)

    public final boolean type

    public Active(boolean type) {
        this.type = type
    }

    Collection<Active> getValues() {
        return [ACTIVE, IN_ACTIVE]
    }
}