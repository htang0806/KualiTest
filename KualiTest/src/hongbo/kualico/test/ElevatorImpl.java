package hongbo.kualico.test;

public class ElevatorImpl implements Elevator {
	private boolean inMoving = false;
	private int lastStoppedNumber = 0;
	private int movingDirection;
	
	@Override
	public boolean isMoving() {
		if(this.getStoppedFloorNumber()==0){
			this.inMoving = true;
		}else{
			inMoving =false;
		}
		return this.inMoving;
	}

	@Override
	public int getFloorOn() {
		if(!this.inMoving){
			return this.getStoppedFloorNumber();
		}else{
			return 0;
		}
	}

	@Override
	public void reportFloorNumber() {
		inMoving =false;

	}

	@Override
	public int getStoppedFloorNumber() {
		return this.calledByFloorNumber();
	}

	@Override
	public boolean isCallable() {
		if(this.getStoppedFloorNumber() > Elevator.MIN_FLOOR_NUMBER && this.getStoppedFloorNumber() <= Elevator.MAX_FLOOR_NUMBER){
			return true;
		}else{
			return false;
		}
		
	}

	@Override
	public int calledByFloorNumber() {
		// TODO Auto-generated method stub
		return this.lastStoppedNumber;
	}

	public void setCalledByFloorNum(int callingFloor){
		this.lastStoppedNumber = callingFloor;
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
}
