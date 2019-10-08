const sourceObject = {
    sameKey: 'source object value',
    func: function () {
        console.log(this.sameKey)
    },
}
const targetObject = {
    sameKey: 'target object value',
}

sourceObject.func.myBind = function (target) {
    const that = this
    return function () {
        return that.apply(target, Array.prototype.slice.call(arguments))
    }
}


sourceObject.func();

sourceObject.func.myBind(targetObject)()