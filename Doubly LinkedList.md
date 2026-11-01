##### Node

```javascript
class Node {
  constructor(value) {
    this.value = value;
    this.next = null;
    this.prev = null;
  }
}
```

##### LinkedList

```javascript
class DoublyLinkedList {
    constructor() {
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    // Time Complexity: O(1)
    // Space Complexity: O(1)
    push(value) {
        const node = new Node(value);

        if (!this.head) {
            this.head = node;
            this.tail = node;
        } else {
            this.tail.next = node;
            node.prev = this.tail;
            this.tail = node;
        }
        this.length++;
        return this;
    }

    // Time Complexity: O(1)
    // Space Complexity: O(1)
    pop() {
        if (this.length === 0) return undefined;

        const temp = this.tail;

        if (this.length === 1) {
            this.head = null;
            this.tail = null;
        } else {
            this.tail = temp.prev;
            this.tail.next = null;
            temp.prev = null;
        }

        this.length--;

        return temp;
    }

    // Time Complexity: O(1)
    // Space Complexity: O(1)
    unshift(value) {
        const node = new Node(value)

        if (this.length === 0) {
            this.head = node
            this.tail = node
        } else {
            node.next = this.head
            this.head.prev = node
            this.head = node

        }
        this.length++

        return this
    }

    // Time Complexity: O(1)
    // Space Complexity: O(1)
    shift() {
        if (this.length === 0) return undefined

        const temp = this.head

        if (this.length === 1) {
            this.head = null
            this.tail = null
        } else {
            this.head = this.head.next
            this.head.prev = null
            temp.next = null
        }
        this.length--;

        return temp;
    }

    // Time Complexity: O(n)
    // Space Complexity: O(1)
    get(index) {
        if (index < 0 || index >= this.length) {
            return undefined;
        }

        let temp;

        if (index < this.length / 2) {
            temp = this.head;
            for (let i = 0; i < index; i++) {
                temp = temp.next;
            }
        } else {
            temp = this.tail;
            for (let i = this.length - 1; i > index; i--) {
                temp = temp.prev;
            }
        }
        return temp;
    }

    // Time Complexity: O(n)
    // Space Complexity: O(1)
    set(index, value) {
        let temp = this.get(index);
        if (temp) {
            temp.value = value;
            return true;
        }
        return false;
    }

    // Time Complexity: O(n)
    // Space Complexity: O(1)
    insert(index, value) {
        if (index < 0 || index > this.length) return false;

        if (index === 0) {
            this.unshift(value);
            return true;
        }

        if (index === this.length) {
            this.push(value);
            return true;
        }

        const node = new Node(value);
        const prev = this.get(index - 1);
        const next = prev.next;

        prev.next = node;
        node.next = next;
        node.prev = prev;
        next.prev = node;

        this.length++;
        return true;
    }

    // Time Complexity: O(n)
    // Space Complexity: O(1)
    remove(index) {
        if (index < 0 || index >= this.length) return undefined;

        if (index === 0) return this.shift();
        if (index === this.length - 1) return this.pop();

        const temp = this.get(index);

        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;

        temp.next = null;
        temp.prev = null;

        this.length--;

        return temp;
    }

}
```




