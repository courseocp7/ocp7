package javacourse.ocp.io.serialization;

/**
 * This non serializable class is extended by a serializable class.
 * 
 * @author Jose Blesa
 *
 */
public class Developer extends User {
	
	private String code;
	
	public Developer() {
		this.code = "php";
	}
	
	public Developer(String code){
		this.code = code;
	}
	
	public String getCode(){
		return  code;
	}
}