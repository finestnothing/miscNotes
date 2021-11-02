# Week 8 - Wednesday

<!-- vim-markdown-toc GFM -->

* [Video 1 - Uninformed Search](#video-1---uninformed-search)
    * [Breadth-first search](#breadth-first-search)
    * [Depth-first search](#depth-first-search)
    * [Iterative deepening search](#iterative-deepening-search)
    * [Uniform-cost search](#uniform-cost-search)

<!-- vim-markdown-toc -->

[Video Link](https://csus.instructure.com/courses/80081/pages/wednesday-of-week-8?module_item_id=3577459)

## Video 1 - Uninformed Search


### Breadth-first search

- Expand shallowest unexpanded node
- Finds shortest number of steps, not necessarily shortest path

### Depth-first search

- Expand deepest node first

### Iterative deepening search

- Uses Depth-First search as a subroutine
    - Check root
    - Limit search for solution to length 1
    - If length 1 solution not possible, increase search depth from 2 to 3
    - Repeat until solution

### Uniform-cost search

- Rank all nodes on the cost from the root note, expand the node with the lowest distance from root
- Is Dijkstra's algorithm
    - Only difference is UCS is only used to find the shortest path from initial to goal
    - Dijkstra gives the shortest distance to any node


