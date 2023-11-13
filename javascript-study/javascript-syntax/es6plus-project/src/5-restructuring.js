const userComplete = {
    name:'User name',
    age: 70,
    address: {
        city: 'Any city',
        state: 'Any state',
    }
}

//console.log(userComplete);

const {name, age, address: {city}} = userComplete;

//console.log(name);
//console.log(age);
//console.log(city);

function showName( { name } ) {
    return name;
}

//console.log(showName(userComplete));