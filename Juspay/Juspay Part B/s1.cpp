Problem Statement
You are in the center of a city represented as a tree. Each junction (node)
 can either be free to traverse or cost you a certain amount of money specified in a list.
 The leaf nodes represent restaurants. Given the amount of money 
  you have and the cost at each junction, determine how many restaurant options you can reach.

Input
Two integers x and y:
x: Number of nodes.
y: The amount of money you start with.
A list of integers representing the cost to traverse each junction.
A series of pairs of integers that represent the edges of the tree (the connections between nodes).
Output
An integer representing the number of reachable restaurants (leaf nodes).

Input:
4 1
[0, 1, 0, 2]
1  2  3  4
1->2
1->3
1->4

[[1,2],[1,3],[1,4]]
1->2
1

Output
2
 
};
