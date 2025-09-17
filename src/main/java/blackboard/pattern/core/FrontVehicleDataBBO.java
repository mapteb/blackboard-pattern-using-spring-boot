package blackboard.pattern.core;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FrontVehicleDataBBO implements BlackBoardObject {
    private String name;
    private String result;
}
