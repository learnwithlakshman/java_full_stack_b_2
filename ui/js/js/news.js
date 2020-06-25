apiKey = "5c636a468a90465aa7cab199265d7299"
showResult = document.querySelector("#showResult");

subBtn = document.querySelector("#subBtn");
country = document.querySelector("#country");
category = document.querySelector("#category");


getNews('in','health');

function getNews(country,category){
    url = `https://newsapi.org/v2/top-headlines?country=${country}&category=${category}&apiKey=${apiKey}`;
    fetch(url).then(resp=>{
        return resp.json();
    }).then(result=>{
        newItems = [];
        articles = result["articles"];
        console.log(articles);
        
        for(let item of articles){
            newItems.push({"author":item["author"],"content":item["content"],"description":item["description"],"imgUrl":item["urlToImage"]});
        }
        showNewsItems(newItems);

    }).catch(error=>{
        console.log(error);
    })
}

function showNewsItems(newsItems){

    html = "";
    let i=1;
    for(let item of newsItems){
    html+=`<b>#${i++}<b><br>`

    card = `
        <div class="card mt-2">
        <img src="${item['imgUrl']}" class="card-img-top" alt="new item">
        <div class="card-body">
          <h5 class="card-title">${item['content']}</h5>
          <p class="card-text">${item['description']}</p>
          <a href="#">${item['author']}</a>
        </div>
      </div>`
      html += card;  
    }
    showResult.innerHTML = html;

}

subBtn.addEventListener('click',e=>{
    
        c = country.value;
        cat = category.value;
       getNews(c,cat);
        
})


