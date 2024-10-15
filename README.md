What is Dijkstra's Algorithm?

Dijkstra's algorithm is a graph traversal algorithm used to find the shortest path between a source node and all other nodes in a graph. It works on both directed and undirected graphs but requires the edge weights to be non-negative. Dijkstra's algorithm is widely used in network routing protocols, GPS systems, and other real-time applications where finding the shortest path is crucial.

Why Use Dijkstra's Algorithm?

Shortest Path Discovery: It efficiently finds the shortest path from the source node to the destination node in a graph.
Real-World Applications: It is used in routing algorithms to find the shortest path for packet delivery and in GPS navigation systems to find the shortest route between locations.
Optimal for Weighted Graphs: Unlike BFS (which works for unweighted graphs), Dijkstra's algorithm can handle graphs with different edge weights, making it suitable for weighted graphs where the cost between nodes varies.

Steps of Dijkstra's Algorithm

Initialize Distances: Create a set of unvisited nodes. Mark the distance to the source node as 0 and all other nodes as infinity.
Distance array: dist[], where dist[source] = 0 and dist[all other nodes] = ∞.

Mark the Source Node: Start with the source node and set its distance to 0 because the distance from the source to itself is always 0.
Initialize a priority queue (min-heap) always to explore the node with the smallest distance.

Select the Node with the Minimum Distance: From the set of unvisited nodes, choose the node with the smallest known distance (initially the source node). Let's call this node u.

Explore Neighboring Nodes: For each unvisited neighboring node v of u, calculate the distance from the source to v through u.
If this distance (dist[u] + weight of edge (u, v)) is smaller than the current distance dist[v], update dist[v] with this new value.

Mark the Node as Visited: Once all neighbors of node u are processed, mark u as visited. A node once visited will not be checked again.

Repeat: Repeat steps 3-5 until all nodes have been visited or until the shortest path to the destination node is found.

End: The algorithm ends when all nodes are visited. The dist[] array now contains the shortest distance from the source to every other node.

Time Complexity: 

O((V + E) log V) where:
V is the number of vertices.
E is the number of edges.

Space Complexity: 

O(V) for storing distances and visited nodes.

Dijkstra’s algorithm is particularly effective when working with dense graphs and graphs with non-negative edge weights.


![image](https://github.com/user-attachments/assets/e463db49-790b-4094-a0b3-62f461bba07d)

![image](https://github.com/user-attachments/assets/841e30af-d232-4e8c-b80f-92fadb943bde)


