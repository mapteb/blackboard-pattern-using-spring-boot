package blackboard.pattern;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import blackboard.pattern.service.AutoNavBBOProcessor;
import blackboard.pattern.service.AutoNavBlackBoard;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@EnableAsync
@EnableTransactionManagement 
@SpringBootApplication
public class BlackboardPatternApplication {

	private final AutoNavBlackBoard bb;
	private final AutoNavBBOProcessor bboProcessor;

	public BlackboardPatternApplication(AutoNavBlackBoard bb, AutoNavBBOProcessor bboProcessor) {
		log.info(">> Initialize the BB and subscribe the processor");
		this.bb = bb;
		this.bboProcessor = bboProcessor;
		bb.subscribe(bboProcessor);
	}

	public static void main(String[] args) {
		SpringApplication.run(BlackboardPatternApplication.class, args);
	}
}
