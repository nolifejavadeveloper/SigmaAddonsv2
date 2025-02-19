package net.ethann.sigmaaddonsv2.feature.field.impl;

import net.ethann.sigmaaddonsv2.feature.field.Field;

public class EnumField extends Field<Enum<?>> {

    public EnumField(String name, String description, Enum<?> value) {
        super(name, description, value);
    }

    @Override
    public void renderInputField() {

    }

    @Override
    public void handleInput(String input) {

    }
}
