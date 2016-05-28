package olvin.hh;

import java.awt.*;

public class MouseHelper {
    private Point pos;

    public MouseHelper() {
        pos = MouseInfo.getPointerInfo().getLocation();
    }

    public int getX() {
        return (int)pos.getX();
    }

    public int getY() {
        return (int)pos.getY();
    }
}
