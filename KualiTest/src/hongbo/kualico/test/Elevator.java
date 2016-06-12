package hongbo.kualico.test;

public interface Elevator {
	
	int STATUS_MOVING = 1;
	int STATUS_STOPPED = 0;
	int MIN_FLOOR_NUMBER = 1;
	int MAX_FLOOR_NUMBER = 10;
	int MOVING_UP = 1;
	int MOVING_DOWN = 0;
	
	public boolean isMoving();
	
	public int getFloorOn();
	
	public void reportFloorNumber();
	
	public int getStoppedFloorNumber();
	
	public boolean isCallable();
	
	public int calledByFloorNumber();
	
	public int getMovingDirection();
	
	public void setMovingDirection(int dir);
	
	public void setInMoving(boolean mv);

}
