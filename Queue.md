##### Node

```javascript
class Node {
  constructor(value) {
    this.value = value
    this.next = null
  }
}
```

##### LinkedList

```javascript
class Queue {
    constructor() {
        this.first = null
        this.last = null
        this.length = 0
    }

    // Time Complexity: O(1)
    // Space Complexity: O(1)
    enqueue(value) {
        const node = new Node(value);
        if (this.length === 0) {
            this.first = node
            this.last = node
        } else {
            this.last.next = node
            this.last = node
        }

        this.length++
        return this;
    }
}

```
