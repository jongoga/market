/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marketi4;

/**
 *
 * @author Jon
 */
public class Marketi4 {

   private String emri;
	private Produkti[] produktet;
	private int index = 0;
	
	public Marketi4(String e, int nrP){
		emri = e;
		produktet = new Produkti[nrP];
	}
	
	public boolean exists(Produkti p){
		for(int i = 0; i < index; i++){
			if(produktet[i].equals(p)){
				return true;
			}
		}
		return false;
	}
	
	public void shtoProduktin(Produkti p){
		if(p == null){
			System.out.println("Produkti i painicializuar!");
			return;
		}
		if(exists(p)){
			System.out.println("Produkti ekziston!");
			return;
		}
		if(index == produktet.length){
			System.out.println("Nuk ka vend ne market!");
			return;
		}
		produktet[index++] = p;
	}
	
	public void produktiMeIShtrenjte(){
		if(index == 0){
			System.out.println("Ne market nuk ka asnje produkt!");
			return;
		}
		
		Produkti meIShtrenjti = null;
		for(int i = 0; i < index; i++){
			if(meIShtrenjti == null 
					|| produktet[i].getCmimi() > meIShtrenjti.getCmimi()){
				meIShtrenjti = produktet[i];
			}
		}
		System.out.println("Produkti me i shtrenjte ne market:\n" + meIShtrenjti);
	}
	
	public int nrProdukteve(double cmimi){
		int count = 0;
		for(int i = 0; i < index; i++){
			if(produktet[i].getCmimi() < cmimi){
				count++;
			}
		}
		return count;
	}
	
	public int fshijProduktet(String kSh){
		int count = 0;
		for(int i = 0; i < index; i++){
			String kodi = produktet[i].getKodi();
			if(kodi.split("-")[1].equals(kSh)){
				count++;
				for(int j = i; j < index - 1; j++){
					produktet[j] = produktet[j + 1];
				}
				produktet[--index] = null;
				i--;
			}
		}
		return count;
	}
	
	public void shtyp(){
		for(int i = 0; i < index; i++){
			System.out.println(produktet[i]);
		}
	}
	
	public static void main(String[] args){
		Marketi4 m = new Marketi4("Te Besarti", 50);
		Produkti p1 = new Produkti("123-KS-XYZ", "Djathe", 3.49, false);
		Produkti p2 = new Produkti("12345-AL-XAYZ", "Djathe", 14.49, true);
		m.shtoProduktin(p1);
		m.shtoProduktin(p2);
		m.shtoProduktin(new Produkti("XY123-RS-XYZ", "Plazma", 3.49, true));
		m.shtoProduktin(new Produkti("XY123-RS-XYZ", "Ketchup", 2.49, true));
		m.shtoProduktin(new Produkti("123-HR-XYZ", "Kras", 1.49, true));
		m.shtoProduktin(new Produkti("12ZY3-KS-XYZ", "Sheqer", 15.49, false));
		Produkti p3 = new Produkti("1ZYZ5-KS-1267", "Sheqer", 4., false);
		System.out.println(p3 + (m.exists(p3) ? " " : " nuk ") + "ekziston!");
		m.produktiMeIShtrenjte();
		System.out.println(m.nrProdukteve(12.56) + " produkte jane me "
						 + "te lira se 12.56 Euro");
		System.out.println();
		m.shtyp();
		m.fshijProduktet("RS");
		System.out.println();
		m.shtyp();
	}
}