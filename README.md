# 📚 Data Structures Implemented From Scratch (Java)

This repository contains manual implementations of classic data structures in Java, developed for educational purposes.

All structures were implemented **without using Java’s built-in collection framework**, focusing on understanding internal mechanics, memory management, and algorithmic complexity.

---

# Implemented Structures

- Binary Search Tree (BST)
- Singly Linked List
- Doubly Linked List (Deque)
- Dual Stack (Two stacks in one dynamic array)
- Positional List (Sequence)
- Dynamic Array Vector
- Linked Vector

---

# Binary Search Tree (BST)

A complete Binary Search Tree implementation built from scratch.

## Design Decisions

- Stores `int` values for simplified comparison logic.
- Each node maintains references to:
  - Parent
  - Left child
  - Right child
- Removal uses the **in-order successor strategy** for nodes with two children.
- Traversals implemented recursively.
- Implements `Iterable<Integer>` using in-order traversal.
- Structured level-order printing implemented using `Queue` (BFS).

## Time Complexity

| Operation | Average | Worst Case |
|-----------|----------|------------|
| Insert    | O(log n) | O(n) |
| Search    | O(log n) | O(n) |
| Remove    | O(log n) | O(n) |

Worst case occurs when the tree becomes skewed.

---

# Linked Structures

## Doubly Linked List (`No_Duplo`)

A deque-style doubly linked list with head and tail references.

### Characteristics

- Each node stores:
  - Value
  - Reference to next node
  - Reference to previous node
- Constant-time insertion and removal at both ends.
- Maintains `size` attribute.
- Throws exceptions on invalid operations (empty structure).

### Time Complexity

| Operation | Complexity |
|------------|------------|
| Insert (begin/end) | O(1) |
| Remove (begin/end) | O(1) |

---

## Singly Linked List (`No_Simples`)

A classic singly linked list with head and tail references.

### Characteristics

- Each node stores:
  - Value
  - Reference to next node
- Maintains `size` attribute.
- Removal from end requires traversal.

### Time Complexity

| Operation | Complexity |
|------------|------------|
| Insert (begin/end) | O(1) |
| Remove (begin) | O(1) |
| Remove (end) | O(n) |

---

# Dual Stack (Rubro)

Two stacks sharing the same dynamic array.

## Concept

- Red stack grows from left → right.
- Black stack grows from right → left.
- Both stacks share memory space.

## Key Behavior

- Capacity doubles when stacks collide.
- Capacity shrinks when usage ≤ 1/3 of capacity.
- Uses two internal pointers (`sizeV` and `sizeP`) to avoid overlap.

## Time Complexity

| Operation | Complexity |
|------------|------------|
| Push | O(1) amortized |
| Pop | O(1) amortized |
| Resize | O(n) |

Memory-efficient alternative to maintaining two separate arrays.

---

# Sequence (Positional List with Sentinels)

A doubly linked positional list using sentinel nodes.

Unlike standard linked lists, this implementation allows direct manipulation via node references.

## Design Characteristics

- Head and tail sentinels simplify boundary conditions.
- Each node stores:
  - Value
  - Previous reference
  - Next reference
- Optimized rank traversal:
  - From head if rank ≤ size/2
  - From tail otherwise

## Supported Operations

### Positional
- `first()` / `last()`
- `before(node)` / `after(node)`
- `replaceElement(node, value)`
- `swapElements(node1, node2)`
- `insertBefore(node, value)`
- `insertAfter(node, value)`
- `remove(node)`

### Rank-Based
- `elementAt(rank)`
- `replaceAt(rank, value)`
- `insertAt(rank, value)`
- `removeAt(rank)`
- `rankOf(node)`
- `atRank(rank)`

## Time Complexity

| Operation | Complexity |
|------------|------------|
| Insert/Remove (node reference) | O(1) |
| Access by rank | O(n) |

---

# Vector Implementations

## Dynamic Array Vector

A manual implementation of a dynamic array similar to `ArrayList`.

### Characteristics

- Backed by raw `Object[]`.
- Capacity doubles when full.
- Manual shifting during insertions/removals.
- Tracks `size` and `capacity`.

### Time Complexity

| Operation | Complexity |
|------------|------------|
| Access | O(1) |
| Insert (end) | O(1) amortized |
| Insert (middle) | O(n) |
| Remove | O(n) |
| Resize | O(n) |

---

## Linked Vector

A vector-like abstraction implemented over a doubly linked list with sentinels.

### Characteristics

- Node-based access.
- O(1) insertion/removal given node reference.
- Linear-time node retrieval by index.

### Time Complexity

| Operation | Complexity |
|------------|------------|
| Access by node | O(1) |
| Insert/Remove (node) | O(1) |
| Get node by index | O(n) |

Demonstrates the trade-offs between array-based and pointer-based structures.

---

# Educational Purpose

This repository focuses on:

- Understanding internal data structure mechanics
- Pointer manipulation
- Manual memory resizing strategies
- Algorithmic time complexity analysis
- Comparing array-based vs linked-based implementations

---

Developed as a learning-focused project to deeply understand fundamental data structures.