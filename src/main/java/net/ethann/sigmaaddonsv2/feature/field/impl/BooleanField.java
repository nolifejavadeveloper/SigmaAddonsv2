package net.ethann.sigmaaddonsv2.feature.field.impl;

import net.ethann.sigmaaddonsv2.feature.field.Field;

public class BooleanField extends Field<Boolean> {

    public BooleanField(String name, String description, Boolean value) {
        super(name, description, value);
    }

    @Override
    public void renderInputField() {

    }

    @Override
    public void handleInput(String input) {

    }
}
