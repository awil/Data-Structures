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

public class Driver {
	
	public static void main(String[] args) {
		DP dp = new DP();
		
		/*
		 *  Easy: 1646 Get Maximum in Generated Array
		 *  https://leetcode.com/problems/get-maximum-in-generated-array/
		 */
		dp.easy(7);
		
		/*
		 *  Medium: 518 Coin Change II
		 *  https://leetcode.com/problems/coin-change-ii/
		 */
		int[] coins = { 1, 2, 5 };
		int amount = 5;
		dp.medium(amount, coins);
		
		/*
		 *  Hard: 174 Dungeon Game
		 *  https://leetcode.com/problems/dungeon-game/
		 */
		int[][] dungeon = {
				{-2, -3,  3},
				{-5, -10, 1},
				{10, 30, -5}
				};
		dp.hard(dungeon);
	}
	
}


