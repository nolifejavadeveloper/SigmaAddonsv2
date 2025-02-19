package net.ethann.sigmaaddonsv2.feature.field;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public abstract class Field<T> {
    protected String name;
    protected String description;
    protected T value;

    public abstract void renderInputField();
    public abstract void handleInput(String input);
}
