package SplineLibary.Objects;

import java.util.ArrayList;
import java.util.HashMap;

public class Spline3D {

    private HashMap<Integer,Point> points = new HashMap<>();
    private int index;

    public Spline3D(){}

    public void addPoint(Point point){
        this.points.put(index,point);
        this.index += 1;
    }

    public void removePoint(int id, Point point){
        this.points.remove(id);
    }

    public ArrayList<Point> generate() {
        ArrayList<Point> returnList = new ArrayList<>();
        toxi.geom.Spline3D spline3D = new toxi.geom.Spline3D();
        points.forEach((i,p) -> {
            spline3D.add(p.toVec3D());
        });
        spline3D.getDecimatedVertices(0.05f).forEach(vec3D -> {
            returnList.add(new Point(vec3D.x,vec3D.y,vec3D.z));
        });
        return returnList;
    }

}
