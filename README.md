# Project: Task Intelligence & Scheduling Hub

The goal is to simulate a system that receives thousands of diverse tasks, prioritises them, prevents duplicates, and tracks their history.

## 1. The Components and Their Collections


| Interface | Concrete Class | Your Use Case |
|---|---|---|
| Queue | PriorityQueue | Task Scheduler: Store tasks and process them based on "Priority" (High/Medium/Low) rather than just arrival time. |
| Set | HashSet | De-duplicator: Ensure the same Task ID isn't processed twice. If a task is already in the set, reject it. |
| Map | HashMap | Task Registry: Store the actual Task objects with their ID as the key for $O(1)$ lightning-fast lookups. |
| List | ArrayList | Execution Log: A chronological list of every task that was successfully completed, used for generating reports. |
| Deque | ArrayDeque | Undo/Redo Buffer: Keep track of the last 10 actions so a user can "rollback" a task status change. |
| SortedSet | TreeSet | Leaderboard: Display a sorted list of "Top Contributors" (users who finished the most tasks). |

## 2. Advanced Features

* Comparable/Comparator: Implement Comparable in your Task class so the PriorityQueue knows how to sort them automatically.

* Generics: Ensure all your collections are type-safe (e.g., Map<String, Task>) to prevent runtime errors.

* Streams API: Use .stream().filter().collect() on your ArrayList to generate a report of "only tasks completed in the last hour".

* Fail-Fast Iterators: Use an Iterator to safely remove items from your collection while looping through them.