const numbers1 = [4, 7, 9, 2, 5];
const numbers2 = [7, 9, 4, 1, 3];
const results1 = [];

// for in = loop properties
// for of = loop values

console.time("O(n ^ 2)");
// O(n)
for (item of numbers1) {
  // O(m)
  if (numbers2.includes(item)) {
    results1.push(item);
  }
}
console.timeEnd("O(n ^ 2)");

// complexidade quadrática
// operação aumenta de forma quadrada conforme entradas
// O(n * m) or O(n ^ 2)

console.log(`O(n ^ 2): ${results1}`);

console.log("---");

const setNumbers2 = new Set(numbers2);
const results2 = [];

console.time("O(n)");
// O(n)
for (item of numbers1) {
  // O(1) = tempo constante
  if (setNumbers2.has(item)) {
    results2.push(item);
  }
}
console.timeEnd("O(n)");

// complexidade linear
// execução aumenta de forma linear conforme as entradas
// O(n + m)

console.log(`O(n): ${results2}`);

// Constante = O(1)
//
