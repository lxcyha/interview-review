function distinct(array) {

    if (!Array.isArray(array)) {
        throw Error('array distinct parameter error')
    }
    const ObjectArray = array.map((value, _) => {
        if (typeof value === 'object') {
            return JSON.stringify(value);
        }
        return value;
    });

    return ObjectArray.filter((value, index) => {
        return ObjectArray.indexOf(value) === index;
    }).map((value) => {
        return JSON.parse(value);
    })
}


let result = distinct([1, 2, 3, 3, 2, 1]);
console.log(JSON.stringify(result));
result = distinct([{name: 'a'}, {name: 'a'}, {name: 'b'}, {name: 'c'}, {name: 'b'}, {name: 'c'},]);
console.log(JSON.stringify(result));