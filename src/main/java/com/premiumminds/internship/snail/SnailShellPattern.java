package com.premiumminds.internship.snail;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by aamado on 05-05-2023.
 */
class SnailShellPattern implements ISnailShellPattern {
  
  /**
   * Method to get snailshell pattern
   * 
   * @param matrix matrix of numbers to go through
   * @return order array of values that represent a snail shell pattern
   */
  public Future<int[]> getSnailShell(int[][] matrix) {
	  ExecutorService executorService = Executors.newFixedThreadPool(1);
	  Future<int[]> finalResult = executorService.submit(new ComputeSnailShell(matrix));
	  executorService.shutdown();
	  return finalResult; 
  };
  
}
