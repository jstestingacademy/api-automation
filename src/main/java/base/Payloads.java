package base;

public class Payloads {

	
	public static String Requestbody(String title, String body, String author) {
		
		Pojo pojo =new Pojo();
		pojo.setTitle(title);
		pojo.setBody(body);
		pojo.setAuthor(author);
		return author;
		
	}
}
