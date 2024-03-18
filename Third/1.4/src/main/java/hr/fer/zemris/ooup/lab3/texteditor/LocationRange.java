package hr.fer.zemris.ooup.lab3.texteditor;

public class LocationRange {
	private Location l1, l2;

	public LocationRange(Location l1, Location l2) {
		super();
		int y1 = l1.getY();
		int y2 = l2.getY();
		
		int x1 = l1.getX();
		int x2 = l2.getX();
		
		if(y1 > y2) {
			this.l1 = l2;
			this.l2 = l1;
		} else if(y2 > y1) {
			this.l1 = l1;
			this.l2 = l2;
		} else  {
			if(x1 > x2) {
				this.l1 = l2;
				this.l2 = l1;
			} else if(x2 > x1) {
				this.l1 = l1;
				this.l2 = l2;
			} else {
				this.l1 = l1;
				this.l2 = l2;
			}
		}
	}

	public Location getL1() {
		return l1;
	}

	public Location getL2() {
		return l2;
	}

	public void setL1(Location l1) {
		this.l1 = l1;
	}

	public void setL2(Location l2) {
		this.l2 = l2;
	}
	
	
}
