package etf.nim.bd140657d;

public class Algoritmi {

	public Algoritmi(){
		super();
	}
	
	public boolean promena(int[] stari, int[] novi, int cap){	// ukoliko se dogodila promena na vise od jednom tf
		int cnt = 0;
		for(int i = 0; i < cap; i++){
			if(stari[i] != novi[i]) cnt++;
		}
		if(cnt > 1) return false;
		else return true;
	}
	
	public boolean valid(int noviBroj, int stariBroj, int pos, int[] stari){	// da li moze da se prihvati uneta vrednost
		if(noviBroj < 1) return false;
		if(noviBroj > stariBroj*2) return false;
		if(noviBroj > stari[pos]) return false;
		return true;
	}
	
	public boolean provera(int[] novi, int cap, int pos, int value){ //da li moze da se prihvati uneta vrednost
		boolean p = true;
		for(int i = 0; i < cap; i++){
			if(novi[pos] - value == novi[i] && novi[i] != 0 && i != pos){ p = false; break;}
		}
		return p;
	}	
}
