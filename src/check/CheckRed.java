/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package check;

import javax.swing.ImageIcon;
import javax.swing.JCheckBox;

/**
 *
 * @author RojeruSan
 */
public class CheckRed extends JCheckBox{

    public CheckRed() {
        this.setIcon(new ImageIcon(getClass().getResource("/Images/uncheck-red.png")));
        this.setSelectedIcon(new ImageIcon(getClass().getResource("/Images/check-red.png")));
        this.setOpaque(false);
    }

}
