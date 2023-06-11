package com.premiumminds.internship.snail;
import java.util.concurrent.Callable;

/**
 * Task that performs the computation of the Snail Pattern
 * 
 * The variables with "row" and "column" in their name
 * represent "current" the borders of the matrix
 * @author joaod
 *
 */

public class ComputeSnailShell implements Callable<int[]> {
	private int currentResultSize, startRow, startColumn = 0; 
	private int endRow, endColumn;
	private int[] result; // stores the shail pattern of the matrix
	private int[][] matrix;
	
	public ComputeSnailShell(int[][] matrix) {
		this.matrix = matrix;
		endRow = matrix.length - 1;
	    endColumn = matrix[0].length - 1;
	    result = new int[matrix.length * matrix[0].length];
	}
	
	@Override
	public int[] call() throws Exception {
	  
      if (matrix.length == 0) {
          return result;
      }
      
      // Keeps iterating while it has borders
      while (startRow <= endRow && startColumn <= endColumn) {
          addTopRow();
          addRightColumn();
          addBottomRow();
          addLeftColumn();
      }
      
      return result;
	}
	
	/**
	 * Adds the "current" top row to the array,
	 * after that classifies it as visited and reduces the borders
	 */
	private void addTopRow() {
		for (int i = startColumn; i <= endColumn; i++) {
		   result[currentResultSize] = matrix[startRow][i];
		   currentResultSize++;
		}
		startRow++;
	  }
	  
	/**
	 * Adds the "current" right column to the array,
	 * after that classifies it as visited and reduces the borders
	 */
	  private void addRightColumn() {
	      for (int i = startRow; i <= endRow; i++) {
		      result[currentResultSize] = matrix[i][endColumn];
		   	  currentResultSize++;
	      }
	      endColumn--;
	  }
	  
	  /**
	  * Adds the "current" bottom row to the array,
	  * after that classifies it as visited and reduces the borders
	  */
	  private void addBottomRow() {
		  for (int i = endColumn; i >= startColumn; i--) {
		      result[currentResultSize] = matrix[endRow][i];
		   	  currentResultSize++;
		  }
		  endRow--;
	  }
	  
	  /**
	  * Adds the "current" left column to the array,
	  * after that classifies it as visited and reduces the borders
	  */
	  private void addLeftColumn() {
		  for (int i = endRow; i >= startRow; i--) {
	          result[currentResultSize] = matrix[i][startColumn];
		   	  currentResultSize++;
	      }
	      startColumn++;
	  }
}
