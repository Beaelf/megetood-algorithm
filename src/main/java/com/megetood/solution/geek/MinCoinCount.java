package com.megetood.solution.geek;

/**
 * todo
 *
 * @author Lei Chengdong
 * @date 2020/11/26
 */
public class MinCoinCount {
    int getMinCoinCount() {
        int[] values = {5, 3}; // 硬币面值
        int total = 11; // 总价
        return getMinCoinCountHelper(total, values, 2); // 输出结果
    }

    int getMinCoinCountHelper(int total, int[] values, int valueCount) {
        int rest = total;
        int count = 0; // 从大到小遍历所有面值
        for (int i = 0; i < valueCount; ++i) {
            int currentCount = rest / values[i]; // 计算当前面值最多能用多少个
            rest -= currentCount * values[i]; // 计算使用完当前面值后的余额
            count += currentCount; // 增加当前面额用量
            if (rest == 0) {
                return count;
            }
        }
        return -1; // 如果到这里说明无法凑出总价，返回-1 }
    }

    public static void main(String[] args) {
        int res = new MinCoinCount().getMinCoinCount();
        System.out.println(res);
    }
}
