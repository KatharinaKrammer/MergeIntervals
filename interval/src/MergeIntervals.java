import java.util.*;

/**
 * Gets an array of interval and merges the overlapping intervals.
 */
public class MergeIntervals {

    public static void main(String args[]){

        System.out.println("Bitte geben Sie die Intervalle in einer Zeile ein:");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        String output = merge(input);
        System.out.println(output);

    }

    /**
     * Gets a String with intervals and merges overlapping intervals
     * @param intervalsString The String that contains the nonsorted and nonmerged intervals in square brackets like "[1, 3]"
     * @return A String where all overlapping intervals are merged
     */
    public static String merge (String intervalsString){
        //A sorted map that contains all intervals as a pair of lower and upper border
        SortedMap intervals = intervalsToMap(intervalsString.split("]"));
        //merge intervals
        return combineIntervals(intervals);
    }

    /**
     * Gets a String array with intervals (usually args[]) and returns the intervals as a SortedMap.
     * Every entry contains the lower and upper border of the interval.
     * @param intervals A String array with the intervals.
     * @return A SortedMap that contains the given intervals.
     */
    private static SortedMap<Integer, Integer> intervalsToMap(String intervals[]){
        //Map to return
        SortedMap intervalsMap = new TreeMap();
        //auxiliary array
        String[] interval = new String[2];
        for(String s: intervals){
            interval = s.replace("[", "")
                        .replace("]","")
                        .replace(" ","")
                        .split(",");
            try {
                //the smaller number is the lower border, the bigger number is the upper border
                intervalsMap.put(Math.min(Integer.parseInt(interval[0]), Integer.parseInt(interval[1])),
                                 Math.max(Integer.parseInt(interval[0]), Integer.parseInt(interval[1])));
            }catch (NumberFormatException e){
                System.out.println("An array contains an illegal String that will be ignored.");
            }
        }
        return intervalsMap;
    }

    /**
     * Merges the overlapping intervals in a sorted map.
     * The lower border always has to be smaller than the upper border.
     * @param intervals A SortedMap that contains the intervals to merge.
     * @return A SortedMap with the merged intervals
     */
    private static String combineIntervals(SortedMap intervals){
        Integer previousLowerBound = Integer.parseInt(intervals.firstKey().toString()); //lower border of previous interval
        Integer previousUpperBound = Integer.parseInt(intervals.get(previousLowerBound).toString()); //upper border of previous interval
        String mergedIntervals = "";
        List<Integer> keysToRemove = new ArrayList<>(); //can't remove an entry immediately because of the for loop
        for (Object key : intervals.keySet()){
            Integer lowerBound = Integer.parseInt(key.toString());
            Integer upperBound = Integer.parseInt(intervals.get(key).toString());
            if(previousUpperBound >= lowerBound){
                //if the intervals are overlapping or one is inside the other, merge them
                previousUpperBound = Math.max(upperBound, previousUpperBound);
            }else{
                mergedIntervals += "["+previousLowerBound+", "+ previousUpperBound+"] ";
                previousLowerBound = lowerBound;
                previousUpperBound = upperBound;
            }
        }
        mergedIntervals += "["+previousLowerBound+", "+ previousUpperBound+"] ";
        return mergedIntervals;
    }


}


