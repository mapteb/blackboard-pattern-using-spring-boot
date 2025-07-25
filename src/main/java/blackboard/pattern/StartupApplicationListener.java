package blackboard.pattern;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import blackboard.pattern.artifacts.DeltaSpeedDataKS;
import blackboard.pattern.artifacts.FrontVehicleDataKS;
import blackboard.pattern.artifacts.KnowledgeSource;
import blackboard.pattern.service.AutoNavBBController;
import lombok.extern.slf4j.Slf4j;

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
