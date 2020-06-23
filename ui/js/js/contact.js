let contacts = [];
const idShowTable = document.querySelector("#idShowTable");
const idContactForm = document.querySelector("#idContactForm");
const idBtnSubmit = document.querySelector("#idBtnSubmit");

viewContacts(contacts);


idBtnSubmit.addEventListener('click',event=>{
      name = idContactForm.idName.value;
      email = idContactForm.idEmail.value;
      mobile = idContactForm.idMobile.value;
      cid = (Math.ceil(Math.random()) * 1000);
      contact = {"cid":cid,"name":name,"email":email,"mobile":mobile};
      addContact(contact);
      viewContacts(contacts);
      idContactForm.reset();
})

function addContact(contact) {
  contacts.push(contact);
}
function getContact(cid) {
  for (contact of contacts) {
    if (contact["cid"] == cid) {
      return contact;
    }
  }
}
function deleteContact(cid) {
  index = indexOf(cid);
  if (index != -1) {
    contacts.splice(index, 1);
  }
}
function viewContacts(contacts) {
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
                <td><i class="fas fa-edit"></i><i class="fas fa-trash ml-2"></i></td>
                
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
