package etf.nim.bd140657d;

import java.util.*;


public class Pro {
	
	int alpha, beta;
	int nivo;
	int value;
	int stariBroj;
	int brojStubova;
	int[] zetoni;
	public CvorAB koren; 
	int level;
	
	public Pro(int level) {
		value = Integer.MIN_VALUE;
		alpha = Integer.MIN_VALUE;
		beta = Integer.MAX_VALUE;
		koren = new CvorAB();
		koren.deca = new LinkedList<CvorAB>();
		this.level = level;
	}

	boolean daLiMoze(int pos, int value, int stariBroj, int[] zetoni, int brojStubova) {
		boolean p = true;
		if (value > stariBroj * 2)
			return false;
		for (int i = 0; i < brojStubova; i++) {
			if (zetoni[pos] - value == zetoni[i] && zetoni[i] != 0 && i != pos) {
				p = false;
				break;
			}
		}
		return p;
	}

	public void formirajStablo(int[] zetoni, int stariBroj, int brojStubova, int nivo){
		formirajCvor(this.koren, zetoni, stariBroj, brojStubova, nivo);
	}
	
	public void formirajCvor(CvorAB koren, int[] zetoni, int stariBroj, int brojStubova, int nivo) {
		CvorAB p1 = new CvorAB();
		p1.nivo = nivo;
		p1.stariBroj = stariBroj;
		p1.brojStubova = brojStubova;
		p1.zetoni = zetoni;
		p1.koren = koren;
		p1.deca = new LinkedList<CvorAB>();
		koren.deca.add(p1);
		boolean bioBreak = false;
		
		if(p1.nivo % 2 == 0){
			p1.value = Integer.MIN_VALUE;		//setovanje pocetne value, alpha, beta
		}
		else{
			p1.value = Integer.MAX_VALUE;
		}
		
		if(p1.nivo == 0){
			p1.alpha = Integer.MIN_VALUE;
			p1.beta = Integer.MAX_VALUE;
		}
		else{
			p1.alpha = koren.alpha;
			p1.beta = koren.beta;
		}
		
		int sum = 0;
		for(int i = 0; i < brojStubova; i ++){
			sum += p1.zetoni[i];
		}
		
		if (nivo < level && sum != 0) {
			for (int i = 0; i < brojStubova; i++) {
				for (int j = 1; j <= zetoni[i]; j++) {
					if (daLiMoze(i, j, p1.stariBroj, p1.zetoni, p1.brojStubova)) {
						int[] pom = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
						for (int k = 0; k < brojStubova; k++) {
							pom[k] = zetoni[k];
						}
						pom[i] = pom[i] - j;
						formirajCvor(p1, pom, j, brojStubova, nivo + 1);
						
						//proverava da li treba da izadje u zavisnosti od promenjenih alfa i beta
						
						if(p1.nivo % 2 == 1){//MIN
							if(p1.beta < p1.alpha){
								bioBreak = true;
								break;
							}										//ova 2 rade isto
						}
						else{				//MAX
							if(p1.alpha > p1.beta){
								bioBreak = true;
								break;
							}
						}
					}
				}
				if(bioBreak == true) break;
			}
		}
		
		if (p1.nivo == level || sum == 0) {
			p1.value = racunajFunkciju(p1.zetoni, p1.brojStubova, sum, p1.nivo);
		}else if(p1.nivo == 0){
			p1.value = racunajValueMAX(p1.deca);
			p1.koren.value = p1.value;
		}else if(p1.nivo < level){
			if (p1.nivo % level == 1) {
				p1.value = racunajValueMIN(p1.deca);
			} else {
				p1.value = racunajValueMAX(p1.deca);
			}
		}
		
		if(p1.nivo != 0){
			if(p1.nivo % 2 == 1){ //MIN
				if(p1.value > koren.alpha){
					koren.alpha = p1.value;
				}
			}
			else{				//MAX
				if(p1.value < koren.beta){
					koren.beta = p1.value;
				}
			}
		}
		//menja alfa ili beta oca
		
	}

	int racunajFunkciju(int[] zetoni, int brojStubova, int sum, int nivo) {
		int ret = 55 - sum;
		if(sum == 0){
			if(nivo % 2 == 1){ //MIN
				ret = 1000 - nivo;
			}
			else{
				ret = -1000 + nivo;
			}
		}
		return ret;
	}

	int racunajValueMAX(LinkedList<CvorAB> deca) {
		int max = Integer.MIN_VALUE;
		for (CvorAB c : deca) {
			if (c.value > max)
				max = c.value;
		}
		return max;
	}

	int racunajValueMIN(LinkedList<CvorAB> deca) {
		int min = Integer.MAX_VALUE;
		for (CvorAB c : deca) {
			if (c.value < min)
				min = c.value;
		}
		return min;
	}

	public void unisti() {
		koren.deca.clear();
		nivo = 0;
		value = 0;
		stariBroj = 0;
		brojStubova = 0;
	}

	public int getNivo() {
		return nivo;
	}

	public void setNivo(int nivo) {
		this.nivo = nivo;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public int getStariBroj() {
		return stariBroj;
	}

	public void setStariBroj(int stariBroj) {
		this.stariBroj = stariBroj;
	}

	public int getBrojStubova() {
		return brojStubova;
	}

	public void setBrojStubova(int brojStubova) {
		this.brojStubova = brojStubova;
	}

	public int[] getZetoni() {
		return zetoni;
	}

	public void setZetoni(int[] zetoni) {
		this.zetoni = zetoni;
	}
}
