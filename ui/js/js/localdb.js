


function addName(){
   
    names = localStorage.getItem("names")
    if(names){
        let l_names = JSON.parse(names);
    
        l_names.push(name);
        localStorage.setItem("names",JSON.stringify(l_names));
    
    }else{
        localStorage.setItem("names",JSON.stringify([]));
    }
}




function viewNames(){
    names = localStorage.getItem("names")
    if(names){
        let l_names = JSON.parse(names);
        for(name of l_names){
            console.log(name);
        }
    
    }else{
        console.log("Names list is empty!");
    }
}
addName()
addName()
addName()

viewNames();