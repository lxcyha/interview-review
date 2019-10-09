const Koa = require('koa');
const app = new Koa();


app.use(async (ctx, next) => {
    await next();
    let url = ctx.url;
    console.log(`${url}`);
});

app.use(async ctx => {
    ctx.body = 'index';
});

app.listen(3000);