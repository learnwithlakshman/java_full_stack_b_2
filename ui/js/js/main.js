function showTable(){
    idNumDom = document.getElementById("idNum");
    let str = "";
    if(idNumDom && idNumDom.value.length > 0){
        let num = Number.parseInt(idNumDom.value); 
        for(let i=1;i<=10;i++){
            str += `${num} * ${i}  = ${num*i}<br>`;
        }
    }

    idShowTable = document.getElementById("idShowTable");
    idShowTable.innerHTML = str;
}


function sayHello(name){
            console.log("Hello "+name);
}   