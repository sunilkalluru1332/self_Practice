package practice.Self;

import java.time.LocalTime;
import java.time.ZoneId;

public class zoneID {

	public static void main(String[] args) {
		
	    ZoneId zoneid1 = ZoneId.of("Asia/Calcutta");  
	    
	    LocalTime z1 = LocalTime.now(zoneid1);
	    
	    System.out.println(z1);
	    
	    
	    ZoneId zoneid2 = ZoneId.systemDefault();
	    
	    System.out.println(zoneid2);
	    
	

	}

}
