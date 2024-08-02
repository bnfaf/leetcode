package org.example;

import com.sun.crypto.provider.HmacPKCS12PBESHA1;
import com.sun.deploy.security.BadCertificateDialog;

import java.net.MalformedURLException;
import java.util.*;

public class S310 {

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList<>();
        if (n == 1){
            res.add(0);
            return res;
        }
        List<List<Integer>> map = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            map.add(new ArrayList<>());
        }
        int[] degree = new int[n];
        for (int[] edge: edges) {
            degree[edge[0]]++;
            degree[edge[1]]++;
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (degree[i] == 1){
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()){
            res = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++){
                int cur = queue.poll();
                res.add(cur);
                List<Integer> neighbors = map.get(cur);
                for (int neighbor: neighbors){
                    degree[neighbor]--;
                    if (degree[neighbor] == 1){
                        queue.offer(neighbor);
                    }
                }
            }
        }
        return res;
    }


    public static void main(String[] args) {
        int[][] edges = new int[][]{
                {3, 0}, {3, 1}, {3, 2}, {3, 4}, {5, 4}
        };
        S310 s310 = new S310();
        System.out.println(s310.findMinHeightTrees(6, edges));
    }
}
