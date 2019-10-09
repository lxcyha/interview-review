var kafka = require('kafka-node'),
    Producer = kafka.Producer,
    Consumer = kafka.Consumer,
    KeyedMessage = kafka.KeyedMessage,
    client = new kafka.KafkaClient(),
    producer = new Producer(client),
    consumer = new Consumer(
        client,
        [
            {topic: 'topic1'}, {topic: 'topic2'}
        ],
        {
            autoCommit: true
        }
    ),
    km = new KeyedMessage('key', 'message'),
    payloads = [
        {topic: 'topic1', messages: 'hi'},
        {topic: 'topic2', messages: ['hello', 'world', km]}
    ];

consumer.on('message', function (message) {
    console.log(message.topic);
});

producer.on('ready', function () {
    producer.send(payloads, function (err, data) {
        console.log(data);
    });
});




