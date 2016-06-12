package hongbo.kualico.test;

public class ElevatorImpl implements Elevator {
	private boolean inMoving;
	private int movingDirection;
	private int lastStoppedFloor;
	private int toFloorNumber;
	
	public ElevatorImpl(){
		this.lastStoppedFloor = 1;
		this.movingDirection = -1;
		this.inMoving = false;
	}
	
	@Override
	public boolean isMoving() {
		return this.inMoving;
	}

	@Override
	public int getFloorOn() {
		if(!this.inMoving){
			return this.getToFloorNumber();
		}else{
			return 0;
		}
	}

	@Override
	public void reportFloorNumber() {
		if(getFloorOn() != 0){ //otherwise the elevator is in motion
			inMoving =false;
			System.out.println("Reached Floor: " + this.getToFloorNumber());
		}
		
	}

	@Override
	public int getLastStoppedFloorNumber() {
		if(this.lastStoppedFloor < Elevator.MIN_FLOOR_NUMBER || this.lastStoppedFloor > Elevator.MAX_FLOOR_NUMBER){
			return this.calledByFloorNumber();
		}else{
			return this.lastStoppedFloor;
		}
	}

	@Override
	public boolean isCallable() {
		if(this.getLastStoppedFloorNumber() > Elevator.MIN_FLOOR_NUMBER && this.getLastStoppedFloorNumber() <= Elevator.MAX_FLOOR_NUMBER){
			return true;
		}else{
			return false;
		}
		
	}

	@Override
	public int calledByFloorNumber() {
		// TODO Auto-generated method stub
		return this.lastStoppedFloor;
	}

	public void setCalledByFloorNum(int callingFloor){
		this.lastStoppedFloor = callingFloor;
	}

	@Override
	public int getMovingDirection() {
		return this.movingDirection;
	}
	
	public void setMovingDirection(int dir){
		this.movingDirection =dir;
	}

	@Override
	public void setInMoving(boolean mv) {
		this.inMoving = true;
		
	}

	@Override
	public void setLastStoppedFloorNumber(int flr) {
		this.lastStoppedFloor = flr;
	}

	@Override
	public int getToFloorNumber() {
		return this.toFloorNumber;
	}

	@Override
	public void setToFloorNumber(int toflr) {
		this.toFloorNumber = toflr;
		
	}
}
