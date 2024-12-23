package blackboard.pattern.artifacts;

import org.springframework.scheduling.annotation.Async;

import lombok.extern.slf4j.Slf4j;

/**
 * The DeltaSpeedDataKS is an implementation of {@link AbstractKnowledgeSource}
 * This knowledge source operates on blackboard objects of the type DeltaSpeedDataBBO
 * It transforms the DeltaSpeedDataBBO into the BrakePedalBBO and adds it to the blackboard.
 * Also sets the isReady flag to true to indicate that a decision point has been reached
 * 
 * The process method in this class is just printing a message for now
 * 
 * @author Nalla Senthilnathan http://github.com/mapteb
 *
 */
@Slf4j
public class DeltaSpeedDataKS implements KnowledgeSource {

     @Async
     public void process(BlackBoardObject bbo) {          
          log.info("==>> DeltaSpeedDataKS worker spawned {}", bbo.getClass());
     }
}
