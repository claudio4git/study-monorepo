export const objectRanking = () => {
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

  console.log(`Student without sort: ${JSON.stringify(students)}`);

  // ascendant => a.score - b.score
  // descendent => b.score - a.score
  const students2 = students.sort((a, b) => a.score - b.score);

  console.log(`Student sorted by score: ${JSON.stringify(students2)}`);

  // sorting 2 fields or more
  const students3 = students.sort((a, b) => {
    // first field to sort
    if (a.score < b.score) return -1;
    if (a.score > b.score) return 1;

    // second field to sort
    if (a.name < b.name) return -1;
    if (a.name > b.name) return 1;

    // more fields here

    // when equal name and score
    return 0;
  });

  console.log(`Student sorted by name and score: ${JSON.stringify(students3)}`);

  // ranking
  students2.forEach((item: any, index) => (item.rank = index + 1));
  console.log(`Student ranking: ${JSON.stringify(students2)}`);
};

objectRanking();
