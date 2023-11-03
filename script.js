const scroll = new LocomotiveScroll({
    el: document.querySelector('#main'),
    smooth: true
});
// Mouse Circle 
function MouseCircleFollow(){
    //here mousemove is inbuilt control which refelects movement of mouse
    window.addEventListener("mousemove", function(detils){
        //console.log(detils);
        //console.log(detils.clientX, detils.clientY);
        document.querySelector("#mousecircle").style.transform = `translate(${detils.clientX}px, ${detils.clientY}px)`;
         
        //
    })
} 
MouseCircleFollow(); 