package pattern.blackboard;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import pattern.blackboard.core.DeltaSpeedDataKS;
import pattern.blackboard.core.FrontVehicleDataKS;
import pattern.blackboard.core.KnowledgeSource;
import pattern.blackboard.service.AutoNavBBController;

@Slf4j
@Component
public class StartupApplicationListener implements ApplicationListener<ApplicationReadyEvent> {

    private final AutoNavBBController bbop;

    public StartupApplicationListener(AutoNavBBController bbop) {
        this.bbop = bbop;
    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        List<KnowledgeSource> ksources = new ArrayList<>();
        log.info(">> Configuring AutoNavBBController with KnowledgeSources");
        ksources.add(new FrontVehicleDataKS("FrontVehicleData"));
        ksources.add(new DeltaSpeedDataKS("DeltaSpeedData"));
        bbop.setKnowledgeSources(ksources);
    }

}
