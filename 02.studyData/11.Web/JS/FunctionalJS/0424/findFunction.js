import { users, users2 } from "../0423/data.js";

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


//HA
console.log(
  find(users2, function (u) {
    return u.getAge() == 25;
  }).getName()
);

//{ id: 4, name: 'PJ', age: 28 }
console.log(
  find(users, function (u) {
    return u.name.indexOf("P") != -1;
  })
);

//{ id: 6, name: 'JM', age: 32 }
console.log(
  find(users, function (u) {
    return u.age == 32 && u.name == "JM";
  })
);

//HA
console.log(
  find(users2, function (u) {
    return u.getAge() < 30;
  }).getName()
);

//[ 'ID', 'BJ', 'JM' ]
console.log(
  map(
    filter(users, function (u) {
      return u.age >= 30;
    }),
    function (u) {
      return u.name;
    }
  )
);

console.log(
  map(
    filter(users, (u) => u.age >= 30),
    (u) => u.name
  )
);


//[ 'ID', 'BJ', 'JM' ]

console.log(
    map(filter(users2, function(u){return u.getAge()>30}),
    function(u){return u.getName()}
    )
)

console.log(
    map(filter(users2, u => u.getAge()>30),
    u=> u.getName())
);

