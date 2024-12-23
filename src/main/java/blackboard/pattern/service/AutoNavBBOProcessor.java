package blackboard.pattern.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Flow;
import java.util.concurrent.Flow.Subscription;

import org.springframework.stereotype.Service;

import blackboard.pattern.artifacts.BlackBoardObject;
import blackboard.pattern.artifacts.DeltaSpeedDataKS;
import blackboard.pattern.artifacts.FrontVehicleDataKS;
import blackboard.pattern.artifacts.KnowledgeSource;
import lombok.extern.slf4j.Slf4j;

/**
 * This blackboard controller gets notified when one or
 * more blackboard objects are added to the blackboard
 * 
 * @author Nalla Senthilnathan http://github.com/mapteb
 * 
 */
@Slf4j
@Service
public class AutoNavBBOProcessor implements Flow.Subscriber<BlackBoardObject> {

     private final List<KnowledgeSource> ksources;
     private Flow.Subscription subscription;

     public AutoNavBBOProcessor() {
          ksources = new ArrayList<>();
          ksources.add(new DeltaSpeedDataKS());
          ksources.add(new FrontVehicleDataKS());
     }

     public KnowledgeSource getKS(final String item) {
          log.info(">> ksources: {}", ksources);
          ksources.forEach(k -> log.info(">> added ks: {}", k.getClass().getTypeName()));
          KnowledgeSource ks = ksources.stream().filter(ksource -> ksource.getClass().getTypeName().startsWith(item)).findAny().get();
          return ks;
     }

     @Override
     public void onSubscribe(Subscription subscription) {
          log.info(">> Subscribed to BB");

          this.subscription = subscription;
          this.subscription.request(3);
     }

     @Override
     public void onNext(BlackBoardObject bbo) {
          // bbo received, set it to the appropriate ks and spawn a worker thread
          // set this bbo to DeltaSpeedDataKS and spawn a worker thread
          String bboItem = bbo.getClass().getTypeName().split("BBO")[0];
          log.info(">> bboProcessor received bboItem: {}", bboItem);
          KnowledgeSource ks = getKS(bboItem);
          log.info(">> spawning ks worker: {}", ks.getClass().getTypeName());
          ks.process(bbo);
     }

     @Override
     public void onError(Throwable throwable) {
          // TODO: Auto-generated method stub
     }

     @Override
     public void onComplete() {
          // TODO: Auto-generated method stub
     }
}
