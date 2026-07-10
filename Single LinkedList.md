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
class LinkedList {
  constructor() {
    this.head = null;
    this.tail = null;
    this.length = 0;
  }

  // Time Complexity: O(1)
  // Space Complexity: O(1)
  push(value) {
    const newNode = new Node(value);

    if (!this.head) {
      this.head = newNode;
      this.tail = newNode;
    } else {
      this.tail.next = newNode;
      this.tail = newNode;
    }

    this.length++;
    return this;
  }

  // Time Complexity: O(n)
  // Space Complexity: O(1)
  pop() {
    if (!this.head) return undefined;

    let temp = this.head;
    let prev = this.head;

    while (temp.next) {
      prev = temp;
      temp = temp.next;
    }

    this.tail = prev;
    this.tail.next = null;
    this.length--;

    if (this.length === 0) {
      this.head = null;
      this.tail = null;
    }

    return temp;
  }

  // Time Complexity: O(1)
  // Space Complexity: O(1)
  unshift(value) {
    const newNode = new Node(value);

    if (!this.head) {
      this.head = newNode;
      this.tail = newNode;
    } else {
      newNode.next = this.head;
      this.head = newNode;
    }

    this.length++;
    return this;
  }

  // Time Complexity: O(1)
  // Space Complexity: O(1)
  shift() {
    if (!this.head) return undefined;

    const temp = this.head;
    this.head = this.head.next;
    temp.next = null;

    this.length--;

    if (this.length === 0) {
      this.tail = null;
    }

    return temp;
  }

  // Time Complexity: O(n)
  // Space Complexity: O(1)
  get(index) {
    if (index < 0 || index >= this.length) return null;
    let temp = this.head;

    for (i = 0; i < index; i++) {
      temp = temp.next;
    }
    return temp;
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

     const newNode = new Node(value);
     const prev = this.get(index - 1);

     newNode.next = prev.next;
     prev.next = newNode;

     this.length++;
     return true;
 }

}
```
