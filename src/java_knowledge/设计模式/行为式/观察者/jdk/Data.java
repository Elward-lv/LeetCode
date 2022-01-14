package java_knowledge.设计模式.行为式.观察者.jdk;

/**
 * @Author: lvyanwei
 * @Date: 2022-01-12
 */
public class Data {
    private int z;
    private int x;
    private int y;

    public Data(int x, int y, int z) {
        this.z = z;
        this.x = x;
        this.y = y;
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Data{" +
                "z=" + z +
                ", x=" + x +
                ", y=" + y +
                '}';
    }
}
