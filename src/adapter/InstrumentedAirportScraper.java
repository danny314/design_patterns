import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class InstrumentedAirportScraper implements AirportScraperInterface {

  // sorted by most commonly called destinations first,
  // ties broken alphabetically. ok to consider case, i.e.,
  // treat AUS and aus differently.  see test suite
  // for exact format

  private  AirportScraperInterface asi; 
  private Map<String, Integer> mostCommonDestinations;
  private Map<String,Double> cache;
		  
  public InstrumentedAirportScraper(AirportScraper airportScraper) {
	  asi = airportScraper;
	  mostCommonDestinations = new HashMap<String,Integer>();
	  cache = new HashMap<String,Double>();
  }
  
  public List<String> mostCommonDestinations() {
	  List<Map.Entry<String, Integer>> mapEntries = new ArrayList<Map.Entry<String, Integer>>(mostCommonDestinations.entrySet());
	  Collections.sort(mapEntries, 
			  new Comparator<Map.Entry<String,Integer>>() {

				@Override
				public int compare(Entry<String, Integer> entry1,	Entry<String, Integer> entry2) {
					int countResult = entry2.getValue().compareTo(entry1.getValue());
					if (countResult == 0) {
						return entry1.getKey().compareTo(entry2.getKey());
					}
					return countResult;
				}
	  }
	  );
	  
	  List<String> commonDestinationDisplayList = new ArrayList<String>();
	  for (Map.Entry<String, Integer> entry : mapEntries ) {
		  commonDestinationDisplayList.add(entry.getKey() + ":" + entry.getValue());
	  }
	  
	  return commonDestinationDisplayList;
  }

@Override
public double lookupDistance(String dest) {
	//Check if dest exists in the cache
	Double cachedDistance = cache.get(dest);
	Double distance = null;
	if (cachedDistance != null) {
		distance = cachedDistance;
	} else {
		//Look up distance and put in cache
		distance = asi.lookupDistance(dest);
		cache.put(dest, distance);
	}
	//Increment the call count
	Integer callCount = mostCommonDestinations.get(dest);
	
	if (callCount == null) {
		callCount = 0;
	} 
	mostCommonDestinations.put(dest, callCount + 1);

	return distance;
}

}