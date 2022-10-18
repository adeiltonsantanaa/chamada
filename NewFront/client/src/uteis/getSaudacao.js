export function saudacao(){
    let hora = new Date().getHours(); 
    console.log(hora)
        if(hora >= 6 && hora <= 12) {return "Boa Dia! "}
        else if (hora >= 13 && hora <= 18) {return "Boa Tarde!"}
        else if (hora > 18 && hora <= 23) {return "Boa Noite! "}
        else if (hora > 0 && hora <= 5) {return "Boa Noite! "}
    }