/*

function greetings(name='User'){
     console.log(`Hi ${name} how are you?`);
}

greetings = function(name='User'){
    console.log(`Hi ${name} how are you?`);
};


greetings = (name='User')=>{
    console.log(`Hi ${name} how are you?`);
};

greetings('Krish');

*/
/*
//Callback functions
function bill_amount(items,callback){
        let t_bill = 0;
        for(let i=0;i<items.length;i++){
            let amount = items[i];
            t_bill = amount + callback(amount);
        }
        return t_bill;
}

let total_bill_os = bill_amount([2000,3000,25000,35000],(itemPrice)=>itemPrice > 1000?itemPrice * 0.08:itemPrice * 0.03);
let total_bill_is = bill_amount([2000,3000,25000,35000],(itemPrice)=>itemPrice > 1000?itemPrice * 0.05:itemPrice * 0.02);

console.log(total_bill_os);
console.log(total_bill_is);
*/

//Arrays

// let arr = [1,2,3,4,5,6,7,8,9,10];

// for(let i=0;i<arr.length;i++){
//     console.log(arr[i]);
// }

// for(let i of arr){
//     console.log(i)
// }
// arr.forEach((ele,index)=>{
//     console.log(index,ele)
// });

// select = document.querySelector("#idCourse");
 
// let names = "html,CSS,js,jQuery,ajax,bootstrap,angular";
// let arr = names.split(",");
// let uarr = [];

// html = '<select>';
// html += '<option>Please select course</option>';
// for(let i=0;i<arr.length;i++){
//     let name = arr[i].toUpperCase();
//     html += `<option>${name}</option>`;
// }
// html += '</select>';
// select.innerHTML = html;


let numArr = [2,3,4,5,6,7,8,9,10,101,35,65];
let person = {"name":"Lakshman","age":35};
let persons = [
    {"name":"Krish","age":35},
    {"name":"Mahesh","age":45},
    {"name":"Charan","age":23},
]

let numDiv3 = numArr.filter(e => e % 3 == 0 && e % 6 != 0);
let doubleArr = numArr.map(e=>e*2);
let names = persons.map(e=>e['name']);

// function reduce(arr,f){
//     let s = arr[0];
//     for(let i=1;i<arr.length;i++){
//         s = f(s,arr[i]);
//     }
//     return s;
// }

// s = reduce([1,2,3,4,5],(a,b)=>a+b)
// console.log("Sum "+s);




// numArr = [1,2,3,4,5,6,7,8,9,10];

let sum = numArr.reduce((a,b)=>a > b?a:b);

console.log(sum);