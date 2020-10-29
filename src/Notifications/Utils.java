package Notifications;

/*
 * DS Desktop Notify
 * v0.1
 * 
 * Intended, but not guarantieed, to show small notifications in your Desktop.
 */

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;


public class Utils {
    static final int WINDOWS=0;
    static final int WINDOWS_XP=1;
    static final int WINDOWS_VISTA=2;
    static final int WINDOWS_7=3;
    static final int WINDOWS_8=4;
    static final int LINUX=10;
    static final int UNIX=11;
    static final int OTHER=20;
    
    static int operativeSystem;
    static Rectangle screen;
    
    static{
        String str=System.getProperty("os.name").toLowerCase();
        if(str.contains("windows")){
            if(str.contains("xp")){
                operativeSystem=WINDOWS_XP;
            }else if(str.contains("vista")){
                operativeSystem=WINDOWS_VISTA;
            }else if(str.contains("7")){
                operativeSystem=WINDOWS_7;
            }else if(str.contains("8")){
                operativeSystem=WINDOWS_8;
            }else{
                operativeSystem=WINDOWS;
            }
        }else if(str.contains("linux")){
            operativeSystem=LINUX;
        }else if(str.contains("unix")){
            operativeSystem=UNIX;
        }else{
            operativeSystem=OTHER;
        }
    }
    
    public static int getOperativeSystem(){
        return operativeSystem;
    }
    
    /**
     * Checks the area available in the desktop, excluding the taskbar.
     * @return A Rectangle with the usable area for the notifications.
     */
    public static Rectangle getScreenSize(){
        if(screen==null){
            if(Utils.getOperativeSystem()<10){//A little hack for Windows
                Frame frame=new Frame();
                GraphicsConfiguration config = frame.getGraphicsConfiguration();
                screen = sun.java2d.SunGraphicsEnvironment.getUsableBounds(config.getDevice());
                frame.dispose();
            }else{ //For other systems, do it the traditional way
                Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
                screen=new Rectangle(0, 0, size.width, size.height);
            }
            System.out.println("Current workspace: "+screen.width+"x"+screen.height+"px");
        }
        return screen;
    }
    
    /**
     * Checks if the translucency effect is supported. Java 6 does not support
     * this. Only Java 7 and higher might do, depending of the Graohics
     * Environment and OS.
     * @return 'true' if translucency is supported, 'false' otherwise.
     */
    public static boolean isTranslucencySupported(){
        boolean nativeTrans;
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice gd = ge.getDefaultScreenDevice();
        if(System.getProperty("java.version").indexOf("1.6")!=-1){
            System.err.println("Per-pixel translucency is currently not supported.\nPlease upgrade your platform to Java7 to support this feature.");
            nativeTrans = false;
        }else{
            if (!gd.isWindowTranslucencySupported(GraphicsDevice.WindowTranslucency.PERPIXEL_TRANSLUCENT)) {
                System.err.println("Error while starting: Per-pixel translucency is not supported.");
                nativeTrans = false;
            }else nativeTrans = true;
        }
//        System.out.println(nativeTrans);
        return nativeTrans;
    }
    
    /**
     * Creates a background for a fake effect of translucency.
     * @return A BufferedImage with the area behind the JDialog.
     */
    public static Image getBackgroundCap(Rectangle bounds){
        Image bg;
        try{
            Robot robot = new Robot();
            bg = robot.createScreenCapture(bounds);
        }catch(AWTException ex){
            bg=null;
        }
        return bg;
    }
}