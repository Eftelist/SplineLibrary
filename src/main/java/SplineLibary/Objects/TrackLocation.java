package SplineLibary.Objects;

import org.bukkit.Location;
import org.bukkit.World;

public class TrackLocation {

    private final double x;
    private final double y;
    private final double z;

    private double pitch,yaw,roll;

    public TrackLocation(double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public TrackLocation(Point point){
        this.x = point.getX();
        this.y = point.getY();
        this.z = point.getZ();
    }

    public Location getLocation(World world){
        return new Location(world,x,y,z,(float)yaw,(float)pitch);
    }

    public void setPitch(double pitch) {
        this.pitch = pitch;
    }

    public void setYaw(double yaw) {
        this.yaw = yaw;
    }

    public void setRoll(double roll) {
        this.roll = roll;
    }

    public double getYaw() {
        return yaw;
    }

    public double getRoll() {
        return roll;
    }

    public double getPitch() {
        return pitch;
    }

    public double getZ() {
        return z;
    }

    public double getY() {
        return y;
    }

    public double getX() {
        return x;
    }
}
