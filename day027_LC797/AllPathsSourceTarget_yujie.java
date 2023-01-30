package day027_LC797;

import java.util.*;

/**
 * 797.所有可能的路径
 *
 * @author zhayujie
 * @date 2023/1/30 20:10
 */
public class AllPathsSourceTarget_yujie {
    private List<List<Integer>> res = new ArrayList<>();
    private LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        allPathsSourceTarget(graph, 0);
        return res;
    }

    private void allPathsSourceTarget(int[][] graph, int v) {
        // push onto stack
        path.add(v);
        if (v != graph.length - 1) {
            for (int i = 0; i < graph[v].length; i++) {
                allPathsSourceTarget(graph, graph[v][i]);
            }
        } else {
            // add to res collection
            addPath();
        }
        // pop from stack
        path.removeLast();

    }

    private void addPath() {
        List<Integer> targetPath = new ArrayList<>();
        targetPath.addAll(path);
        res.add(targetPath);
    }

    public static void main(String[] args) {
        int[][] graph = {{1,2}, {3}, {3}, {}};
        List<List<Integer>> res = new AllPathsSourceTarget_yujie().allPathsSourceTarget(graph);
        System.out.println(res);
    }
}
