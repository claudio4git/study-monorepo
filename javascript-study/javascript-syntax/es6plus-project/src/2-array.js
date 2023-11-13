const intValues = [1, 2, 4, 5, 6, 8, 9];

const newArr = intValues.map(function(item, index) { // foreach and return a new array
    return item * index;
});

const newArr2 = intValues.map((item, index) => item * index);

const sum = intValues.reduce(function(total, next) { // foreach and transform and a unique value
    return total + next;
});

const sum2 = intValues.reduce((total, next) => total + next);

// números pares
const pair = intValues.filter(function(item) { // array's filter and return a new one
    return item % 2 === 0;
});

const pair2 = intValues.filter((item) => item % 2 === 0);

const findNumber = intValues.find(function(item) {
    return item === 4;
});

const findNumber2 = intValues.find((item) => item === 4);
