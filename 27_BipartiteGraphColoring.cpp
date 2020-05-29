/**

Given a set of N people (numbered 1, 2, ..., N), we would like to split everyone into two groups of any size.

Each person may dislike some other people, and they should not go into the same group. 

Formally, if dislikes[i] = [a, b], it means it is not allowed to put the people numbered a and b into the same group.

Return true if and only if it is possible to split everyone into two groups in this way.

 

Example 1:

Input: N = 4, dislikes = [[1,2],[1,3],[2,4]]
Output: true
Explanation: group1 [1,4], group2 [2,3]
Example 2:

Input: N = 3, dislikes = [[1,2],[1,3],[2,3]]
Output: false
Example 3:

Input: N = 5, dislikes = [[1,2],[2,3],[3,4],[4,5],[1,5]]
Output: false
 

Constraints:

1 <= N <= 2000
0 <= dislikes.length <= 10000
dislikes[i].length == 2
1 <= dislikes[i][j] <= N
dislikes[i][0] < dislikes[i][1]
There does not exist i != j for which dislikes[i] == dislikes[j].


**/
//Used graph coloring - to solve the problem of bipartite graph
//Bipartite graph- divide the nodes in two sets
class Solution {
public:
    typedef long long int ll;
    int visited[2009];
    vector<ll> graph[2009];
    void addedge(ll v,ll w){
	    graph[v].push_back(w);
	    graph[w].push_back(v);
    }
    bool bfs(int c){
	ll color[2009];
	memset(color,-1,sizeof(color));
	queue<int > Q;
	Q.push(c);
	color[c] = 1;
	while(!Q.empty()){
		int p = Q.front(); //parent vertex
		Q.pop();
		for(ll i=0;i<graph[p].size();i++){
		if(visited[ graph[p][i] ] == 0 && color[graph[p][i]] ==-1 ){	//unvisited vertex so change its color
			Q.push(graph[p][i]);
			color[ graph[p][i] ] = 1 - color[p];
		}
		else if(visited[ graph[p][i] ] != 0 && color[graph[p][i]] == color[p] ){	//parent and child with the same color
			return false;
		}
		}
		visited[p] = 1;
	}
return true;
}

    bool possibleBipartition(int N, vector<vector<int>>& dislikes) {
        int node = 0;
        for(vector<int> dislike : dislikes){
            addedge(dislike[0],dislike[1]);   
            node=dislike[0];
        }
        memset(visited,0,sizeof(visited));
        return bfs(node);
    }
};
