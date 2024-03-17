const bunyan = require('bunyan');

module.exports = function () {
    const logger = bunyan.createLogger({
        name: 'foodtruck',
        serializers: {req: bunyan.stdSerializers.req}
    });

    return function (req, res, next) {
        req.log = logger;
        next();
    };
};
