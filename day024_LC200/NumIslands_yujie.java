package day024_LC200;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 200. 岛屿数量
 *
 * @author zhayujie
 * @date 2023/1/2
 */
public class NumIslands_yujie {
    public int numIslands(char[][] grid) {
        Map<String, String> union = new HashMap<>();
        // 初始化
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                union.put(key(i, j), key(i, j));
            }
        }
        // 合并
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (j < grid[0].length - 1) {
                    merge(union, grid, i, j, i, j + 1);
                }
                if (i < grid.length - 1) {
                    merge(union, grid, i, j, i + 1, j);
                }
            }
        }

        // 计数
        Set<String> groupIds = new HashSet<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    groupIds.add(find(union, i, j));
                }
            }
        }
        return groupIds.size();
    }

    public String find(Map<String, String> union, int i, int j) {
        String parent = union.get(key(i, j));
        while (!parent.equals(union.get(parent))) {
            parent = union.get(parent);
        }
        return parent;
    }

    private void merge(Map<String, String> union, char[][] grid, int i1, int j1, int i2, int j2) {
        if (grid[i1][j1] != grid[i2][j2]) {
            return;
        }
        String group1 = find(union, i1, j1);
        String group2 = find(union, i2, j2);
        if (!group1.equals(group2)) {
            // group1的根节点的parent指向group2的根节点
            union.put(group1, group2);
        }
    }

    private String key(int i, int j) {
        return i + "-" + j;
    }

    public static void main(String[] args) {
        char[][] grid = new char[3][5];
        grid[0] = new char[]{'1','1','1'};
        grid[1] = new char[]{'0','1','0'};
        grid[2] = new char[]{'1','1','1'};

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println(new NumIslands_yujie().numIslands(grid));
    }
}
