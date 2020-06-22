let arr = [1,2,3,4,5,6,7,8,9,10];

for(let i=0;i<arr.length;i++){
    console.log(arr[i]);
}

doubleValue = function(num){
    num = num * 2;
    console.log(num);
}
arr.forEach(e=>{
    e = e * 2;
    console.log(e);});


let sum = 0;
for(let i=0;i<arr.length;i++){
    sum+= arr[i];
    
}

numberoperation = function (f,arr){
    res = arr[0];
    for(let i=1;i<arr.length;i++){
        res = f(res,arr[i]);
    }
    return res;
}

console.log("Result :"+numberoperation((a,b)=>a*b,arr));
console.log(arr.reduce((a,b)=>a*b));