package pe.joedayz.customerservice.domain;

import javax.xml.bind.annotation.XmlRootElement;

/*
* A sample class for adding error information in the response
*/
@XmlRootElement
public class RestAPIExceptionInfo {
	public final String detail;
	public final String message;

	public RestAPIExceptionInfo(Exception ex, String detail) {
		this.message = ex.getLocalizedMessage();
		this.detail = detail;
	}
}
