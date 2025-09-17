package pattern.blackboard.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import pattern.blackboard.core.DeltaSpeedDataBBO;
import pattern.blackboard.core.FrontVehicleDataBBO;
import pattern.blackboard.service.AutoNavBlackBoard;


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
