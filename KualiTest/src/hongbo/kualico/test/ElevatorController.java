package hongbo.kualico.test;

import java.util.ArrayList;
import java.util.List;

public class ElevatorController {
	
	List<Elevator> elevatorList = new ArrayList<Elevator>();
	
	ElevatorDispatcher dispatcher = null;
	
	public void callElevator(int direction, int floorNum){
		dispatcher = new ElevatorDispatcher();
		
		Elevator calledElevator = dispatcher.getNearestCallableElevator(direction, floorNum);
		
		calledElevator.setMovingDirection(direction);
		calledElevator.setInMoving(true);
		calledElevator.setCalledByFloorNum(floorNum);
	}

}
