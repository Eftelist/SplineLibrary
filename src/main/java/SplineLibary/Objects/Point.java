package SplineLibary.Objects;

import toxi.geom.ReadonlyVec3D;
import toxi.geom.Vec3D;

public class Point {

    private final double x;
    private final double y;
    private final double z;

    public Point(double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z =  z;
    }

    public ReadonlyVec3D toVec3D() {
        return new Vec3D((float)x,(float)y,(float)z);
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }
}
