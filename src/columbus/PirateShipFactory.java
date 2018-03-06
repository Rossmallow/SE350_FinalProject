package columbus;

public class PirateShipFactory {
	public static PirateShip buildPirateShip(Ship toObserve, String strategy){
		PirateShip pirateShip = new PirateShip(toObserve);
		if(strategy.equals("follow")){
			pirateShip.setPirateStrategy(new FollowStrategy(pirateShip));
		}
		else if(strategy.equals("horizontal")){
			pirateShip.setPirateStrategy(new HorizontalStrategy(pirateShip));
		}else if(strategy.equals("none")){
			//Assigning None Strategy for the Pirate Ship
		}
		return pirateShip;
	}
}
