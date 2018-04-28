package SplineLibary.Objects;

import org.apache.commons.io.FileUtils;
import org.bukkit.World;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Track {

    ArrayList<TrackLocation> locations = new ArrayList<>();

    public Track(World world, String filename){
        Spline3D spline3D = new Spline3D(world);
        File f = new File("/plugins/SplineLibrary/" + filename + ".track");
        if(!f.exists()){
            try {
                f.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        YamlConfiguration configuration = new YamlConfiguration();
        try {
            configuration.load(f);
            List<String> vectors = configuration.getStringList("points");
            for(String vector : vectors){
                spline3D.addPoint(parse(vector));
            }
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
        locations = spline3D.generate();
    }

    public ArrayList<TrackLocation> getLocations() {
        return locations;
    }

    private Point parse(String vector) {
        String[] splitted = vector.split(" ");
        return new Point(Double.parseDouble(splitted[1]), Double.parseDouble(splitted[2]), Double.parseDouble(splitted[3]));
    }
}
