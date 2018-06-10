
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Kingdom {
	private Map<String,String> KingdomEmblems;
	private Map<String,Boolean > RulingState;
	private String ruler;
	private String kingdomName;
	
	
	private Kingdom(Map<String,String> KingdomEmblem,String name)
	{
		this.KingdomEmblems=KingdomEmblem;
		this.kingdomName=name;
		ruler="";
		this.RulingState=new HashMap<String,Boolean>();
	}
	
	
	
public static Kingdom createKingdom(Map<String,String> mapOfEmblems,String name){
		
		return new Kingdom(mapOfEmblems,name);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public String getKingdomName() {
		return kingdomName;
	}

	public void setKingdomName(String kingdomName) {
		this.kingdomName = kingdomName;
	}

	public Map<String, Boolean> getRulingState() {
		return RulingState;
	}

	public void setRulingState(Map<String, Boolean> rulingState) {
		RulingState = rulingState;
	}

	public String getRuler() {
		return ruler;
	}

	public void setRuler(String ruler) {
		this.ruler = ruler;
	}

	
	
	
	public boolean validateArea(String area){
		
		if(KingdomEmblems.containsKey(area.toUpperCase()))
			return true;
		return false;
		
	}
	
	
	public void validateMessage(String receivedMessage){
		
		
		
		
		String area=receivedMessage.split(",")[0];
		String message=receivedMessage.split(",")[1];
		
		
		String emblem=KingdomEmblems.get(area.toUpperCase());
		List<String> listEmblem=Arrays.asList(emblem.toLowerCase().split(""));
		List<String>  listMessage=Arrays.asList(message.toLowerCase().split(""));
		
		if(validateArea(area)){
			int flag=1;
			
			for(String s:listEmblem){
				
				if( !listMessage.contains(s) || Collections.frequency(listMessage,s)<Collections.frequency(listEmblem, s))
				{
						flag=0;
				 		break;
				}
				
				
			}
			
			if(flag==1){
				RulingState.put(area,true);
				
				this.setRuler("King Shan");	
			}
			else
				RulingState.put(area,false);
			
			
			}
	}
	

}
