package blackboard.pattern.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import blackboard.pattern.core.BlackBoard;
import blackboard.pattern.core.BlackBoardObject;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AutoNavBlackBoard implements BlackBoard { 

     private final ApplicationEventPublisher eventPublisher;
     private final List<BlackBoardObject> bbos;

     public AutoNavBlackBoard(ApplicationEventPublisher eventPublisher) {
          this.eventPublisher = eventPublisher;
          this.bbos = Collections.synchronizedList(new ArrayList<>());
     }

     public void addBlackBoardObject(BlackBoardObject bbo) {
          BlackBoardEvent event = new BlackBoardEvent(this, bbo);
          eventPublisher.publishEvent(event);
     }

     public void updateBlackBoard(BlackBoardObject bbo) {
          bbos.stream().filter(bo -> bo.getName().equals(bbo.getName()))
               .forEach(bo -> bo.setResult(bbo.getResult()));
     }
}
