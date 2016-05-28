package olvin.hh;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class myJFrame extends JFrame implements MouseMotionListener, MouseListener {
    private int startDragX, startDragY;
    private boolean resizing;
    private int resizeField;

    public myJFrame(String windowText) {
        super(windowText);
        addMouseMotionListener(this);
        addMouseListener(this);
        resizeField = 15;
    }

    public void paint(Graphics g) {
        g.clearRect(0, 0, getWidth(), getHeight());
        g.setColor(new Color(255, 255, 255));

        int scaleShort = 2, scaleLong = 8, scaleBigInterval = 50, scaleSmallInterval = 10;

        // рисуем линейку

        // рисуем вертикальные линии
        int colWidth = Math.round(getWidth() / 12);
        int padding = 10;
        for (int i = padding; i < getWidth() - padding; i++) {
            // рисуем шкалу
            if (i % scaleSmallInterval == 0) {
                int lineLength = scaleShort;
                if (i % scaleBigInterval == 0) {
                    lineLength = scaleLong;
                }
                g.drawLine(i, 0, i, lineLength);
                g.drawLine(i, getHeight() - lineLength, i, getHeight());
            }
            // рисуем 12 колонок
            if ((i % colWidth) == 0) {
                g.drawLine(i, 0, i, getHeight());
            }
        }
        // рисуем горизонтальные линии
        int rowHeight = Math.round(getHeight() / 12);
        for (int i = padding; i < getHeight() - padding; i++) {
            // рисуем шкалу
            if (i % scaleSmallInterval == 0) {
                int lineLength = scaleShort;
                if (i % scaleBigInterval == 0) {
                    lineLength = scaleLong;
                }
                g.drawLine(0, i, lineLength, i);
                g.drawLine(getWidth() - lineLength, i, getWidth(), i);
            }
            // рисуем 12 рядов
            if ((i % rowHeight) == 0) {
                g.drawLine(0, i, getWidth(), i);
            }
        }

        // рисуем маркер для масштабирования
        g.fillRect(getWidth() - resizeField, getHeight() - 3, resizeField, 3);
        g.fillRect(getWidth() - 3, getHeight() - resizeField, 3, resizeField);

        // рисуем текст - размеры окна
        Point loc = getLocation();
        g.drawString("X: " + (int)loc.getX(), 20, 30);
        g.drawString("Y: " + (int)loc.getY(), 20, 50);
        g.drawString("Ширина: " + getWidth(), 20, 70);
        g.drawString("Высота: " + getHeight(), 20, 90);
    }

    public void mousePressed(MouseEvent e) {
        MouseHelper mouse = new MouseHelper();
        if (e.getButton() == 1) {
            startDragX = mouse.getX();
            startDragY = mouse.getY();
        }
        if ((e.getX() > getWidth() - resizeField) && (e.getY() > getHeight() - resizeField)) {
            resizing = true;
        }
    }

    public void mouseReleased(MouseEvent e) {
        resizing = false;
    }

    public void mouseDragged(MouseEvent e) {
        int newX, newY;
        MouseHelper mouse = new MouseHelper();
        newX = mouse.getX() - startDragX;
        startDragX = mouse.getX();
        newY = mouse.getY() - startDragY;
        startDragY = mouse.getY();
        if (resizing) {
            Dimension oldSize = getSize();
            setSize(oldSize.width + newX, oldSize.height + newY);
        } else {
            Point oldLoc = getLocation();
            setLocation((int)oldLoc.getX() + newX, (int)oldLoc.getY() + newY);
        }

        repaint();
    }

    public void mouseExited(MouseEvent e) {

    }

    public void mouseEntered(MouseEvent e) {

    }

    public void mouseClicked(MouseEvent e) {

    }

    public void mouseMoved(MouseEvent e) {

    }
}
