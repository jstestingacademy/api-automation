package utilities;

public enum Resource {
	
	postResource("/api/insert.php"),
	getResource("/api/read.php"),
	putResource("/api/update.php"),
	deleteResource("/api/delete.php");
	
	
	private String Resource;
	
	public String getResource() {
		return Resource;
	}
	
	Resource(String Resource){
		this.Resource=Resource;
	}
	

}
