package SplineLibary.Objects;

import org.bukkit.World;

import javax.sound.midi.Track;
import java.util.ArrayList;
import java.util.HashMap;

public class Spline3D {

    private final World world;
    private HashMap<Integer,Point> points = new HashMap<>();
    private int index;

    public Spline3D(World world){
        this.world = world;
    }

    public void addPoint(Point point){
        this.points.put(index,point);
        this.index += 1;
    }

    public void removePoint(int id, Point point){
        this.points.remove(id);
    }

    public ArrayList<TrackLocation> generate() {
        ArrayList<TrackLocation> returnList = new ArrayList<TrackLocation>();
        ArrayList<Point> pyr = new ArrayList<>();
        toxi.geom.Spline3D spline3D = new toxi.geom.Spline3D();
        points.forEach((i, p) -> {
            spline3D.add(p.toVec3D());
        });
        spline3D.getDecimatedVertices(0.1f).forEach(vec3D -> {
            returnList.add(new TrackLocation(vec3D.x, vec3D.y, vec3D.z));
        });
        for (TrackLocation loc : returnList) {
            if (returnList.indexOf(loc) + 1 < returnList.size()) {
                loc.setYaw(LocationUtil.getAngle(loc.getLocation(world).toVector(), ((TrackLocation) returnList.get(returnList.indexOf(loc) + 1)).getLocation(world).toVector()));
                loc.setPitch(LocationUtil.getPitchTo(loc.getLocation(world), ((TrackLocation) returnList.get(returnList.indexOf(loc) + 1)).getLocation(world)));
            }
        }
        return returnList;
    }



    public ArrayList<Point> generateP() {
        ArrayList<Point> returnList = new ArrayList<Point>();
        ArrayList<Point> pyr = new ArrayList<>();
        toxi.geom.Spline3D spline3D = new toxi.geom.Spline3D();
        points.forEach((i,p) -> {
            spline3D.add(p.toVec3D());
        });
        spline3D.getDecimatedVertices(0.1f).forEach(vec3D -> {
            returnList.add(new Point(vec3D.x,vec3D.y,vec3D.z));
        });
        return returnList;
    }

}
