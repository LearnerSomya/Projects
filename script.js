const scroll = new LocomotiveScroll({
    el: document.querySelector('#main'),
    smooth: true
});
// Mouse Circle 
function MouseCircleFollow(){
    //here mousemove is inbuilt control which refelects movement of mouse
    window.addEventListener("mousemove", function(detils){
        console.log(detils);
    })
}
MouseCircleFollow();