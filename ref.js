let a = {x: 1}
let b = a;
a.x = a = {n: 1}

console.log(a)
console.log(b)