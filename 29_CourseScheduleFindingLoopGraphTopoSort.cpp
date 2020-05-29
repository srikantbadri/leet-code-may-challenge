/*
Leet Code Question Day 29

There are a total of numCourses courses you have to take, labeled from 0 to numCourses-1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

 

Example 1:

Input: numCourses = 2, prerequisites = [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take. 
             To take course 1 you should have finished course 0. So it is possible.
Example 2:

Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take. 
             To take course 1 you should have finished course 0, and to take course 0 you should
             also have finished course 1. So it is impossible.
 

Constraints:

The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
You may assume that there are no duplicate edges in the input prerequisites.
1 <= numCourses <= 10^5

Aim - To find loop in the graph
Solved using topological Sort

**/
class Solution {
public:
    bool canFinish(int numCourses, vector<vector<int>>& prerequisites) {
        int n=numCourses;
        vector<vector<int>> adj(n,vector<int>());
        vector<int> degree(n,0);
        //compute degree of all nodes
        for( vector<int> pre:prerequisites){
            adj[pre[0]].push_back(pre[1]);
            degree[pre[1]]++; 
        }
        queue<int> q;
        //insert nodes having zero degree
        for(int i=0;i<n;i++){
            if(degree[i]==0)q.push(i);
        }
        /repeat the process until the queue is empty
        while(!q.empty()){
            int curr=q.front();
            q.pop();
            n--;
            for(int ele:adj[curr]){
                degree[ele]--;
                if(degree[ele]==0)q.push(ele);
            }
        }
        return n==0;
    }
};
