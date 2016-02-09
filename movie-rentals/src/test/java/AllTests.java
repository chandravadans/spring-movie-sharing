import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cv.spring.config.SpringAppConfig;
import com.cv.spring.models.Movie;
import com.cv.spring.movieutil.MovieUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringAppConfig.class)
@ComponentScan
public class AllTests {

	@Autowired
	MovieUtil thisUtil;

	@Test
	public void testResourcePathLoading() {
		Assert.assertNotNull(thisUtil.getMoviesResourcePath());
	}
	
	@Test
	public void testMoviesLoadingIntoCache(){
		Assert.assertEquals(11, thisUtil.getCache().size());
	}
	
	@Test
	public void testFiltersMoviesByActor(){
		String actor = "Shahrukh Khan"; 
		List<Movie> moviesByActor = thisUtil.getMoviesByActor(actor);
		
		Assert.assertEquals(3, moviesByActor.size());
		
		//The Java 8 way! :)
		moviesByActor.stream().forEach(m -> Assert.assertEquals(actor, m.getLeadActor()));
		
		
		//Old way
		for(Movie m : moviesByActor){
			System.out.println(m.getName());
			if(m.getLeadActor().compareToIgnoreCase(actor)!=0)
				Assert.fail(m.getName()+ "doesn't star "+actor+" !");
		}
	}
	
	@Test
	public void testFiltersMoviesByActress(){
		String actress = "Deepika Padukone"; 
		List<Movie> moviesByActress = thisUtil.getMoviesByActress(actress);
		
		Assert.assertEquals(5, moviesByActress.size());
		for(Movie m : moviesByActress){
			System.out.println(m.getName());
			if(m.getLeadActress().compareToIgnoreCase(actress)!=0)
				Assert.fail(m.getName()+ "doesn't star "+actress+" !");
		}
	}
	
	@Test
	public void testSortsMoviesByReleaseDate(){
		List<Movie> sorted = thisUtil.sortMovies();
		
		for(int i=0; i< sorted.size()-1; i++){
			if(sorted.get(i).getReleaseDate().compareTo(sorted.get(i+1).getReleaseDate())>0)
				Assert.fail(sorted.get(i).getName()+" was released later than "+sorted.get(i+1).getName()+" !");
		}
	}
}
