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
public class CheckBlue extends JCheckBox{

    public CheckBlue() {
        this.setIcon(new ImageIcon(getClass().getResource("/Images/uncheck-blue.png")));
        this.setSelectedIcon(new ImageIcon(getClass().getResource("/Images/check-blue.png")));
        this.setOpaque(false);
    }

}
