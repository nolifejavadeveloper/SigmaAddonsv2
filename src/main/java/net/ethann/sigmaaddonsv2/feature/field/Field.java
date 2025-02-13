package net.ethann.sigmaaddonsv2.feature.field;

public abstract class Field<T> {
    protected String name;
    protected String description;
    protected T value;

    abstract void renderInputField();
    abstract void handleInput(String input);
}
