function addMaker(a){
    return function(b){
        return a+b;
    }
}

const a = addMaker(1);
console.log(a(2));

// bvalue

function bvalue(key){
    return function(obj){
        return obj[key];
    }
}

bvalue('a')({a:'hi',b:'hello'});