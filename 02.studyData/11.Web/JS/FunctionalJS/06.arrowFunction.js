import { log_length } from "./05.functionFunctio.js";
import { filter } from "./filter.js";
import { map } from "./map.js";

console.log(log_length(
    map(filter(user, user=>user.age<30), user=>user.age)
))

console.log(log_length(
    map(filter(user,user=>user.age>30),user=>user.name)
))

var under_30 = user => user.age<30;
var over_30 = user => user.age>30;

console.log(log_length(
    map(filter(user,under_30),user=>user.age)
))

console.log(log_length(
    map(filter(user,over_30),user=>user.name)
))

//또 다른 방법

var ages = list => map(list, v =>v.age);
var names = list => map(list,v =>v.name);

console.log(log_length(ages(filter(users,under_30))));
console.log(log_length(names(filter(users,over_30))));

// 마지막 방법
var bvalue = key => list => map(list,v=>v[key]);
var ages = bvalue('age');
var names = bvalue('name');

var under_30 = function(u){return u.age<30};
var over_30 = function(u){return u.age>30};

console.log(log_length(ages(filter(users,under_30))));
console.log(log_length(names(filter(users,over_30))));

//마지막 bvalue 방법
function bvalue(key){
    var value = bvalue(key);
    return function(list){return map(list,value);}
}