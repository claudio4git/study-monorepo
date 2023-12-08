function addAndLog(items) {
  // O(n)
  for (let i = 0; i < items.length; i++) {
    // O(n) nested
    for (let j = 0; j < items.length; j++) {
      console.log(`${items[i]}${items[j]}`);
    }
  }
}

addAndLog(["A", "B", "C"]); // 9 items

// This loops are quadratic time, O(i*j) or O(n^2)
