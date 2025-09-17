package blackboard.pattern.core;


/**
 * The BlackBoard notifies the BlackBoardController whenever it receives a BlackBoardObject
 * 
 * @author Nalla Senthilnathan http://github.com/mapteb
 *
 */
public interface KnowledgeSource {
     public String getName();
     public void process(BlackBoard bb, BlackBoardObject bbo);
}
