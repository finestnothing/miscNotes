# Week 7 Wednesday Lecture

## Intro To Search

### Basics

Requirement for using most algorithms: PEAS

- P: Function that the agent is maximizing or minimizing
- E: A state = a group of variables
- A: Actions that the agent takes to move from one state to another according to a transition model
- S: Observations/sensors that allow the agent to infer the state

#### Maze Problem

Want to find the shortest path from entry point to exit point.

- Initial state: entry point
- Actions: Up/Down/Left/Right
- Goal State: End
- Objective function: shortest path

#### 8-Puzzle

- Initial State: Starting state
- Actions: Move tile into empty square
- Goal State: Match final state (in order)
- Objective: Shortest solution

### Search: Basic Idea

Pick one node from center expand it (add all related nodes to it). Pick another node and expand it as well. Continue on until we reach the goal node

All search algorithms share the same basic idea of expanding the frontier until we find goal state.

Once a node has been added to the frontier, add it to an `explored` set. Anytime a new node is expanded, only add nodes not already in the explored state.
If any explored nodes are found, compare it to the path cost already associated with it. If lower than the existing value, replace the existing explored node to have the shortest path.

