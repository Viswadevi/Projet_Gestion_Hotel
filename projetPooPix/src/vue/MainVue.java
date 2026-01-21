package vue;

import model.Hotel;

public class MainVue {
	public static void main(String[]args){
		
		Hotel m = new Hotel ("Love", "5 avenue du love"); // exemple
		
		FenetreVue vu1 = new FenetreVue(900,600,m);
		vu1.show();
		vu1.pack();
//        vu1.setVisible(true);
		
	}

}