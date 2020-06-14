const typedTextSpan = document.querySelector(".typed-text");
const cursonSpan = document.querySelector(".cursor");
const toTop = document.querySelector(".to-top");
const lang = document.getElementById("locales");
const displayText = lang.options[lang.selectedIndex].text;

const textArrayEN = ["Nice to see you here,","I'm Sebastian Smoliński", "I am Junior Java Developer"];
const textArrayPL = ["Miło Cię tu widzieć,","Nazywam się Sebastian Smoliński", "Jestem Junior Java Developerem"];
const textArray = (displayText === "Polski" ? textArrayPL : textArrayEN);


const typingDelay = 30;
const erasingDelay = 15;
const newTextDelay = 1500;

let textArrayIndex = 0;
let charIndex = 0;

function type() {
    if (charIndex < textArray[textArrayIndex].length) {
        if (!cursonSpan.classList.contains("typing")) {
            cursonSpan.classList.add("typing");
        }
        typedTextSpan.textContent += textArray[textArrayIndex].charAt(charIndex);
        charIndex++;
        setTimeout(type, typingDelay)
    } else {
        cursonSpan.classList.remove("typing")
        setTimeout(erase, newTextDelay)
    }

    function erase() {
        if (charIndex > 0) {
            if (!cursonSpan.classList.contains("typing")) cursonSpan.classList.add("typing")
            typedTextSpan.textContent = textArray[textArrayIndex].substring(0, charIndex - 1);
            charIndex--;
            setTimeout(erase, erasingDelay)
        } else {
            cursonSpan.classList.remove("typing")
            textArrayIndex++;
            if (textArrayIndex >= textArray.length) textArrayIndex = 0;
            setTimeout(type, typingDelay)
            // type
        }
    }


}

document.addEventListener("DOMContentLoaded", function () {
    if (textArray.length) {
        setTimeout(type, newTextDelay + 150)
    }
})

window.addEventListener("scroll", () => {
    if (window.pageYOffset > 100) {
        toTop.classList.add("active");
    } else {
        toTop.classList.remove("active")
    }
})