package etf.nim.bd140657d;

import java.util.*;


public class Bot {

	int nivo;
	int value;
	int stariBroj;
	int brojStubova;
	int[] zetoni;
	public Cvor koren; 
	int level;
	
	public Bot(int level) {
		koren = new Cvor();
		koren.deca = new LinkedList<Cvor>();
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
	
	public void formirajCvor(Cvor koren, int[] zetoni, int stariBroj, int brojStubova, int nivo) {
		Cvor p1 = new Cvor(/*koren, nivo, stariBroj, brojStubova, zetoni*/);
		p1.nivo = nivo;
		p1.stariBroj = stariBroj;
		p1.brojStubova = brojStubova;
		p1.zetoni = zetoni;
		p1.koren = koren;
		p1.deca = new LinkedList<Cvor>();
		koren.deca.add(p1);
		if (nivo < level) {
			for (int i = 0; i < brojStubova; i++) {
				for (int j = 1; j <= zetoni[i]; j++) {
					if (daLiMoze(i, j, p1.stariBroj, p1.zetoni, p1.brojStubova)) {
						int[] pom = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
						for (int k = 0; k < brojStubova; k++) {
							pom[k] = zetoni[k];
						}
						pom[i] = pom[i] - j;
						formirajCvor(p1, pom, j, brojStubova, nivo + 1);
					}
				}
			}
		}
		if (p1.nivo == level) {
			p1.value = racunajFunkciju(p1.zetoni, p1.brojStubova);
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
		
	}

	int racunajFunkciju(int[] zetoni, int brojStubova) {
		int ret = 0;
		for (int i = 0; i < brojStubova; i++) {
			ret = ret ^ zetoni[i];
		}
		return ret;
	}
	

	int racunajValueMAX(LinkedList<Cvor> deca) {
		int max = 0;
		for (Cvor c : deca) {
			if (c.value > max)
				max = c.value;
		}
		return max;
	}

	int racunajValueMIN(LinkedList<Cvor> deca) {
		int min = 1000;
		for (Cvor c : deca) {
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
