package org.vsapry.Model;

import javax.swing.*;

public class guiUtils {

    public boolean validateInput(int numBits, int intInputForMintermValue) {
        int maxAllowed = (int) (Math.pow(2,numBits) - 1);

        if (intInputForMintermValue < 0 || intInputForMintermValue > maxAllowed) {
            JOptionPane.showMessageDialog(
                    null,
                    String.format(
                            "Number should be within 0 to %d\nPlease press Next and give your input again",
                            maxAllowed
                    ),
                    "Error", JOptionPane.ERROR_MESSAGE
            );
            return false;
        }
        return true;
    }

}
