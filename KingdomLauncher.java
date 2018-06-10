
import java.util.HashMap;

import java.util.Map;
import java.util.Scanner;

public class KingdomLauncher {
	
	
	
	public  static  Kingdom initialConfiguration(){
		
		Map<String,String> mapOfEmblems=new HashMap<String,String>();
		String kingdomName="Southeros";
		mapOfEmblems.put("SPACE","GORILLA");
		mapOfEmblems.put("WATER","OCTOPUS");
		mapOfEmblems.put("LAND","PANDA");
		mapOfEmblems.put("AIR","OWL");
		mapOfEmblems.put("ICE","MAMMOTH");
		mapOfEmblems.put("FIRE","DRAGON");
		
        return Kingdom.createKingdom(mapOfEmblems,kingdomName);		
	
	}
	
	

	public static void main(String[] args) {
		
			Kingdom southeros=KingdomLauncher.initialConfiguration();
			
			Scanner in=new Scanner(System.in);
		    while(true){
			   
			   printWelcomeMessage();
			   showRulingStatus(southeros);
			   
				   while(true){
				   System.out.println("Input your message in format NameOfArea,Message");
				   String message=in.next();
				   southeros.validateMessage(message);
				   System.out.println("Any more message? (y/n)");
				   String input=in.next();
				   
					   while(!input.equals("y") && !input.equals("n")){
						   System.out.println("invalid input,input y or n");
						   System.out.println("Try again");
						   input=in.next();
						   if(input.equals("y")||input.equals("n"))
							   break;
					   }
					   
					   
					   if(input.equals("y"))
						   continue;
					   else if(input.equals("n"))
						   break;
					  
					   
			   }
			   
			   showRulingStatus(southeros);
			   in.close();
			   break;
			   
		    }
	
}



	private static void showRulingStatus(Kingdom southeros) {
		// TODO Auto-generated method stub
		
		
		System.out.println("Ruler of"+southeros.getKingdomName()+"?"+(southeros.getRuler()==""?"None":southeros.getRuler()));
		
		System.out.println("Allies of ruler?");	
		if(southeros.getRulingState()==null){
			System.out.println("None");
		}
		else{
			
					
			for(String s:southeros.getRulingState().keySet()){
				if(southeros.getRulingState().get(s))
					System.out.println(s);
				
				
			}
		}
		
		
		
		
	}



	private static void printWelcomeMessage() {
		// TODO Auto-generated method stub
		System.out.println("Hello King Shan");
		System.out.println("I belive you are here to Rule this area!! ");
	}
		
		
		
		
		
		
		
		
		
	
	

}
