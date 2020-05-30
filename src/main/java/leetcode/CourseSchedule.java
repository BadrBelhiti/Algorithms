package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        List<Integer>[] adjacency = new ArrayList[numCourses];
        for (int i = 0; i < adjacency.length; i++){
            adjacency[i] = new ArrayList<>();
        }

        int[] indegree = new int[numCourses];
        for (int[] preq : prerequisites){
            adjacency[preq[0]].add(preq[1]);
            indegree[preq[1]]++;
        }

        Queue<Integer> bfsQueue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++){
            if (indegree[i] == 0){
                bfsQueue.add(i);
            }
        }

        while (!bfsQueue.isEmpty()){
            int curr = bfsQueue.poll();
            for (int adjacent : adjacency[curr]){
                indegree[adjacent]--;
                if (indegree[adjacent] == 0){
                    bfsQueue.add(adjacent);
                }
            }
            numCourses--;
        }

        return numCourses == 0;
    }

}
