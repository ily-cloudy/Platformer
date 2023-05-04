package entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

// abtract means that only subclasses/extensions of this class can be used construct objects
public abstract class Entity {
    
    // protected: subclasses can also access, whereas private vars can only be accessed in this one
    protected float x, y;

    protected int width, height;

    protected Rectangle hitbox;

    public Entity(float x, float y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;

        initHitbox();

    }

    protected void drawHitbox (Graphics g) {
        g.setColor(Color.MAGENTA);
        g.drawRect(hitbox.x+11*4, hitbox.y+11*4, hitbox.width, hitbox.height);
    }

    private void initHitbox() {
        hitbox = new Rectangle((int)x, (int)y, width, height);
    }
    protected void updateHitbox() {
        hitbox.x = (int) x;
        hitbox.y = (int) y;
    }
    public Rectangle getHitbox() {
        return hitbox;
    }


}
