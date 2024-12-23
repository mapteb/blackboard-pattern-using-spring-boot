package blackboard.pattern.service;

import java.util.concurrent.SubmissionPublisher;

import org.springframework.stereotype.Service;

import blackboard.pattern.artifacts.BlackBoardObject;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AutoNavBlackBoard extends SubmissionPublisher<BlackBoardObject> { 

     // private final SubmissionPublisher<BlackBoardObject> publisher;
     private final AutoNavBBOProcessor bboProcessor;

     public AutoNavBlackBoard(AutoNavBBOProcessor bboProcessor) {
          this.bboProcessor = bboProcessor;
          // this.publisher = new SubmissionPublisher<>();
          // publisher.subscribe(bboProcessor);
     }

     public void addBlackBoardObject(BlackBoardObject bbo) {
          log.info(">> bbo submitted to processor: {}", bbo.getClass().getTypeName());
          // publisher.submit(bbo);
     }
}
