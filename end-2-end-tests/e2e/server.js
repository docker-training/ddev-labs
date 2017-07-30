var webdriver = require('selenium-webdriver'),
    By = webdriver.By,
    until = webdriver.until;
console.log('Selenium driver initialized.');
function test(){
    console.log('Now running test');
    var driver = new webdriver.Builder()
        .forBrowser('chrome')
        .usingServer('http://selenium:4444/wd/hub')
        .build();
    driver.get('http://ui:3000/pet');
    driver.wait(until.titleIs('Cat of the Day'), 1000);
    driver.quit();
}
console.log('Now waiting for 3sec');
setTimeout(test, 3000);