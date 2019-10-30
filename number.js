
Number.prototype.add = function( number){

    return Number(this.valueOf() + number);
}

Number.prototype.multi = function(number){
    return Number(this.valueOf() * number)
}
// your code
let result = Number(10).add(2).multi(2);
console.log(result);
//24