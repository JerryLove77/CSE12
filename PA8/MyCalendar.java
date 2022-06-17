/**
 * Name: Jianrui Zhang
 * ID: A16878087
 * Email: Jiz145@ucsd.edu
 * Sources used: none
 * 
 * This file contains MyCalendar class.
 * It is based on MyTreeMap<Integer, Integer> calendar. 
 */

/**
 * This class is used to function as calenar.
 * It records events' start time and end time
 */
public class MyCalendar {
    MyTreeMap<Integer, Integer> calendar;

    /**
     * Initializes the calendar object.
     */
    public MyCalendar() {
        calendar = new MyTreeMap<Integer, Integer>();
    }
    
    /**
     * If adding the event does not cause a double booking, add the event
     * @param start (start time of the event)
     * @param end (end time of the event)
     * @return (not cause a double booking, returns true
     * otherwise false)
     */
    public boolean book(int start, int end) {
        if(start < 0 || start >= end) {
            throw new IllegalArgumentException();
        }
        Integer firststart = calendar.ceilingKey(start); 
        Integer lastend = calendar.floorKey(start); 
        System.out.println(firststart);
        if(calendar.root == null) {
            calendar.put(start, end);
            return true;
        }
        if((lastend == null || calendar.get(lastend) <= start) 
        && (firststart == null || firststart >= end)){
                calendar.put(start, end);
                return true;
        }
        else{
            return false;
        }
    }

    public MyTreeMap<Integer, Integer> getCalendar(){
        return this.calendar;
    }
}