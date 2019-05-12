package bookstack.ui.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@ManagedBean(name="peniazeConvertor")
@FacesConverter("ccno")
public class PeniazeConvertor implements Converter {
	
	public double suma;
	private String typ;
	double suma_nova;
	
	
	
	public double getSuma_nova() {
		return suma_nova;
	}

	public void setSuma_nova(double suma_nova) {
		this.suma_nova = suma_nova;
	}
	
	

	public String getTyp() {
		if (typ == null) typ = "value2"; 
	    return typ;
	}

	public void setTyp(String typ) {
		this.typ = typ;
	}
	
	
	
	public double getSuma() {
		return suma;
	}

	public void setSuma(double suma) {
		this.suma = suma;
	}
	


	public void odosli() {
		System.out.println(typ+" "+suma);
		switch (typ) {
		case "DOLAR":
			suma_nova = suma * 1.122;
			break;
		case "LIBRA":
			suma_nova = suma * 0.86;
		default:
			break;
		}
	}
	


	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String newValue) {
		 suma = Double.parseDouble(newValue);
		 return suma;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		 
		return arg2.toString();
	}
	
	
	
}