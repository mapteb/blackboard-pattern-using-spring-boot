package blackboard.pattern.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import blackboard.pattern.artifacts.DeltaSpeedDataBBO;
import blackboard.pattern.artifacts.FrontVehicleDataBBO;
import blackboard.pattern.service.AutoNavBlackBoard;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@RestController
@RequestMapping("/api")
public class BBAController {
	
	private final AutoNavBlackBoard bb;

	public BBAController(AutoNavBlackBoard bb) {
		this.bb = bb;
	}

	@PostMapping(value="/bbp", produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public void triggerBBProcess() {
		log.info(">> Adding BlackBoardObjects to the Blackboard");
		bb.addBlackBoardObject(new DeltaSpeedDataBBO("DeltaSpeedData", null));
		bb.addBlackBoardObject(new FrontVehicleDataBBO("FrontVehicleData", null));		
	}	
}
