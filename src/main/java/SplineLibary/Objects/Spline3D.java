package SplineLibary.Objects;

import java.util.ArrayList;

public class Spline3D {

    private ArrayList<Point> points = new ArrayList<>();

    public Spline3D(){}

    public void addPoint(Point point){
        if(!this.points.contains(point)){
            this.points.add(point);
        }
    }

    public void removePoint(int id, Point point){

    }

    public ArrayList<Point> generate() {
        ArrayList<Point> returnList = new ArrayList<>();
        toxi.geom.Spline3D spline3D = new toxi.geom.Spline3D();
        points.forEach((p) -> {
            spline3D.add(p.toVec3D());
        });
        spline3D.getDecimatedVertices(0.05f).forEach(vec3D -> {
            returnList.add(new Point(vec3D.x,vec3D.y,vec3D.z));
        });
        return returnList;
    }

}
