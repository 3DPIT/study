import { users } from "../0423/data.js";
import { find } from "./find.js";

function bmatch1(key, val) {
  return function (obj) {
    return obj[key] === val;
  };
}

export function map(list, iteratee) {
  var newList = [];
  for (var i = 0; i < list.length; i++) {
    newList.push(iteratee(list[i]));
  }

  return newList;
}

export function filter(list, predicate) {
  var newList = [];
  for (var i = 0; i < list.length; i++) {
    if (predicate(list[i])) newList.push(list[i]);
  }

  return newList;
}

var bmatch2 = (key, val) => (obj) => obj[key] == val;

// { id: 1, name: 'ID', age: 32 }
console.log(find(users, bmatch1("id", 1)));

// { id: 7, name: 'HI', age: 24 }
console.log(find(users, bmatch2("name", "HI")));

// { id: 5, name: 'JE', age: 27 }
console.log(find(users, bmatch2("age", 27)));

//filter와 협업
/*
[
    { id: 1, name: 'ID', age: 32 },
    { id: 3, name: 'BJ', age: 32 },
    { id: 6, name: 'JM', age: 32 }
]
*/
console.log(filter(users, bmatch2("age", 32)));

//map과 협업
/*
[
  true,  false,
  true,  false,
  false, true,
  false
]
*/
console.log(map(users, bmatch2("age", 32)));

//bmatch
function object(key, val) {
  var obj = {};
  obj[key] = val;

  return obj;
}

function match(obj, obj2) {
  for (var key in obj2) {
    if (obj[key] != obj2[key]) return false;
  }

  return true;
}

function bmatch(obj2, val) {
  if (arguments.length == 2) obj2 = object(obj2, val);

  return function (obj) {
    return match(obj, obj2);
  };
}

console.log(
  match(find(users, bmatch("id", 3)), 
  find(users, bmatch("name", "BJ")))
);

console.log(
    find(users, function(u){return u.age==32 && u.name == 'JM'})
)

console.log(
    find(users,bmatch({name:'JM',age:32}))
)

function findIndex(list, predicate){
    for (var i =0; i<list.length; i++){
        if(predicate(list[i])) return i;
    }
    
    return -1;
}


//5
console.log(findIndex(users, bmatch({name:'JM', age:32})));


//-1
console.log(findIndex(users, bmatch({age:36})));