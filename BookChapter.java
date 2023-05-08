
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BookChapter {
	public static String nearestChapter(Chapter[] chapter, int page) {
		
			List<Chapter> chs = Arrays.stream(chapter)
				.collect(Collectors.toList());
		// Not great to reset page but hard to mutate with map and Streams
			chs.stream().forEach(p -> p.setPage(Math.abs(p.getPage() - page)));
		  chs.sort((a, b) -> a.getPage() - b.getPage());
			int pageOne = chs.get(0).getPage();
		  int pageTwo = chs.get(1).getPage();
		  // Pages are equidistant from desired page.
			if(pageOne == pageTwo) {
				return chs.get(1).getName(); // Max page is here so return it.
			}
			return chs.get(0).getName();
		}    
}

class Chapter {
	private String name;
	private int page;
	
	public Chapter(String name, int page) {
		this.name = name;
		this.page = page;
	}
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	public int getPage() { return page; }
	public void setPage(int page) { this.page = page; }
}