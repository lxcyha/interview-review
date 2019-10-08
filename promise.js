class SimplePromise {

    constructor(executor) {
        this.state = 'padding';
        this.resolveQueue = [];
        this.rejectQueue = [];
        try {
            setTimeout(() => {
                executor(this.resolve.bind(this), this.reject.bind(this));
            }, 0);
        } catch (error) {
            this.reject(error);
        }
    }

    then(resolve, reject) {
        this.resolveQueue.push(resolve);
        this.rejectQueue.push(reject);
        return this;
    }

    resolve(value) {
        this.state = 'resolved';
        this.resolveQueue.forEach((resolve, _, arr) => {
            resolve(value);
            arr.shift();
        });
    }

    reject(error) {
        this.state = 'rejected';
        this.rejectQueue.forEach((reject, _, arr) => {
            reject(error);
            arr.shift();
        });
    }
}

new SimplePromise((resolve, reject) => {
    resolve('hello world');
}).then((value) => {
    console.log('resolve');
    console.log(value);
}, (error) => {
    console.log('reject');
    console.log(error);
});

