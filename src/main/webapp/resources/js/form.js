document.querySelectorAll("input[name='_categories']").forEach(el => el.remove()); //usuwanie elementu żeby działały cssy

function showSummary() {
    /** pobieranie kategorii */
    let category =[];
    document.querySelectorAll("input[type=checkbox]").forEach(el =>{
        if(el.checked === true){
            category.push(el.parentElement.querySelector(".description").innerHTML);
        }
    })


    let quantity = document.getElementById("quantity").value; /** pobieranie ilości worków */


    /** pobieranie wybranej instytucji */
    let institution;
    document.querySelectorAll("input[type=radio]").forEach(el => {
        if (el.checked === true) {
            institution = el.parentElement.querySelector(".title").innerHTML.substring(9); //split("“")[1];
        }
    });

    let street = document.getElementById("street").value;
    let city = document.getElementById("city").value;
    let zipCode = document.getElementById("zipCode").value;
    let pickUpDate = document.getElementById("pickUpDate").value;
    let pickUpTime = document.getElementById("pickUpTime").value;
    let pickUpComment = document.getElementById("pickUpComment").value;

    console.log(category);
    console.log(quantity);
    // console.log(institution);
    // console.log(street);
    // console.log(city);
    // console.log(zipCode);
    // console.log(pickUpDate);
    // console.log(pickUpTime);
    // console.log(pickUpComment);

    // let quantityAndCategory = document.querySelector("li .icon-bag");
    // quantityAndCategory.nextElementSibling.innerHTML =

    /** PODSUMOWANIE:
     * wstawianie ilości worków i ich zawartością
     */
    document.querySelector("li .icon-bag").nextElementSibling.innerHTML = quantity + " worki z " + category;

    document.querySelector("li .icon-hand").nextElementSibling.innerHTML = "Dla fundacji " + institution;

    let address = document.querySelectorAll("h4");
    address.forEach(el => {
        console.log(el);
        if (el == "<h4>Adres odbioru:</h4>") {
            let newLi = document.createElement("li").innerHTML = street;
            el.querySelector("ul").appendChild(newLi);

        }
    })


}
