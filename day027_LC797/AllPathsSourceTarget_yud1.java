package day027_LC797;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @autor yud1
 * @date 2023/1/30 09:53
 */
public class AllPathsSourceTarget_yud1 {


    public int n;

    public List<List<Integer>> lists = new ArrayList<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {

        n = graph.length;
        LinkedList<Integer> path = new LinkedList<>();
        path.add(0);
        dfs(graph, 0, path);
        return lists;

    }


    public void dfs(int[][] graph, int i,  LinkedList<Integer> path) {
        if (i == n - 1) {
            lists.add(new LinkedList<>(path));
            path.removeLast();
            return;
        }
        for (int j = 0; j < graph[i].length; j++) {
            path.addLast(graph[i][j]);
            dfs(graph, graph[i][j], path);
        }
        path.removeLast();
    }
}
