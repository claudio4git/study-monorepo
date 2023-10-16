// ----------------------------------------------------- REST
const userRest = {
    restName: 'User name',
    restAge: 70,
    restCompanyName: 'Google'
}

const {restName, ...restOthers} = userRest;

//console.log(restName);
//console.log(restOthers);

const restArr = [1, 2, 3, 4, 5, 6];

const [restA, restB, ...restArrOthers] = restArr;

//console.log(restA);
//console.log(restB);
//console.log(restArrOthers);

function restSum(...params) {
    return params.reduce((total, next) => total + next);
}

//console.log(restSum(1, 3, 5));

// ----------------------------------------------------- SPREAD

const spreadArr1 = [1, 2, 3];
const spreadArr2 = [4, 5, 6];

const spreadArr3 = [...spreadArr1, ...spreadArr2];

//console.log(spreadArr3);

const userSpread = {
    restName: 'User name',
    restAge: 70,
    restCompanyName: 'Google'
}

const userSpread2 = {...userSpread, restName: 'Marcelo'};

//console.log(userSpread2);