package Notifications;

/*
 * DS Desktop Notify
 * v0.1
 * 
 * Intended, but not guarantieed, to show small notifications in your Desktop.
 */

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;

/**
 * Keeps track of the notifications being displayed.
 * @author DragShot
 */
public class DesktopNotifyDriver {
    static ArrayList<DesktopNotify> windows=new ArrayList();
    static DesktopLayoutFrame frame=new DesktopLayoutFrame();
    static volatile Thread tredo;
    
    /**
     * Invoked by DesktopNotify, adds a notification to the queue. Notifications
     * are shown only when there is room for them to fit in the screen.
     * 
     * @param window a DesktopNtify object
     */
    protected static void postPane(DesktopNotify window){
        frame.setVisible(true);
        window.setWidth(300);
        window.sortMessage();
        window.setVisible(true);
        windows.add(window);
        sparkControlThread();
    }
    
    /**
     * Starts the thread used to show and control the notifications, if
     * necessary.
     */
    private static void sparkControlThread(){
        if(tredo==null){
            tredo=new Thread(new Runnable(){@Override public void run(){
                System.out.println("Desktop Notify Driver Thread started.");
                frame.finished=false;
                while(!frame.finished){
                    frame.repaint();
                    try{
                        Thread.sleep(20);//FPS> 10:Super-high, 20: High, 40: Normal, 80: Low
                    }catch(InterruptedException ex){}
                }
                frame.dispose();
                tredo=null;
                System.out.println("Desktop Notify Driver Thread finished.");
            }},"");
            tredo.start();
        }
    }

    static FontMetrics getFontMetrics(Font font) {
        return frame.getGraphics().getFontMetrics(font);
    }
    /**
     * An undecorated JDialog used to show all the notify windows.
     */
    static class DesktopLayoutFrame extends JDialog{
        Image bg;
        boolean nativeTrans;
        
        boolean finished=true;
        boolean clicked=false;

        DesktopLayoutFrame(){
            super((JFrame)null,"DesktopLayoutFrame");
            setUndecorated(true);
            nativeTrans=Utils.isTranslucencySupported();
            setBackground(new Color(0,0,0,nativeTrans? 0:255));
            setContentPane(new JComponent(){
                @Override
                public void paintComponent(Graphics g){
                    render((Graphics2D)g);
                }
            });
            addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent evt){
                    clicked=true;
                }
            });
            Rectangle screenSize = Utils.getScreenSize();
            setBounds(screenSize.x+screenSize.width-305, screenSize.y, 300, screenSize.height-5);
            setFocusableWindowState(false);
            setAlwaysOnTop(true);
            setVisible(true);
            System.out.println("Desktop Notify Frame deployed.");
        }
        
        @Override
        public void setVisible(boolean visible){
            boolean bool=isVisible();
            super.setVisible(visible);
            if(visible && !bool && !nativeTrans) bg=Utils.getBackgroundCap(getBounds());
        }
        
        /**
         * Paints the window contents.
         * @param rd a graphics2D object received from the original paint event.
         */
        void render(Graphics2D rd){
            finished=false;
            int x=0,y=getHeight();
            long l=System.currentTimeMillis();
            if(windows.isEmpty()) finished=true;
            int cur=Cursor.DEFAULT_CURSOR;
            if(!nativeTrans) rd.drawImage(bg, 0, 0, this);
            for(int i=0;i<windows.size();i++){
                DesktopNotify window=windows.get(i);
                if(window.isVisible()){
                    y-=window.h;
                    if(y>0){
                        boolean hover=false;
                        Point p=getMousePosition();
                        if(p!=null){
                            if(p.y>y && p.y<y+window.h){
                                hover=true;
                                if(window.getAction()!=null) cur=Cursor.HAND_CURSOR;
                                if(clicked){
                                    if(window.getAction()!=null){
                                        final DesktopNotify w=window;
                                        final long lf=l;
                                        java.awt.EventQueue.invokeLater(new Runnable(){@Override public void run(){
                                            w.getAction().actionPerformed(new ActionEvent(w, ActionEvent.ACTION_PERFORMED, "fireAction", lf, 0));
                                        }});
                                    }if(window.expTime()==Long.MAX_VALUE){
                                        window.timeOut=l-window.popupStart+500;
                                    }
                                }
                            }
                        }
                        window.render(x,y,hover,rd,l);
                    }else window.popupStart=l;
                    if(l>window.expTime()){
                        window.setVisible(false);
                        windows.remove(window); 
                        i--;
                    }
                    y-=5;
                }
            }
            clicked=false;
            setCursor(new Cursor(cur));
        }
    }
}