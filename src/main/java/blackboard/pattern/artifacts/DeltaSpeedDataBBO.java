package blackboard.pattern.artifacts;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DeltaSpeedDataBBO implements BlackBoardObject {
    private String name;
    private String result;
}
