 package test;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@Path("/hello")
public class Hello {
	@GET()
	@Produces(MediaType.TEXT_XML)
	public String sayHelloXML() {
	String resource="<?xml version=\"1.0\" ?>"+
	"<hello> This is hello from XML</hello>";
	return resource;
	}
	@GET()
	@Produces(MediaType.APPLICATION_JSON)
	public String sayHelloJSON() {
		String resource=null;
		return  resource;
	}
	
	@GET()
	@Produces(MediaType.TEXT_HTML)
	public String sayHelloHTML(@QueryParam("name")String name,@QueryParam("card_no") String card_no,@QueryParam("amount") int amount) {
		System.out.println("name is "+name);
		System.out.println("card no is "+card_no);
		System.out.println("amount is "+amount);
		String resource;
		if(amount>100000) {
			System.out.println("Amount is greater than one lakh");
			resource="  your Credit card is not approved";
		}
		else
		{
			System.out.println("Amount is lesser than one lakh");
			resource=" your Credit card is approved";
		}
		return "<html>"+"<title>" +"Credit card authorization" +name+"</title>"
				+"<body><h1>"+resource+"</h1></body>"+"</html>";
	}

}
