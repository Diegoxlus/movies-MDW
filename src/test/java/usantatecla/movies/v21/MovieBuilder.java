package usantatecla.movies.v21;

public class MovieBuilder {

	private String title;

	public MovieBuilder() {
		title = "movieName";
	}
	
	public MovieBuilder title(String title) {
		this.title = title;
		return this;
	}
	
	public ChildrenMovie childrenMovie() {
		return new ChildrenMovie(this.title);
	}
	
	public RegularMovie regularMovie() {
		return new RegularMovie(this.title);
	}
	
	public NewReleaseMovie newReleaseMovie() {
		return new NewReleaseMovie(this.title);
	}

}
