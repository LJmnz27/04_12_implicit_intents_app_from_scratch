package org.pursuit.implicit_intents_app_from_scratch.models;

import java.util.List;

public class ZodiacWrapper {
	private List<Zodiac> zodiac;

	public void setZodiacs(List<Zodiac> zodiacs){
		this.zodiac = zodiacs;
	}

	public List<Zodiac> getZodiacs(){
		return zodiac;
	}


}