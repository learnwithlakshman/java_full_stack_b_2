// let students =[
//      {
//         regno:1001,
//         name:"Krish",
//         marks:[95,55,65,80,75],
//         total:function(){
//            return this.marks.reduce((a,b)=>a+b);
//         },
//         max: function(){
//             return this.marks.reduce((a,b)=>a>b?a:b);
//         }

//     },
//     {
//         regno:1002,
//         name:"Rajesh",
//         marks:[45,55,65,80,75],
//         total:function(){
//             return this.marks.reduce((a,b)=>a+b);
//          },
//          max: function(){
//             return this.marks.reduce((a,b)=>a>b?a:b);
//         }
//     },
//     {
//         regno:1003,
//         name:"Charan",
//         marks:[55,45,65,80,75],
//         total:function(){
//             return this.marks.reduce((a,b)=>a+b);
//          },
//          max: function(){
//             return this.marks.reduce((a,b)=>a>b?a:b);
//         }
//     }

// ]

class Student{
   
    constructor(regno,name,marks){
       this.regno = regno;
       this.name = name;
       this.marks = marks;
    }
    toString(){
        return `Regno: ${this.regno}`
    }
    total(){
        return this.marks.reduce((a,b)=>a+b); 
    }
}

students = [ new Student(1001,'Krish',[95,55,65,80,75]), 
             new Student(1006,'Manoj',[75,55,65,80,75]), 
             new Student(1005,'Rajesh',[65,55,65,80,75]),
             new Student(1004,'Jayesh',[55,55,65,80,75])];


html = '';
if(students.length >0){
showTable = document.querySelector("#showTable");

html += "<table class='table table-hover'>";
html += "<thead><tr><th>Regno</th><th>Name</th><th>Total</th></tr>";
html += "<tbody>";

students.forEach(s=>{
    html += `<tr><td>${s['regno']}</td><td>${s['name']}</td><td>${s.total()}</td></tr>`;
})
html += "</tbody></table>";
}else{
 html = 'There are no students'   
}
showTable.innerHTML = html;