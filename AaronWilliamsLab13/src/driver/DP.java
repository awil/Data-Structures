/*******************************************************************************
* Name:	Aaron Williams
* Course:	CIS 4020.01I - Advanced Object Oriented Programming
* Semester:	Fall 2022
* Assignment:	Lab 13
* Date started:	November 29, 2022
* Date finished:	December 4, 2022
* Description:	These are exercises in dynamic programming.
*******************************************************************************/
package driver;

public class DP {
	
	public static int[] dpArray;

	public DP() {

	}
	
	/*
	 *  Easy: 1646 Get Maximum in Generated Array
	 *  https://leetcode.com/problems/get-maximum-in-generated-array/
	 */
	public void easy(int n) {
		dpArray = new int[n+1];
		System.out.println(getMaximumGenerated(n));
	}
	
	public static int getMaximumGenerated(int n) {
		int tmp = 0;
		
		dpArray[0] = 0;
		dpArray[1] = 1;

		if(n == 0) {
			tmp = dpArray[n];
		}
		
		if(n == 1) {
			tmp = dpArray[n];
		}

		for(int i = 1; i <= n; i++) {
			if(2 * i <= n) {
				dpArray[2*i] = dpArray[i];
			}
			if(2 * i-1 <= n) {
				dpArray[2*i-1] = dpArray[i] + dpArray[i-1];
			}
		}
		
		for(int i = 0; i <= n; i++) {
			tmp = Math.max(dpArray[i], tmp);
		}
		
		return tmp;
	}
	
	/*
	 *  Medium: 518 Coin Change II
	 *  https://leetcode.com/problems/coin-change-ii/
	 */
	public void medium(int amt, int[] c) {
		dpArray = new int[amt + 1];
		System.out.println(change(amt, c));
	}
	
	public static int change(int amount, int[] coins) {
		dpArray[0] = 1;
		
		for(int i = 0; i < coins.length; i++) {
			int tmp = coins[i];
			
			for(int j = tmp; j < amount + 1; j++) {
				dpArray[j] += dpArray[j - tmp];
			}
		}
		return dpArray[amount];
	}
	
	/*
	 *  Hard: 174 Dungeon Game
	 *  https://leetcode.com/problems/dungeon-game/
	 */
	public void hard(int[][] dungeon) {
		
		System.out.println(calculateMinimumHP(dungeon));
	}
	
	public static int calculateMinimumHP(int[][] dungeon) {
		int row = dungeon.length;
		int col = dungeon[0].length;
		int[][] dpArr = new int[row][col];
		
		if(dungeon[row-1][col-1] > 0 || dungeon[row-1][col-1] == 0) {
			dpArr[row-1][col-1] = 1;
		} else {
			dpArr[row-1][col-1] = 1 - dungeon[row-1][col-1];
		}
		
		for(int i = row-2; i >= 0; i--) {
			dpArr[i][col-1] = Math.max(dpArr[i+1][col-1] - dungeon[i][col-1], 1);
		}
		for(int j = row-2; j >= 0; j--) {
			dpArr[row-1][j] = Math.max(dpArr[row-1][j+1] - dungeon[row-1][j], 1);
		}
		
		for(int i = row-2; i >= 0; i--) {
			for(int j = col-2; j >= 0; j--) {
				dpArr[i][j] = Math.max(Math.min(dpArr[i+1][j], dpArr[i][j+1]) - dungeon[i][j], 1);
			}
		}
		
		return dpArr[0][0];
	}

}
