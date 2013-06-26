package org.clothocad.dom;

import org.json.JSONException;
import org.json.JSONObject;

public class Function 
		extends Sharable {
	
	private static final long serialVersionUID = 4364609032511931575L;
	
	private String sFunction;
	private Object[] lstParameters;
	
	public Function(String sFunction, Object[] lstParameters) {
		super(SharableType.FUNCTION);
		this.sFunction = sFunction;
		this.lstParameters = lstParameters;
	}
	
	public String getFunction() {
		return this.sFunction;
	}
	
	public Object[] getParameters() {
		return this.lstParameters;
	}

	@Override
	public JSONObject toJSON() {
		JSONObject json = new JSONObject();
		try {
			json.put("function", this.getFunction());
			if(null != lstParameters && lstParameters.length>0) {
				
				JSONObject jsonParams = new JSONObject();
				for(Object o: lstParameters) {
					jsonParams.put("param-value", o);
				}
				
				json.put("parameter-values", jsonParams);
			}
			
			return json;
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return (JSONObject)null;
	}
}
