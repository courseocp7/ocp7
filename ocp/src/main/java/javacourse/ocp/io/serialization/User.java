package javacourse.ocp.io.serialization;

import java.io.Serializable;

/**
 * 
 * 
 * @author Jose Blesa
 *
 */
public class User implements Serializable {
	
	private String var = "hi!";
	
	public User() {}
	
	public User(String var){
		this.var = var;
	}
	
	public String getVar(){
		return  var;
	}
	
	public void setVar(String var){
		this.var = var;
	}	
}