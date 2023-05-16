package entities;

import java.awt.Color;
import java.awt.Graphics;

import java.awt.geom.Rectangle2D;

public abstract class Entity {
    
    protected float x, y;
    protected int width, height;
    protected Rectangle2D.Float hitbox;
    protected int ani_tick, ani_index;
    protected float air_speed;
    protected boolean airborne = false;

    public Entity(float x, float y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    protected void drawHitbox (Graphics g) {
        g.setColor(Color.MAGENTA);
        g.drawRect((int)(hitbox.x),(int) (hitbox.y), (int) hitbox.width, (int) hitbox.height);
    }

    protected void initHitbox(float width, float height) {
        hitbox = new Rectangle2D.Float(x, y, width, height);
    }
    
    public Rectangle2D.Float getHitbox() {
        return hitbox;
    }
}
