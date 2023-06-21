let fs = require('fs');
let input = fs.readFileSync('/dev/stdin').toString().split('\n');


let oneNumber = Number(input[0]);
let twoNumber = Number(input[1]);
let twoNumber1 = Number(input[1][2]);
let twoNumber2 = Number(input[1][1]);
let twoNumber3 = Number(input[1][0]);


let firstRes = oneNumber * twoNumber1;
let secondRes = oneNumber * twoNumber2;
let thirdRes = oneNumber * twoNumber3;

console.log(firstRes);
console.log(secondRes);
console.log(thirdRes);
console.log(oneNumber*twoNumber);

