package org.vsapry.Controller;

import org.vsapry.Model.guiUtils;
import org.vsapry.View.GUI;

public class GUIController {

    private final guiUtils guiUtils = new guiUtils();

    public boolean validateInput(int bits, int value) {
        return guiUtils.validateInput(bits, value);
    }

}
