##### Node

```javascript
class Node {
  constructor(value) {
    this.value = value;
    this.next = null;
  }
}
```

##### LinkedList

```javascript
class Stack {
    constructor() {
        this.top = null;
        this.length = 0

    }

    // Time Complexity: O(1)
    // Space Complexity: O(1)
    push(value) {
        const node = new Node(value)

        if (this.length === 0) {
            this.top = node
        } else {
            node.next = this.top
            this.top = node
        }
        this.length++;
        return this

    }
}
```
