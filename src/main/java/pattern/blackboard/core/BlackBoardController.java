package pattern.blackboard.core;

import java.util.List;

public interface BlackBoardController {
    public void setKnowledgeSources(List<KnowledgeSource> ksources);
    public KnowledgeSource selectligibleKnowledgeSource(String item);
}
