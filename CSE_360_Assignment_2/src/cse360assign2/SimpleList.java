/**
 * @author     Joshua Martin
 * Class ID:   368
 * Assignment: 1
 * This file contains a class which implements a simple list. The class allows
 * the user to add elements, remove elements and search for elements within the
 * list.
 */

package cse360assign2;

import java.lang.Math;

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
     * add takes an integer and adds it to the from of the list. All elements
     * already in the list are shifted to the right. If the list is already at
     * the maximum size, then the right-most element is dropped off.
     * @param num This is the number to be added to the list.
     */

    public void add(int num) {
    	int maxIndex = Math.min(count, 9);
    	for(int idx = maxIndex; idx > 0; idx--) {
    		list[idx] = list[idx-1];
    	}
    	list[0] = num;
    	if(count < 10) {
    		count++;
    	}
    }

    /**
     * This method removes all instances of num from the list, shifts the
     * remaining elements the appropriate distance to the left and decrements
     * count accordingly.
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
    	if(found) {
    		list[idx] = 0;
        	int maxIndex = list.length - 1;
        	for(int loopIdx = idx; loopIdx < count; loopIdx++) {
        		if (loopIdx == maxIndex) {
        			list[loopIdx] = 0;
        		}else {
        			list[loopIdx] = list[loopIdx+1];
        		}
        	}
        	count--;

        	//if we are not at the end of the array, make a recursive call to
        	//search for more instances of num
        	if(idx + 1 < count) {
        		remove(num);
        	}
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
