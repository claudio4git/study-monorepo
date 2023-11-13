const students = [
  {
    name: "Maria",
    score: 4,
  },
  {
    name: "John",
    score: 9,
  },
  {
    name: "Paul",
    score: 6,
  },
  {
    name: "Ada",
    score: 4,
  },
];

console.log("Student without sort:");
console.dir(students);

// sorted by score
const students2 = students.sort((a, b) => (a.score < b.score ? -1 : 1));
console.log("Student sorted by score:");
console.dir(students2);

// sorted by score and name
const students3 = students.sort((a, b) => {
  // score
  if (a.score < b.score) return -1;
  if (a.score > b.score) return 1;

  // name
  if (a.name < b.name) return -1;
  if (a.name > b.name) return 1;

  return 0;
});
console.log("Student sorted by score and name:");
console.dir(students3);

// ranking
students2.forEach((item, index) => {
  item.rank = index + 1;
});
console.log("Student ranking:");
console.dir(students2);
