const items = ["Maria", "Ada", "Paul", "John"];

// O(n)
for (item of items) {
  console.log(`Name is: ${item}`);
}

console.log("---");

// O(n)
for (let i = items.length - 1; i > -1; i--) {
  console.log(`Name is: ${items[i]}`);
}

// These both loop are O(n) because Big-O notatin drop constant
