import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        Project[] projects = new Project[n];
        for (int i = 0; i < n; i++) {
            projects[i] = new Project(profits[i], capital[i]);
        }
        Arrays.sort(projects);
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(n, Collections.reverseOrder());
        int p = 0;
        for (int i = 0; i < k; i++) {
            while(p < n && projects[p].capital <= w){
                pq.add(projects[p++].profit);
            }
            if (pq.isEmpty()) {
                break;
            }
            w += pq.poll();
        }
        return w;
    }

    class Project implements Comparable<Project> {

        int capital, profit;

        public Project (int profit, int capital) {
            this.profit = profit;
            this.capital = capital;
        }

        public int compareTo(Project project){
            return capital - project.capital;
        }
    }
}
