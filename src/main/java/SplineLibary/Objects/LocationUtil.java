package SplineLibary.Objects;

import org.bukkit.Location;
import org.bukkit.util.Vector;

public class LocationUtil {

    public static float getAngle(Vector point1, Vector point2) {
        double dx = point2.getX() - point1.getX();
        double dz = point2.getZ() - point1.getZ();
        float angle = (float) Math.toDegrees(Math.atan2(dz, dx)) - 90.0F;
        if (angle < 0.0F) {
            angle += 360.0F;
        }
        return angle;
    }


    public static float getPitchTo(Location from, Location to) {
        Location fromclone = from.clone();
        Location toclone = to.clone();
        fromclone.setDirection(toclone.subtract(fromclone.toVector()).toVector());
        return fromclone.getPitch();
    }

}
