{
    let passField = document.getElementById("pass")
    let pass2Field = document.getElementById("repass")

    passField.addEventListener("focusin", () => {
        passField.classList.add("border-bottom-warning");
        pass2Field.classList.add("border-bottom-warning");
    })
    pass2Field.addEventListener("focusin", () => {
        passField.classList.add("border-bottom-warning");
        pass2Field.classList.add("border-bottom-warning");
    })

    passField.addEventListener("focusout", () => {
        if (passField.value != pass2Field.value){
            passField.classList.add("border-bottom-danger");
            pass2Field.classList.add("border-bottom-danger");
        }else {
            passField.classList.remove("border-bottom-danger", "border-bottom-warning");
            pass2Field.classList.remove("border-bottom-danger", "border-bottom-warning");
            passField.classList.add("border-bottom-success");
            pass2Field.classList.add("border-bottom-success");
        }
    })
    pass2Field.addEventListener("focusout", () => {
        if (passField.value != pass2Field.value){
            passField.classList.add("border-bottom-danger");
            pass2Field.classList.add("border-bottom-danger");
        }else{
            passField.classList.remove("border-bottom-danger", "border-bottom-warning");
            pass2Field.classList.remove("border-bottom-danger", "border-bottom-warning");
            passField.classList.add("border-bottom-success");
            pass2Field.classList.add("border-bottom-success");
        }
    })
}
