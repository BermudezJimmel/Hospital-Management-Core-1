package Notifications;

/*
 * DS Desktop Notify
 * v0.1
 * 
 * Intended, but not guarantieed, to show small notifications in your Desktop.
 */

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 * Main class of DS Desktop Notify. Use it to create and show notifications on
 * the Desktop.
 * @version 0.5
 * @author  DragShot
 */

public class DesktopNotify {
    public static final int DEFAULT=0;
    public static final int INFORMATION=1;
    public static final int WARNING=2;
    public static final int ERROR=3;
    public static final int HELP=4;
    public static final int TIP=5;
    public static final int INPUT_REQUEST=6;
    public static final int SUCCESS=7;
    public static final int FAIL=8;
    
    public static final Image[] defaultIcons;
    
    static{
        defaultIcons=new Image[8];
        for(int i=0;i<defaultIcons.length;i++){
            defaultIcons[i]=new ImageIcon(DesktopNotify.class.getResource("/Notifications/img/"+(i+1)+".png")).getImage();
        }
    }
    
    /**
     * Creates and shows a new notification. If there isn't an instance of the
     * DesktopNotifyDriver thread running, it will be created and started to
     * show your notification window.
     * 
     * A default icon will be used, depending of the type, unless it is DEFAULT.
     * A DEFAULT type notification does not bring an icon by default, no matter
     * how ironic this sounds. Notifications created from this method will stay
     * on screen until the user clicks it. No actions can be specified from this
     * method.
     * 
     * @param title         The title, if any.
     * @param message       The message, if any.
     * @param type          An int that denotes a valid message type. Invalid
     *                      values will be treated as DEFAULT.
     */
    public static void showDesktopMessage(String title, String message, int type){
        showDesktopMessage(title, message, type, null, null, 0);
    }
    
    /**
     * Creates and shows a new notification. If there isn't an instance of the
     * DesktopNotifyDriver thread running, it will be created and started to
     * show your notification window.
     * 
     * A default icon will be used, depending of the type, unless it is DEFAULT.
     * A DEFAULT type notification does not bring an icon by default, no matter
     * how ironic this sounds. Notifications created from this method will stay
     * on screen until the user clicks it, firing the action specified (if any).
     * 
     * @param title         The title, if any.
     * @param message       The message, if any.
     * @param type          An int that denotes a valid message type. Invalid
     *                      values will be treated as DEFAULT.
     * @param action        An ActionListener with the action to execute when
     *                      the user clicks the notification.
     */
    public static void showDesktopMessage(String title, String message, int type, ActionListener action){
        showDesktopMessage(title, message, type, null, action, 0);
    }
    
    /**
     * Creates and shows a new notification. If there isn't an instance of the
     * DesktopNotifyDriver thread running, it will be created and started to
     * show your notification window.
     * 
     * A default icon will be used, depending of the type, unless it is DEFAULT.
     * A DEFAULT type notification does not bring an icon by default, no matter
     * how ironic this sounds. No actions can be specified from this method.
     * 
     * @param title         The title, if any.
     * @param message       The message, if any.
     * @param type          An int that denotes a valid message type. Invalid
     *                      values will be treated as DEFAULT.
     * @param maxTimeMillis The maximum time in milliseconds that this
     *                      notification will stay on the screen. If set to 0,
     *                      the user will have to close it manually by clicking
     *                      it.
     */
    public static void showDesktopMessage(String title, String message, int type, long maxTimeMillis){
        showDesktopMessage(title, message, type, null, null, maxTimeMillis);
    }
    
    /**
     * Creates and shows a new notification. If there isn't an instance of the
     * DesktopNotifyDriver thread running, it will be created and started to
     * show your notification window.
     * 
     * A default icon will be used, depending of the type, unless it is DEFAULT.
     * A DEFAULT type notification does not bring an icon by default, no matter
     * how ironic this sounds.
     * 
     * @param title         The title, if any.
     * @param message       The message, if any.
     * @param type          An int that denotes a valid message type. Invalid
     *                      values will be treated as DEFAULT.
     * @param maxTimeMillis The maximum time in milliseconds that this
     *                      notification will stay on the screen. If set to 0,
     *                      the user will have to close it manually by clicking
     *                      it. Such value recommended if you want to add an
     *                      action for it.
     * @param action        An ActionListener with the action to execute when
     *                      the user clicks the notification.
     */
    public static void showDesktopMessage(String title, String message, int type, long maxTimeMillis, ActionListener action){
        showDesktopMessage(title, message, type, null, action, maxTimeMillis);
    }
    
    /**
     * Creates and shows a new notification. If there isn't an instance of the
     * DesktopNotifyDriver thread running, it will be created and started to
     * show your notification window.
     * 
     * @param title         The title, if any.
     * @param message       The message, if any.
     * @param type          An int that denotes a valid message type. Invalid
     *                      values will be treated as DEFAULT.
     * @param icon          A custom Image to use instead of the default icon
     *                      assigned by type.
     * @param maxTimeMillis The maximum time in milliseconds that this
     *                      notification will stay on the screen. If set to 0,
     *                      the user will have to close it manually by clicking
     *                      it. Such value recommended if you want to add an
     *                      action for it.
     * @param action        An ActionListener with the action to execute when
     *                      the user clicks the notification.
     */
    public static void showDesktopMessage(String title, String message, int type, Image icon, ActionListener action, long maxTimeMillis){
        DesktopNotify pane=new DesktopNotify(title, message, type, icon);
        pane.setTimeout(maxTimeMillis);
        pane.setAction(action);
        pane.show();
    }
    
    String title;
    String message;
    Image icon;
    int type;
    
    String[] tlts=new String[0];
    String[] msgs=new String[0];
    
    int w=0;
    int h=0;
    boolean visible=false;
    
    int highl= 0;
    
    long popupStart = 0L;
    long timeOut = 8000L;
    
    ActionListener action;
    
    protected DesktopNotify(String title, String message, int type, Image icon){
        this.title=title==null? "":title;
        this.message=message==null? "":message;
        this.type=type;
        this.icon=icon;
    }

    public ActionListener getAction() {
        return action;
    }

    public void setAction(ActionListener action) {
        this.action = action;
    }
    
    public void setTimeout(long millis){
        timeOut=millis<0? 0:millis;
    }
    
    protected long expTime(){
        return timeOut==0? Long.MAX_VALUE:popupStart+timeOut;
    }
    
    public void show(){
        DesktopNotifyDriver.postPane(this);
        popupStart=System.currentTimeMillis();
    }
    
    public void setWidth(int w){
        this.w=w;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
    
    public void render(int x, int y, boolean hover, Graphics2D rd, long l){
        long i=l-popupStart;
        if(i>500) i=expTime()-l;
        if(i<0) i=0;
        if(i>500) i=-1;
        rd.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        AffineTransform trans=rd.getTransform();
        rd.translate(x, y);
        if(i!=-1){
            double d=i/500.0;
//            System.out.println(d);
            rd.translate(w/2-((w/2)*d), h/2-((h/2)*d));
            rd.scale(d, d);
            rd.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,(float)d));
        }
        rd.setPaint(new GradientPaint(0, (title.isEmpty()? 0:25), /*hover? new Color(50,57,65):*/new Color(50,50,50),
                0, h, new Color(50+(int)(9*highl/20.0F), 50+(int)(25*highl/20.0F), 50+(int)(41*highl/20.0F), 120+(int)(135*highl/20.0F))/*hover? new Color(0x3B4B5B):new Color(50,50,50,120)*/, false));
        if(hover && highl<20) highl++;
        if(!hover && highl>0) highl--;
        rd.fillRect(0, 0, w, h);
        rd.setPaint(null);
        rd.setColor(Color.BLACK);
        rd.drawRect(0, 0, w-1, h-1);
        if(i==-1){
            rd.setColor(Color.WHITE);
            if(!title.isEmpty()){
                rd.setFont(new Font("Verdana",Font.BOLD,14));
                for(int j=0;j<tlts.length;j++){
                    rd.drawString(tlts[j], 5+((icon==null && type==0)? 0:38), 20+(15*j));
                }
            }
            if(!message.isEmpty()){
                rd.setFont(new Font("Verdana",Font.PLAIN,12));
                for(int j=0;j<msgs.length;j++){
                    rd.drawString(msgs[j], 6+((icon==null && type==0)? 0:38), 21+(15*tlts.length)+(15*j));
                }
            }
        }
//        if(expTime()==Long.MAX_VALUE){
//            rd.setFont(new Font("Verdana",Font.BOLD,14));
//            rd.setColor(new Color(120,120,120));
//            rd.drawString("X", w-16, 18);
//        }
        if(icon!=null){
            rd.drawImage(icon, 6, (h/2)-15, 32, 32, null);
        }else if(type!=0){
            rd.drawImage(defaultIcons[type-1], 6, (h/2)-15, null);
        }
        rd.setTransform(trans);
        rd.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER));
    }
    
    protected void sortMessage(){
        if(!title.isEmpty()) tlts=splitLines(title, new Font("Verdana",Font.BOLD,14));
        if(!message.isEmpty()) msgs=splitLines(message, new Font("Verdana",Font.PLAIN,12));
        h=15+(15*tlts.length)+(15*msgs.length);
    }
    
    private String[] splitLines(String in, Font font){
        String[] out;
        ArrayList<String> list=new ArrayList();
        String[] strs=in.split(" ");
        StringBuilder builder=new StringBuilder();
        FontMetrics ftm = DesktopNotifyDriver.getFontMetrics(font);
        for(String str:strs){
//            System.out.println(str);
//            System.out.println(ftm.stringWidth(builder.toString())+"+"+ftm.stringWidth(str)+"<"+(w-10));
            if(ftm.stringWidth(builder.toString())+ftm.stringWidth(str)<(w-12-((icon==null && type==0)? 0:38))){
                builder.append(str).append(" ");
            }else{
                list.add(builder.toString());
                builder=new StringBuilder().append(str).append(" ");
            }
        }
        list.add(builder.toString());
        out=new String[list.size()];
        out=list.toArray(out);
        return out;
    }
}