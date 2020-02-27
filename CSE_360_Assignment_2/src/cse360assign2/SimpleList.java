/**
 * @author     Joshua Martin
 * Class ID:   368
 * Assignment: 1
 * This file contains a class which implements a simple list. The class allows
 * the user to add elements, remove elements and search for elements within the
 * list.
 */

package cse360assign2;


/**
 * This class, as described above, serves as a practice for using JUnit.
 */

public class SimpleList {

	private int[] list;
    private int count;

    /**
     * This constructor initializes the list attribute to an empty int array
     * of size 10. count is also set to 0.
     */

    public SimpleList() {
    	this.list = new int[10];
    	this.count = 0;
    }

    /**
     * add takes an integer and adds it to the front of the list. All elements
     * already in the list are shifted to the right. If the list is already at
     * the maximum size, then the array size is increased by 50%.
     * @param num This is the number to be added to the list.
     */

    public void add(int num) {
    	if(count == list.length) {
    		//make new list that is 50% bigger
    		int[] newList = new int[(int) ((int)list.length * 1.5)];
    		//copy over elements from old list but shifted over one place
    		for(int idx = 1; idx <= list.length; idx++) {
    			newList[idx] = list[idx-1];					
    		}
    		list = newList;
    	} else {
    		//shift elements over one place
    		for(int idx = count; idx > 0; idx--) {
        		list[idx] = list[idx-1];
        	}
    	}
    	list[0] = num;
    	count++;
    }

    /**
     * This method removes the first instance of num from the list, shifts the
     * remaining elements the appropriate distance to the left, decrements
     * count accordingly and decreases the size of the list by 25% if more
     * than 25% of the list is empty .
     * @param num
     */

    public void remove(int num) {
    	boolean found = false;
    	int idx = 0;
    	while(!found && idx < count) {
    		if(list[idx] == num) {
    			found = true;
    		}else {
    			idx++;
    		}
    	}
    	
    	//remove num if it is present and shift all remaining ints to the left
    	if(found) {
        	for(int loopIdx = idx; loopIdx < count - 1; loopIdx++) {
        		list[loopIdx] = list[loopIdx+1];
        	}
        	list[count - 1] = 0;
        	count--;
    	}
    	
    	//if list is > 25% empty, reduce it's size by 25% (min size of 1)
    	int threeQuarterFull = (list.length * 3) / 4;
    	if(count < threeQuarterFull && threeQuarterFull >= 1) {
    		int[] newList = new int[threeQuarterFull];
    		//copy over elements from old list but shifted over one place
    		for(int loopIdx = 0; loopIdx < count; loopIdx++) {
    			newList[loopIdx] = list[loopIdx];					
    		}
    		list = newList;
    	}
    }

    /**
     * This method is a simple getter for the count attribute.
     * @return int This returns the number of elements in the list.
     */

    public int count() {
    	return count;
    }

    /**
     * This method formats the contents of the list into a string.
     * @return String This returns the representative string.
     */

    public String toString() {
    	String str = "";
    	for(int loopIdx = 0; loopIdx < count; loopIdx++) {
    		if(loopIdx != 0) {
    			str += " ";
    		}
    		str += String.valueOf(list[loopIdx]);
    	}
    	return str;
    }

    /**
     * This method searches the list to see if it contains num. If it does,
     * then the index of the first occurrence of num is returned. If it doesn't,
     * then -1 is returned.
     * @param num This is the number to be found in the array.
     * @return int The index.
     */

    public int search(int num) {
    	boolean found = false;
    	int idx = 0;
    	while(!found && idx < count) {
    		if(list[idx] == num) {
    			found = true;
    		}else {
    			idx++;
    		}
    	}
    	if(!found) {idx = -1;}

    	return idx;
    }

    /**
     * This method is a simple getter for the list attribute.
     * @return int[] This is the list.
     */

    public int[] getList() {
    	return list;
    }
}
