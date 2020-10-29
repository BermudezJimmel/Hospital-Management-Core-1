/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Module1SubModules;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;
import java.awt.Dimension;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Jimmel Bermudez
 */
public class webcam {
    public static void main(String[] args) throws IOException{

Webcam webcam = Webcam.getDefault();
WebcamPanel webcamPanel = new WebcamPanel(webcam);
webcamPanel.setMirrored(true);
for(Dimension supportedSize: webcam.getViewSizes()){
    System.out.println(supportedSize.toString());
}

webcam.setViewSize(WebcamResolution.VGA.getSize());
   }
}
