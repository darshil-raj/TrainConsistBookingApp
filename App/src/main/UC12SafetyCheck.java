import java.util.*;
import java.util.stream.*;

class GoodsBogie {
    String type;
    String cargo;

    public GoodsBogie(String type, String cargo) {
        this.type = type;
        this.cargo = cargo;
    }
}

public class UC12SafetyCheck {

    // Safety validation method
    public static boolean isTrainSafe(List<GoodsBogie> bogies) {
        return bogies.stream().allMatch(b ->
                !b.type.equalsIgnoreCase("Cylindrical") ||
                        b.cargo.equalsIgnoreCase("Petroleum")
        );
    }

    public static void main(String[] args) {
        List<GoodsBogie> bogies = new ArrayList<>();

        bogies.add(new GoodsBogie("Cylindrical", "Petroleum"));
        bogies.add(new GoodsBogie("Open", "Coal"));
        bogies.add(new GoodsBogie("Box", "Grain"));

        boolean result = isTrainSafe(bogies);

        if (result) {
            System.out.println("Train is SAFE");
        } else {
            System.out.println("Train is UNSAFE");
        }
    }
}