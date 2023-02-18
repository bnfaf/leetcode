package org.example;

import java.util.*;

public class s332 {
    private LinkedList<String> res;
    private LinkedList<String> path = new LinkedList<String>();

    public List<String> findItinerary(List<List<String>> tickets) {
        Collections.sort(tickets, (a, b) ->a.get(1).compareTo(b.get(1)));
        path.add("JFK");
        boolean[] used = new boolean[tickets.size()];
        backend(tickets, used);
        return res;
    }
    public boolean backend(List<List<String>> tickets, boolean[] used){
        if (path.size() == tickets.size()+1){
            res = new LinkedList<>(path);
            return true;
        }
        for (int i = 0; i < tickets.size(); i++) {
            if (!used[i] && tickets.get(i).get(0).equals(path.getLast())){
                path.add(tickets.get(i).get(1));
                used[i] = true;
                if (backend(tickets, used)){
                    return true;
                }
                used[i] = false;
                path.removeLast();
            }
        }
        return false;
    }

    public static void main(String[] args) {
        List<List<String>> ticks = new ArrayList<>();
        ticks.add(Arrays.asList("MUC", "LHR"));
        ticks.add(Arrays.asList("JFK","MUC"));
        ticks.add(Arrays.asList("SFO","SJC"));
        ticks.add(Arrays.asList("LHR","SFO"));
        s332 solution = new s332();
        System.out.println(solution.findItinerary(ticks));


    }
}
