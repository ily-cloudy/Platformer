package entities;


// abtract means that only subclasses/extensions of this class can be used construct objects
public abstract class Entity {
    
    // protected: subclasses can also access, whereas private vars can only be accessed in this one
    protected float x, y;
    public Entity(float x, float y) {
        this.x = x;
        this.y = y;
    }


}
