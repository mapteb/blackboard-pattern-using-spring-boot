package pattern.blackboard.core;

/**
 * The BlackBoardObject is the basic unit of data that is added to the BlackBoard
 * The knowledge sources can optionally set the isReady boolean flag of the
 * implementing classes. When the controller sees a true value for this flag 
 * it can execute a decision step
 * 
 * @author Nalla Senthilnathan http://github.com/mapteb
 *
 */
public interface BlackBoardObject {
     public String getName();
     public void setName(String name);
     public String getResult();
     public void setResult(String result);
}
