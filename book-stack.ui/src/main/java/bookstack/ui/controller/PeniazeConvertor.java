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
	
	// getters and setters for new suma
	
	public double getSuma_nova() {
		return suma_nova;
	}

	public void setSuma_nova(double suma_nova) {
		this.suma_nova = suma_nova;
	}
	
	// getters and setters for typ

	public String getTyp() {
		if (typ == null) typ = "value2"; // This will be the default selected item.
	    return typ;
	}

	public void setTyp(String typ) {
		this.typ = typ;
	}
	
	// getters and setters for suma
	
	public double getSuma() {
		return suma;
	}

	public void setSuma(double suma) {
		this.suma = suma;
	}
	
	// method for button

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
	
	// Converter converts suma to Double

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String newValue) {
		 suma = Double.parseDouble(newValue);
		 return suma;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		 System.out.println("Aktivoval som 2");
		return arg2.toString();
	}
	
	
	
}