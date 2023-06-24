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
public class Produkti{
	private String kodi;
	private String emertimi;
	private double cmimi;
	private boolean importuar;
	
	public Produkti(String k, String e, double c, boolean i){
		kodi = k;
		emertimi = e;
		cmimi = c;
		importuar = i;
	}
	
	public String getKodi(){
		return kodi;
	}
	
	public String getEmertimi(){
		return emertimi;
	}
	
	public double getCmimi(){
		return cmimi;
	}
	
	public boolean getImportuar(){
		return importuar;
	}
	
	public void setEmertimi(String e){
		emertimi = e;
	}
	
	public void setCmimi(double c){
		cmimi = c;
	}
	
	public void setImportuar(boolean i){
		importuar = i;
	}
	
	public String toString(){
		return kodi + ": " + emertimi + " - " + cmimi
				+ (importuar ? " " : " jo ") + "i importuar";
	}
	
	public boolean equals(Object obj){
		if(obj instanceof Produkti){
			Produkti p = (Produkti)obj;
			/*if(emertimi.equals(p.getEmertimi()) &&
				kodi.split("-")[1].equals(p.getKodi().split("-")[1])){
				return true;	
			}*/
			return emertimi.equals(p.getEmertimi()) &&
				kodi.split("-")[1].equals(p.getKodi().split("-")[1]);
		}
		return false;
	}
}