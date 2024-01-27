package com.example.base.数据结构和算法.leetcode.动态规划.零钱兑换;

/**
 * @author xue
 * @date 2023/4/25 15:48
 */
public class AmountTest {

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int i = coinChange(coins, 11);
        System.out.println(1);
    }

    /**
     * 状态：目标金额 amount
     * 选择：coins数组中列出的所有硬币面额
     * 函数的定义: 凑出总金额amount 至少需要coinChange（coins，amount）枚硬币
     * base case：amount = 0时  需要0枚硬币   amount =
     */


    public static int coinChange(int[] coins, int amount) {
        // 题目要求的最终结果是 dp(amount)
        return dp(coins, amount);
    }

    // 定义：要凑出金额 n，至少要 dp(coins, n) 个硬币
    public static int dp(int[] coins, int amount) {
        // base case
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return -1;
        }

        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            // 计算子问题的结果
            int subProblem = dp(coins, amount - coin);
            // 子问题无解则跳过
            if (subProblem == -1) {
                continue;
            }
            // 在子问题中选择最优解，然后加一
            res = Math.min(res, subProblem + 1);
        }

        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
