package forms;

import java.util.ArrayList;
import java.util.List;

public class Paths {
    private List<Knots> path = new ArrayList<>();
    private int finalDuration;

    public Paths(List<Knots> path, int finalDuration) {
        this.path = path;
        this.finalDuration = finalDuration;
    }

    public List<Knots> getPath() {
        return path;
    }

    public void setPath(List<Knots> path) {
        this.path = path;
    }

    public int getFinalDuration() {
        return finalDuration;
    }

    public void setFinalDuration(int finalDuration) {
        this.finalDuration = finalDuration;
    }
}
