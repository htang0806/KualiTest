package hongbo.kualico.test;

import java.util.ArrayList;
import java.util.List;

public class ElevatorController {
	
	List<Elevator> elevatorList = new ArrayList<Elevator>();
	
	ElevatorDispatcher dispatcher = null;
	
	public void callElevator(int direction, int fromFloor, int toFloor){
		dispatcher = new ElevatorDispatcher();
		dispatcher.initialize(); //initialize elevators
		Elevator calledElevator = dispatcher.getNearestCallableElevator(direction, fromFloor);
		if(calledElevator != null){
			if(toFloor < calledElevator.getLastStoppedFloorNumber()){
				calledElevator.setMovingDirection(Elevator.MOVING_DOWN);
			}else{
				calledElevator.setMovingDirection(Elevator.MOVING_UP);
			}
			calledElevator.setMovingDirection(direction);
			calledElevator.setInMoving(true);
			calledElevator.setCalledByFloorNum(fromFloor);
			calledElevator.setLastStoppedFloorNumber(fromFloor);
			calledElevator.setToFloorNumber(toFloor);
			calledElevator.report();
		}
	}
	
	public static void main(String[] args){
		ElevatorController elevatorControl = new ElevatorController();
		int direction = Integer.parseInt(args[0]);
		int fromfloor = Integer.parseInt(args[1]);
		int tofloor = Integer.parseInt(args[2]);
		elevatorControl.callElevator(direction, fromfloor, tofloor);
	}

}
