package net.ethann.sigmaaddonsv2.feature.field.impl;

import net.ethann.sigmaaddonsv2.feature.field.Field;

public class TextField extends Field<String> {

    public TextField(String name, String description, String value) {
        super(name, description, value);
    }

    @Override
    public void renderInputField() {

    }

    @Override
    public void handleInput(String input) {

    }
}
