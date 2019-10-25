const length = 10;
function fn () {
    console.log(this.length)
}

const obj = {
    length: 5,
    test(fn) {
        fn();
        arguments[0]()
    }
}

const fnList = [fn];

fnList[0]()

obj.test(fn)

// 1  undefined 1