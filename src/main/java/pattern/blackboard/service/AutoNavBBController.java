package pattern.blackboard.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import pattern.blackboard.core.BlackBoard;
import pattern.blackboard.core.BlackBoardController;
import pattern.blackboard.core.BlackBoardObject;
import pattern.blackboard.core.KnowledgeSource;

/**
 * This blackboard controller gets notified when one or
 * more blackboard objects are added to the blackboard
 * 
 * @author Nalla Senthilnathan http://github.com/mapteb
 * 
 */
@Slf4j
@Service
public class AutoNavBBController implements BlackBoardController {

     private final BlackBoard blackBoard;
     private List<KnowledgeSource> ksources = new ArrayList<>();

     public AutoNavBBController(BlackBoard blackBoard) {
          this.blackBoard = blackBoard;
     }

     public void setKnowledgeSources(List<KnowledgeSource> ksources) {
          this.ksources = ksources;
     }

	@EventListener
	public void processBlackBoardEvent(BlackBoardEvent event) {
          BlackBoardObject bbo = event.getBlackBoardObject();
          log.info(">> Received BlackBoardObject: {}", bbo.getName());
          // select a KS that can act on this bbo
          KnowledgeSource ks = selectligibleKnowledgeSource(bbo.getName());
          // assign the task and launch a worker thread 
          log.info(">> Launching KnowledgeSource as a worker thread: {}", bbo.getName());
          ks.process(blackBoard, bbo);
	}

     /*
      * The eligibility criterion used in this demo is by matching the 
      * BlackBoardObject's name with the name of the KnowledgeSource
      */
     public KnowledgeSource selectligibleKnowledgeSource(String item) {
          KnowledgeSource ks = 
          ksources.stream().filter(ksource -> ksource.getName().equals(item)).findAny().get();
          return ks;
     }

}
