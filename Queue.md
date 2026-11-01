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
        const node = new Node(value)
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

    // Time Complexity: O(1)
    // Space Complexity: O(1)
    dequeue() {
        if (this.length === 0) return undefined
        const temp = this.first
        if (this.length === 1) {
            this.first = null
            this.last = null
        } else {
            this.first = this.first.next
            temp.next = null

        }
        this.length--
        return temp
    }
}

```
