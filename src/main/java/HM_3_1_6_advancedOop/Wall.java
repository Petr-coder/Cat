package HM_3_1_6_advancedOop;

public class Wall implements OvercomeObstacle {

    private int height;

    public Wall(int height) {
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public boolean interact(Activity activity) {
        return activity.jump(this);
    }
}
