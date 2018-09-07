var Pusher = require('pusher');

var pusher = new Pusher({
  appId: '593546',
  key: '212650b24b67f75e3db6',
  secret: '15fe882fd6ed507a0678',
  cluster: 'ap1',
  encrypted: true
});

pusher.trigger('my-channel', 'my-event', {
  "message": "hello world"
});