var request = require('request');
var base_url = "http://api:8080/";

describe("When testing 'api/pet'", function(){
    it("should respond with the URL of a cat GIF", function(done) {
        request(base_url + 'api/pet', function(error, response, body){
            expect(body).toMatch(/\{"imageId":\d+,"url":"https:/);
            done();
        });
    });
});
