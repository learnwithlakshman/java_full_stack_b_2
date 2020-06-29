let contacts = [];
const idShowTable = document.querySelector("#idShowTable");
const idContactForm = document.querySelector("#idContactForm");
const idBtnSubmit = document.querySelector("#idBtnSubmit");
const idBtnUpdate = document.querySelector("#idBtnUpdate");

let editCid;
viewContacts();


idBtnUpdate.addEventListener('click',e=>{

  name = idContactForm.idName.value;
  email = idContactForm.idEmail.value;
  mobile = idContactForm.idMobile.value;
  city =  idContactForm.idCity.value;
  
  contact = {"name":name,"email":email,"mobile":mobile,"city":city};
  updateContact(contact);
  viewContacts(contacts);
  idContactForm.reset();
  idBtnSubmit.classList.remove("show");
    idBtnUpdate.classList.add("show");
})

idBtnSubmit.addEventListener('click',event=>{
      event.preventDefault();
      name = idContactForm.idName.value;
      email = idContactForm.idEmail.value;
      mobile = idContactForm.idMobile.value;
      city =  idContactForm.idCity.value;
      contact = {"name":name,"email":email,"mobile":mobile,"city":city};
      addContact(contact);
      viewContacts(contacts);
      idContactForm.reset();
})

function addContact(contact) {
  fetch('https://lwl-cb.herokuapp.com/api/capp/new', {
    method: 'POST',
    body: JSON.stringify(contact),
    headers: {
      "Content-type": "application/json; charset=UTF-8"
    }
  })
  .then(response => response.json())
  .then(json => console.log(json))

}
function getContact(cid) {
  for (contact of contacts) {
    if (contact["cid"] == cid) {
      return contact;
    }
  }
}
function edit(cid){
    idBtnSubmit.classList.add("show");
    idBtnUpdate.classList.remove("show");
    editCid = cid;
    contact = getContact(cid);
    if(contact){
      idContactForm.idName.value = contact.name
      idContactForm.idEmail.value = contact.email;
      idContactForm.idMobile.value = contact.mobile;
    }
    return;
}
function deleteContact(cid) {
  value = confirm("Are you sure do you really want to delete contact with id:"+cid+" ?");
  if(value){
  index = indexOf(cid);
  console.log("Index :"+index);
  if (index != -1) {
    contacts.splice(index, 1);
    viewContacts(contacts);
  }
}
}
function viewContacts() {
  fetch('https://lwl-cb.herokuapp.com/api/capp/getall').then(res=>{
      return res.json();
  }).then(contacts=>{
      showContacts(contacts);
  }).catch(error=>{
      console.log(error)
  })
}

function showContacts(contacts){
     html = "";
    if (contacts.length == 0) {
      html +=
        "<p class='lead'>Contacts are not yet added please add to view....</p>";
    } else {
      html = "";
      if (contacts.length > 0) {
      
        html += "<table class='table table-hover'>";
        html += "<thead><tr><th>Name</th><th>Email</th><th>Mobile</th><th>Edit/Delete</th></tr>";
        html += "<tbody>";
  
        contacts.forEach((s) => {
          html += `<tr>
                  <td>${s["name"]}</td>
                  <td>${s["email"]}</td>
                  <td>${s["mobile"]}</td>
                  <td><i class="fas fa-edit" onclick=edit(${s["cid"]})></i>
                  <i class="fas fa-trash ml-2" onclick=deleteContact(${s["cid"]})></i></td>
                  
                  </tr>`;
        });
        html += "</tbody></table>";
      } 
      idShowTable.innerHTML = html;
    }
     idShowTable.innerHTML = html;
}
function updateContact(contact) {
  index = indexOf(contact["cid"]);
  if (index != -1) {
    contacts[index] = contact;
  }
}

function indexOf(cid) {
  index = -1;
  for (let i = 0; i < contacts.length; i++) {
    let contact = contacts[i];
    if (contact["cid"] == cid) {
      index = i;
      break;
    }
  }
  return index;
}
