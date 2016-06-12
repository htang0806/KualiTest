package hongbo.kualico.test;

import java.util.ArrayList;
import java.util.List;

public class ElevatorDispatcher {
	
	List<Elevator> elevatorList = new ArrayList<Elevator>();
	
	public void initialize(){
		for(int i=0; i<4; i++){
			elevatorList.add(new ElevatorImpl());
		}
	}
	
	public Elevator getNearestCallableElevator(int direction, int callingFloor){
		Elevator elevatorCalled = null;
		List<Elevator> callables = new ArrayList<Elevator>();
		for(Elevator el : elevatorList){
			if(el.isCallable() && el.getMovingDirection()==direction){
				callables.add(el);
			}
		}
		if(callables.size() > 0){
			int nearestElevator = Elevator.MAX_FLOOR_NUMBER;
			for(Elevator elev : callables){
				int dif = Math.abs(callingFloor -elev.getStoppedFloorNumber());
				if(dif < nearestElevator){
					elevatorCalled = elev;
					nearestElevator = dif;
				}
			}
		}
		
		return elevatorCalled;
	}

}
