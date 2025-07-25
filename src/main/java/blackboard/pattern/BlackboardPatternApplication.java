package blackboard.pattern;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import lombok.extern.slf4j.Slf4j;
/**
 * StartupApplicationListener adds a list of KnowledgeSources to the AutoNavBBController
 * BBAController api /bbp triggers the blackboard process
 * BBAController addds one or more BlackBoardObjects to the BlackBoard
 * BlackBoard publishes the received objects as events 
 * BBAController listens to the events
 * When BBAController receives the BlackBoardObject from the event it assigns it to an
 * eligible KnowledgeSource and spawns a worker thread
 * The KnowledgeSource acts on the BlackBoardObject and then updates the BlackBoard
 * @author - Nalla Senthilnathan https://github.com/mapteb/blackboard-pattern-using-spring-boot
 */
@Slf4j
@EnableAsync
@EnableTransactionManagement 
@SpringBootApplication
public class BlackboardPatternApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlackboardPatternApplication.class, args);
	}
}
