import { users } from "./data.js";
import { filter } from "./filter.js";
import { map } from "./map.js";

//함수 중첩1
var ages = map(
    filter(users, function(user){return user.age<30}),
function(user){return user.age});

console.log(ages.length);
console.log(ages);

var names = map(
    filter(users, function(user){return user.age>30}),
    function(user){return user.name}
)
console.log(names.length);
console.log(names);

//함수 중첩2
export function log_length(value){
    console.log(value.length);
    return value;
}

function bvalue(key){
    return function(obj){
        return obj[key];
    }
}

console.log(log_length(map(
    filter(users, function(user){return user.age<30}),
function(user){return user.age})));

console.log(log_length(map(
    filter(users,function(user){return user.age>30}),
    function(user){return user.name})
));

console.log(log_length(map(filter(users, function(user){return user.age<30}),
    bvalue('age')
)))

console.log(log_length(map(filter(users,function(user){return user.age>30}),
    bvalue('name'))))